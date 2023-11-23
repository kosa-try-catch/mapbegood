package com.kosa.mapbegood.domain.waiting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kosa.mapbegood.domain.groups.entity.Groups;
import com.kosa.mapbegood.domain.member.entity.Member;

import lombok.Data;

@Data
@Entity
@Table
public class Waiting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "GroupsId")
	private Groups groupId;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Member memberNickname;
	
}
