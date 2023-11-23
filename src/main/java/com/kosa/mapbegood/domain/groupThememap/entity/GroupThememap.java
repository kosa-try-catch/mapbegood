package com.kosa.mapbegood.domain.groupThememap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kosa.mapbegood.domain.groups.entity.Groups;
import com.kosa.mapbegood.domain.ourplace.entity.Ourplace;

import lombok.Data;

@Data
@Entity
@Table
public class GroupThememap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "GroupsId")
	private Groups groupId;
	
	private String name;
	
	private String color;
	
	private String memo;
	
	@OneToMany(mappedBy = "groupThememapId", cascade = CascadeType.REMOVE)
	private List<Ourplace> ourplaceList;
}
