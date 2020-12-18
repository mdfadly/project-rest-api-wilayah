package com.quiz.projectWilayah.service;

import java.util.List;

import com.quiz.projectWilayah.dto.KabupatenDto;
import com.quiz.projectWilayah.entity.KabupatenEntity;

public interface KabupatenService {
	public List<KabupatenEntity> getKabupaten();
	public List<KabupatenEntity> getKabupatenByProvinsiCode(String code);
	public List<KabupatenEntity> getKabupatenById(Integer id);
	public List<KabupatenEntity> getKabupatenByCode(String code);
	public List<KabupatenEntity> getKabupatenActive();
	public KabupatenEntity insertKabupaten(KabupatenDto dto);
	public KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto);
	public KabupatenEntity deleteKabupaten(Integer id);
}
