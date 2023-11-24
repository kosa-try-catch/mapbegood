package com.kosa.mapbegood.domain.mymap.myplaceFeed.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Embeddable
public class MyplaceFeedEmbedded implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "myplace_id")
	private Long myplaceId;
	
	@Column(name = "member_nickname")
	private String nickname;
}
