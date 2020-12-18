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
@Table(name = "desa_entity")
public class DesaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "desa_code", unique=true, length=13, nullable=false)
	private String desaCode;
	
	@Column(name = "desa_name", length=255, nullable=false)
	private String desaName;
	
	@ManyToOne
	@JoinColumn(name = "kecamatan_code", referencedColumnName = "kecamatan_code")
	private KecamatanEntity kecamatanEntity;
	
	@ManyToOne
	@JoinColumn(name = "kabupaten_code", referencedColumnName = "kabupaten_code")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn(name = "provinsi_code", referencedColumnName = "provinsi_code")
	private ProvinsiEntity provinsiEntity;
	
	@Column(name = "status", length=1, nullable=false, columnDefinition = "integer default 1")
	private Integer status;
}
