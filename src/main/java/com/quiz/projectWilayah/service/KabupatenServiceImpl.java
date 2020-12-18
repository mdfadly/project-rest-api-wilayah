package com.quiz.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.projectWilayah.dto.KabupatenDto;
import com.quiz.projectWilayah.entity.KabupatenEntity;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.repository.KabupatenRepository;
import com.quiz.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService{
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<KabupatenEntity> getKabupaten() {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAll();
		return kabupatenEntities;
	}

	@Override
	public List<KabupatenEntity> getKabupatenById(Integer id) {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntity = kabupatenRepository.findKabupatenActiveById(id);
		return kabupatenEntity;
	}

	@Override
	public List<KabupatenEntity> getKabupatenByCode(String code) {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntity = kabupatenRepository.findKabupatenActiveByCode(code);
		return kabupatenEntity;
	}
	
	@Override
	public List<KabupatenEntity> getKabupatenByProvinsiCode(String code) {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findByProvinsiEntityProvinsiCode(code);
		return kabupatenEntities;
	}

	@Override
	public List<KabupatenEntity> getKabupatenActive() {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAllKabupatenActive();
		return kabupatenEntities;
	}
	
	@Override
	public KabupatenEntity insertKabupaten(KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		kabupatenEntity.setKabupatenCode(dto.getKabupatenCode());
		kabupatenEntity.setKabupatenName(dto.getKabupatenName());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity deleteKabupaten(Integer id) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		kabupatenEntity.setStatus(2);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}
	
	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setKabupatenCode(dto.getKabupatenCode());
		kabupatenEntity.setKabupatenName(dto.getKabupatenName());
		
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		return kabupatenEntity;
	}

	

	
}
