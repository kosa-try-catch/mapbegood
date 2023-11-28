package com.kosa.mapbegood.domain.ourmap.memberGroup.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MemberGroupEmbedded implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "member_email")
	private String email;
	
	@Column(name = "group_id")
	private Long groupsId;
}
