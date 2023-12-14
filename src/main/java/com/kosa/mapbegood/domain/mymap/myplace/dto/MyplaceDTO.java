package com.kosa.mapbegood.domain.mymap.myplace.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kosa.mapbegood.domain.mymap.favorite.dto.ThemeMapDto;
import com.kosa.mapbegood.domain.place.dto.PlaceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class MyplaceDTO {

	private Long id;
	
	private ThemeMapDto thememapId;

	private PlaceDTO placeId;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date visitedAt;
	
}
