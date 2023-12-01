package com.kosa.mapbegood.domain.mymap.favorite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//필요한 import 문 추가
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Response;
import com.kosa.mapbegood.domain.mymap.favorite.dto.FavoriteDto;
import com.kosa.mapbegood.domain.mymap.favorite.service.FavoriteService;

@RestController
@RequestMapping("/favoritemap")
public class FavoriteController {

 private final FavoriteService favoriteService;

 @Autowired
 public FavoriteController(FavoriteService favoriteService) {
     this.favoriteService = favoriteService;
 }

 
 //requestbody 요청 : 클라이언트-> 서버
 //responsebody 응답: 서버-> 클라이언트
 
 
 @PostMapping
 public ResponseEntity<String> createFavorite(@RequestBody FavoriteDto favoriteDto) {
     try {
         favoriteService.createFavorite(favoriteDto);
         return new ResponseEntity<>("즐겨찾기 생성 되었습니다.", HttpStatus.CREATED);
     } catch (Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }
 }
 
// //리스트 상세조회
// @GetMapping("/list/{email}")
// public ResponseEntity<List<FavoriteDto>> selectFavoriteList(@PathVariable String email) {
//     
//	 List<FavoriteDto> favoriteList = favoriteService.selectFavoriteList(email);
//     if (!favoriteList.isEmpty()) {
//    	 
//         return new ResponseEntity<>(favoriteList, HttpStatus.OK);
//     } else {
//         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
// }  
 
//    @GetMapping("/list")
//    public ResponseEntity<List<FavoriteDto>> selectAllFavoriteList(@ResponseBody FavoriteDto favoriteDto){
//    	
//    	return null;
//    }
// }

