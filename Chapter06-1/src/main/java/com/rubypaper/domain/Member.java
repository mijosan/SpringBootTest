package com.rubypaper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	@GeneratedValue
	private String id;
	private String password;
	private String name;
	private String role;
	private boolean enabled;
	
}
