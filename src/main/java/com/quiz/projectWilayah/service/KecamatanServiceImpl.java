package com.quiz.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.projectWilayah.dto.KecamatanDto;
import com.quiz.projectWilayah.entity.KabupatenEntity;
import com.quiz.projectWilayah.entity.KecamatanEntity;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.repository.KabupatenRepository;
import com.quiz.projectWilayah.repository.KecamatanRepository;
import com.quiz.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService{
	
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;

	@Override
	public List<KecamatanEntity> getKecamatan() {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findAll();
		return kecamatanEntities;
	}
	
	@Override
	public List<KecamatanEntity> getKecamatanActive() {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findAllKecamatanActive();
		return kecamatanEntities;
	}

	@Override
	public List<KecamatanEntity> getKecamatanByKabupatenCode(String code) {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findByKabupatenEntityKabupatenCode(code);
		return kecamatanEntities;
	}

	@Override
	public List<KecamatanEntity> getKecamatanByProvinsiCode(String code) {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findByProvinsiEntityProvinsiCode(code);
		return kecamatanEntities;
	}

	@Override
	public List<KecamatanEntity> getKecamatanById(Integer id) {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntity = kecamatanRepository.findKecamatanActiveById(id);
		return kecamatanEntity;
	}

	@Override
	public List<KecamatanEntity> getKecamatanByCode(String code) {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntity = kecamatanRepository.findKecamatanActiveByCode(code);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity insertKecamatan(KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = convertToKecamatanEntity(dto);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		kecamatanEntity.setKecamatanCode(dto.getKecamatanCode());
		kecamatanEntity.setKecamatanName(dto.getKecamatanName());
		
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKabupatenCode(dto.getKabupatenCode());
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		
		kecamatanRepository.save(kecamatanEntity);
		
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity deleteKecamatan(Integer id) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		kecamatanEntity.setStatus(2);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}
	
	public KecamatanEntity convertToKecamatanEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setKecamatanCode(dto.getKecamatanCode());
		kecamatanEntity.setKecamatanName(dto.getKecamatanName());
		kecamatanEntity.setStatus(1);
		
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKabupatenCode(dto.getKabupatenCode());
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		return kecamatanEntity;
	}

	

}
