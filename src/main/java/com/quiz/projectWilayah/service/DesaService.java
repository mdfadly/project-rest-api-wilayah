package com.quiz.projectWilayah.service;

import java.util.List;

import com.quiz.projectWilayah.dto.DesaDto;
import com.quiz.projectWilayah.entity.DesaEntity;

public interface DesaService {
	public List<DesaEntity> getDesa();
	public List<DesaEntity> getDesaActive();
	public List<DesaEntity> getDesaByKecamatanCode(String code);
	public List<DesaEntity> getDesaByKabupatenCode(String code);
	public List<DesaEntity> getDesaByProvinsiCode(String code);
	public List<DesaEntity> getDesaById(Integer id);
	public List<DesaEntity> getDesaByCode(String code);
	
	public DesaEntity insertDesa(DesaDto dto);
	public DesaEntity updateDesa(Integer id, DesaDto dto);
	public DesaEntity deleteDesa(Integer id);
}
