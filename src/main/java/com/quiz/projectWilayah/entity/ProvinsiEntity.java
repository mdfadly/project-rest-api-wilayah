package com.quiz.projectWilayah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="provinsi_entity")
public class ProvinsiEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="provinsi_code", length=2, nullable=false, unique=true)
	private String provinsiCode;
	
	@Column(name="provinsi_name", length=255, nullable=false)
	private String provinsiName;
	
	@Column(name = "status", length=1, nullable=false)
	private Integer status;
}
