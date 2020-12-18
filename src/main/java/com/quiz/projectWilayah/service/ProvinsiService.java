package com.quiz.projectWilayah.service;

import java.util.List;

import com.quiz.projectWilayah.dto.ProvinsiDto;
import com.quiz.projectWilayah.entity.ProvinsiEntity;

public interface ProvinsiService {
	
	public List<ProvinsiEntity> getProvinsi();
	public List<ProvinsiEntity> getProvinsiById(Integer idProv);
	public List<ProvinsiEntity> getProvinsiByCode(String codeProv);
	public List<ProvinsiEntity> getProvinsiActive();
	public ProvinsiEntity insertProvinsi(ProvinsiDto dto);
	public ProvinsiEntity updateProvinsi(Integer idProv, ProvinsiDto dto);
	public ProvinsiEntity deleteProvinsi(Integer idProv);
}
