package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue
	private Long seq;
	
	private String title;
	
	@Column(updatable=false)
	private String writer;
	
	private String content;
	
	@Column(insertable=false, updatable=false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
	private Date createDate;
	
	@Column(insertable=false, updatable=false, columnDefinition = "bigint default 0")
	private Long cnt;
}
