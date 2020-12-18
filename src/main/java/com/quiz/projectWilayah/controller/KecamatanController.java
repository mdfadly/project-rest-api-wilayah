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

import com.quiz.projectWilayah.dto.KecamatanDto;
import com.quiz.projectWilayah.dto.StatusMessage;
import com.quiz.projectWilayah.entity.KabupatenEntity;
import com.quiz.projectWilayah.entity.KecamatanEntity;
import com.quiz.projectWilayah.service.KabupatenService;
import com.quiz.projectWilayah.service.KecamatanService;
import com.quiz.projectWilayah.service.ProvinsiService;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	
	
	@Autowired
	private KecamatanService serviceKecamatan;
	
	@Autowired
	private KabupatenService serviceKabupaten;
	
	@Autowired
	private ProvinsiService serviceProv;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getKecamatan(){
		List<KecamatanEntity> kecamatanEntities = serviceKecamatan.getKecamatan();
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getKecamatanById(@PathVariable Integer id){
//		List<KecamatanEntity> cariKecamatanEntity = serviceKecamatan.getKecamatan();
//
//		StatusMessage<KecamatanEntity> result = new StatusMessage<>();
//		for (KecamatanEntity e : cariKecamatanEntity) {
//			if(id == e.getId()) {
//				KecamatanEntity kecamatanEntity = serviceKecamatan.getKecamatanById(id);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(kecamatanEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<KecamatanEntity> kecamatanEntities = serviceKecamatan.getKecamatanById(id);
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@GetMapping("/get-by-code/{code}")
	public ResponseEntity<?> getKecamatanByCode(@PathVariable String code){
//		List<KecamatanEntity> cariKecamatanEntity = serviceKecamatan.getKecamatan();
//
//		StatusMessage<KecamatanEntity> result = new StatusMessage<>();
//		for (KecamatanEntity e : cariKecamatanEntity) {
//			if(code.equals(e.getKecamatanCode())) {
//				KecamatanEntity kecamatanEntity = serviceKecamatan.getKecamatanByCode(code);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(kecamatanEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<KecamatanEntity> kecamatanEntities = serviceKecamatan.getKecamatanByCode(code);
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@GetMapping("/get-by-code-kabupaten/{code}")
	public ResponseEntity<?> getKecamatanByCodeKabupaten(@PathVariable String code){
		List<KecamatanEntity> cariKecamatanEntity = serviceKecamatan.getKecamatanByKabupatenCode(code);
		return ResponseEntity.ok(cariKecamatanEntity);
	}
	
	@GetMapping("/get-by-code-provinsi/{code}")
	public ResponseEntity<?> getKecamatanByCodeProvinsi(@PathVariable String code){
		List<KecamatanEntity> cariKecamatanEntity = serviceKecamatan.getKecamatanByProvinsiCode(code);
		return ResponseEntity.ok(cariKecamatanEntity);
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getKecamatanActive(){
		List<KecamatanEntity> kecamatanEntities = serviceKecamatan.getKecamatanActive();
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@PostMapping("/insert-kecamatan")
	public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto dto){
		StatusMessage<KecamatanEntity> result = new StatusMessage<>();
		if(dto.getKecamatanCode().length() != 8) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Kecamatan tidak 8 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getKecamatanName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Kecamatan tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				KecamatanEntity kecamatanEntity = serviceKecamatan.insertKecamatan(dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Add Data!");
				result.setData(kecamatanEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@PutMapping("/update-kecamatan/{id}")
	public ResponseEntity<?> updateKecamatan(@PathVariable Integer id, @RequestBody KecamatanDto dto){
		StatusMessage<KecamatanEntity> result = new StatusMessage<>();
		if(dto.getKecamatanCode().length() != 8) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Kecamatan tidak 8 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getKecamatanName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Kecamatan tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				KecamatanEntity kecamatanEntity = serviceKecamatan.updateKecamatan(id, dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Update Data!");
				result.setData(kecamatanEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@DeleteMapping("/delete-kecamatan/{id}")
	public ResponseEntity<?> deleteKecamatan(@PathVariable Integer id){
		List<KecamatanEntity> kecamatanEntities = serviceKecamatan.getKecamatan();
		
		StatusMessage<KecamatanEntity> result = new StatusMessage<>();
		for (KecamatanEntity e : kecamatanEntities) {
			if(id == e.getId()) {
				KecamatanEntity kecamatanEntity = serviceKecamatan.deleteKecamatan(id);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success!");
				result.setData(kecamatanEntity);
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
