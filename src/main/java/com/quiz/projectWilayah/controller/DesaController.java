package com.quiz.projectWilayah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.projectWilayah.dto.DesaDto;
import com.quiz.projectWilayah.dto.KecamatanDto;
import com.quiz.projectWilayah.dto.StatusMessage;
import com.quiz.projectWilayah.entity.DesaEntity;
import com.quiz.projectWilayah.entity.KecamatanEntity;
import com.quiz.projectWilayah.service.DesaServiceImpl;

@RestController
@RequestMapping("/desa")
public class DesaController {
	
	@Autowired
	private DesaServiceImpl serviceDesa;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getDesa(){
		List<DesaEntity> desaEntities = serviceDesa.getDesa();
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getDesaActive(){
		List<DesaEntity> desaEntities = serviceDesa.getDesaActive();
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getDesaById(@PathVariable Integer id){
		List<DesaEntity> desaEntities = serviceDesa.getDesaById(id);
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-code/{code}")
	public ResponseEntity<?> getDesaByCode(@PathVariable String code){
		List<DesaEntity> desaEntities = serviceDesa.getDesaByCode(code);
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-code-provinsi/{code}")
	public ResponseEntity<?> getDesaByCodeProvinsi(@PathVariable String code){
		List<DesaEntity> desaEntities = serviceDesa.getDesaByProvinsiCode(code);
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-code-kabupaten/{code}")
	public ResponseEntity<?> getDesaByCodeKabupaten(@PathVariable String code){
		List<DesaEntity> desaEntities = serviceDesa.getDesaByKabupatenCode(code);
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-code-kecamatan/{code}")
	public ResponseEntity<?> getDesaByCodeKecamatan(@PathVariable String code){
		List<DesaEntity> desaEntities = serviceDesa.getDesaByKecamatanCode(code);
		return ResponseEntity.ok(desaEntities);
	}
	
	@PostMapping("/insert-desa")
	public ResponseEntity<?> insertDesa(@RequestBody DesaDto dto){
		StatusMessage<DesaEntity> result = new StatusMessage<>();
		if(dto.getDesaCode().length() != 13) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Desa tidak 13 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getDesaName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Desa tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				DesaEntity desaEntity = serviceDesa.insertDesa(dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Add Data!");
				result.setData(desaEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@PutMapping("/update-desa/{id}")
	public ResponseEntity<?> updateDesa(@PathVariable Integer id, @RequestBody DesaDto dto){
		StatusMessage<DesaEntity> result = new StatusMessage<>();
		if(dto.getDesaCode().length() != 13) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Desa tidak 13 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getDesaName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Desa tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				DesaEntity desaEntity = serviceDesa.updateDesa(id, dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Update Data!");
				result.setData(desaEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@DeleteMapping("/delete-desa/{id}")
	public ResponseEntity<?> deleteDesa(@PathVariable Integer id){
		List<DesaEntity> desaEntities = serviceDesa.getDesa();
		
		StatusMessage<DesaEntity> result = new StatusMessage<>();
		for (DesaEntity e : desaEntities) {
			if(id == e.getId()) {
				DesaEntity desaEntity = serviceDesa.deleteDesa(id);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success!");
				result.setData(desaEntity);
				break;
			}else {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("no data found");
				result.setData(null);
			}
		}
		
		if(result.getStatus() == 200) {			
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
}
