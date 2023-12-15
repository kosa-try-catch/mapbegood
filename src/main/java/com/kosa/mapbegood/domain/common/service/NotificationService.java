package com.kosa.mapbegood.domain.common.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.kosa.mapbegood.domain.common.repository.EmitterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
    // 기본 타임아웃 설정
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;

    private final EmitterRepository emitterRepository;

    /**
     * 클라이언트가 구독을 위해 호출하는 메서드.
     * @param userEmail - 구독하는 클라이언트의 사용자 이메일.
     * @return SseEmitter - 서버에서 보낸 이벤트 Emitter
     */
    public SseEmitter subscribe(String userEmail) {
        SseEmitter emitter = createEmitter(userEmail);

        sendToClient(userEmail, "EventStream Created. [userEmail=" + userEmail + "]");
        return emitter;
    }

    
    /**
     * 서버의 이벤트를 클라이언트에게 보내는 메서드
     * 다른 서비스 로직에서 이 메서드를 사용해 데이터를 Object event에 넣고 전송하면 된다.
     * @param userEmail - 메세지를 전송할 사용자의 이메일.
     * @param event  - 전송할 이벤트 객체.
     */
    public void notify(String userEmail, Object event) {
        sendToClient(userEmail, event);
    }

    
    
    /**
     * 그룹초대 알림
     * @param userEmail
     * @param groupName
     * @param leaderNickname
     */
    public void notifyGroupInvitation(String userEmail, String groupName, String leaderNickname) {
        String message = leaderNickname + "님이 " + groupName + "그룹에 초대를 요청했습니다";
        notify(userEmail, message);
        
        //String email = authenticationUtil.getUserEmail(authentication);
//        notificationService.notify(email, "data");
    }

    
    
    /**
     * 클라이언트에게 데이터를 전송
     * @param userEmail - 데이터를 받을 사용자의 이메일.
     * @param data - 전송할 데이터.
     */
    private void sendToClient(String userEmail, Object data) {
        SseEmitter emitter = emitterRepository.get(userEmail);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().id(userEmail).name("sse").data(data));
            } catch (IOException exception) {
                emitterRepository.deleteById(userEmail);
                emitter.completeWithError(exception);
            }
        }
    }

    /**
     * 사용자 아이디를 기반으로 이벤트 Emitter를 생성
     * @param userEmail - 사용자 이메일.
     * @return SseEmitter - 생성된 이벤트 Emitter.
     */
    private SseEmitter createEmitter(String userEmail) {
    	SseEmitter emitter = emitterRepository.get(userEmail);
    	if(emitter == null) {
    		emitter = new SseEmitter(DEFAULT_TIMEOUT);
    	}
//    	SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepository.save(userEmail, emitter);

        // Emitter가 완료될 때(모든 데이터가 성공적으로 전송된 상태) Emitter를 삭제한다.
        emitter.onCompletion(() -> emitterRepository.deleteById(userEmail));
        // Emitter가 타임아웃 되었을 때(지정된 시간동안 어떠한 이벤트도 전송되지 않았을 때) Emitter를 삭제한다.
        emitter.onTimeout(() -> emitterRepository.deleteById(userEmail));

        return emitter;
    }
    
    
}