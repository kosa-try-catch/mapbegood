package com.kosa.mapbegood.domain.ourmap.waiting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.mapbegood.domain.ourmap.waiting.entity.Waiting;
import com.kosa.mapbegood.exception.FindException;

public interface WaitingRepository extends JpaRepository<Waiting, Long>{
	
	public Optional<Waiting> findByGroupIdAndMemberEmail(Long groupId, String memberEmail) throws FindException;
	public List<Waiting> findByGroupId(Long groupId) throws FindException;
}
