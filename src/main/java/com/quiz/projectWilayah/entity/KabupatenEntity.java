package com.quiz.projectWilayah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="kabupaten_entity")
public class KabupatenEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="kabupaten_code", unique=true, length=2, nullable=false)
	private String kabupatenCode;
	
	@Column(name="kabupaten_name", length=255, nullable=false)
	private String kabupatenName;
	
	@ManyToOne
	@JoinColumn(name="provinsi_code", referencedColumnName = "provinsi_code")
	private ProvinsiEntity provinsiEntity;
	
	@Column(name = "status", length=1, nullable=false, columnDefinition = "integer default 1")
	private Integer status;
}
