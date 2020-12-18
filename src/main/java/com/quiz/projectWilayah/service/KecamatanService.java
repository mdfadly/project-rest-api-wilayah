package com.quiz.projectWilayah.service;

import java.util.List;

import com.quiz.projectWilayah.dto.KecamatanDto;
import com.quiz.projectWilayah.entity.KecamatanEntity;

public interface KecamatanService {
	public List<KecamatanEntity> getKecamatan();
	public List<KecamatanEntity> getKecamatanActive();
	public List<KecamatanEntity> getKecamatanByKabupatenCode(String code);
	public List<KecamatanEntity> getKecamatanByProvinsiCode(String code);
	public List<KecamatanEntity> getKecamatanById(Integer id);
	public List<KecamatanEntity> getKecamatanByCode(String code);
	public KecamatanEntity insertKecamatan(KecamatanDto dto);
	public KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto);
	public KecamatanEntity deleteKecamatan(Integer id);
}
