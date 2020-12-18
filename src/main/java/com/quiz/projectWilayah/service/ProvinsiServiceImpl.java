package com.quiz.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.projectWilayah.dto.ProvinsiDto;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {

	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<ProvinsiEntity> getProvinsi() {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findAll();
		return provinsiEntities;
	}
	
	@Override
	public List<ProvinsiEntity> getProvinsiActive() {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findAllProvinsiActive();
		return provinsiEntities;
	}


	@Override
	public ProvinsiEntity insertProvinsi(ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = convertToProvinsiEntity(dto);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity updateProvinsi(Integer idProv, ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProv).get();
		provinsiEntity.setProvinsiCode(dto.getProvinsiCode());
		provinsiEntity.setProvinsiName(dto.getProvinsiName());
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity deleteProvinsi(Integer idProv) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProv).get();
		provinsiEntity.setStatus(2);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	
	@Override
	public List<ProvinsiEntity> getProvinsiById(Integer idProv) {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntity = provinsiRepository.findProvinsiActiveById(idProv);
		return provinsiEntity;
	}

	@Override
	public List<ProvinsiEntity> getProvinsiByCode(String codeProv) {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntity = provinsiRepository.findProvinsiActiveByCode(codeProv);
		return provinsiEntity;
	}
	
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setProvinsiCode(dto.getProvinsiCode());
		provinsiEntity.setProvinsiName(dto.getProvinsiName());
		provinsiEntity.setStatus(1);
		return provinsiEntity;
	}

	

}
