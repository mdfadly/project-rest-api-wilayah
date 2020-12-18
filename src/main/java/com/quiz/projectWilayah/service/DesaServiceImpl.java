package com.quiz.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.projectWilayah.dto.DesaDto;
import com.quiz.projectWilayah.entity.DesaEntity;
import com.quiz.projectWilayah.entity.KabupatenEntity;
import com.quiz.projectWilayah.entity.KecamatanEntity;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.repository.DesaRepository;
import com.quiz.projectWilayah.repository.KabupatenRepository;
import com.quiz.projectWilayah.repository.KecamatanRepository;
import com.quiz.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService {

	
	@Autowired
	private DesaRepository desaRepository;
	
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public List<DesaEntity> getDesa() {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findAll();
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaActive() {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findAllDesaActive();
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaByKecamatanCode(String code) {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findByKecamatanEntityKecamatanCode(code);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaByKabupatenCode(String code) {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findByKabupatenEntityKabupatenCode(code);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaByProvinsiCode(String code) {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findByProvinsiEntityProvinsiCode(code);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaById(Integer id) {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findDesaActiveById(id);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getDesaByCode(String code) {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findDesaActiveByCode(code);
		return desaEntities;
	}

	@Override
	public DesaEntity insertDesa(DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = converDesaEntity(dto);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity updateDesa(Integer id, DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaEntity.setDesaCode(dto.getDesaCode());
		desaEntity.setDesaName(dto.getDesaName());
		
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		desaEntity.setProvinsiEntity(provinsiEntity);
		
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKabupatenCode(dto.getKabupatenCode());
		desaEntity.setKabupatenEntity(kabupatenEntity);
		
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity deleteDesa(Integer id) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaEntity.setStatus(2);
		desaRepository.save(desaEntity);
		return desaEntity;
	}
	
	public DesaEntity converDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setDesaCode(dto.getDesaCode());
		desaEntity.setDesaName(dto.getDesaName());
		desaEntity.setStatus(1);
		
		ProvinsiEntity provinsiEntity = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
		desaEntity.setProvinsiEntity(provinsiEntity);
		
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKabupatenCode(dto.getKabupatenCode());
		desaEntity.setKabupatenEntity(kabupatenEntity);
		
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		
		return desaEntity;
	}

}
