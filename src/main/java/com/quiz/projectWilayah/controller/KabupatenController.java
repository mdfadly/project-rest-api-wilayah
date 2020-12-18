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

import com.quiz.projectWilayah.dto.KabupatenDto;
import com.quiz.projectWilayah.dto.StatusMessage;
import com.quiz.projectWilayah.entity.KabupatenEntity;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.service.KabupatenService;
import com.quiz.projectWilayah.service.ProvinsiService;
import com.quiz.projectWilayah.service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	
	@Autowired
	private KabupatenService serviceKabupaten;
	
	@Autowired
	private ProvinsiService serviceProv;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getKabupaten(){
		List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupaten();
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getKabupatenById(@PathVariable Integer id){
//		List<KabupatenEntity> cariKabupatenEntity = serviceKabupaten.getKabupaten();
//
//		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
//		for (KabupatenEntity e : cariKabupatenEntity) {
//			if(id == e.getId()) {
//				KabupatenEntity kabupatenEntity = serviceKabupaten.getKabupatenById(id);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(kabupatenEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupatenById(id);
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("/get-by-code/{code}")
	public ResponseEntity<?> getKabupatenByCode(@PathVariable String code){
//		List<KabupatenEntity> cariKabupatenEntity = serviceKabupaten.getKabupaten();
//
//		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
//		for (KabupatenEntity e : cariKabupatenEntity) {
//			if(code.equals(e.getKabupatenCode())) {
//				KabupatenEntity kabupatenEntity = serviceKabupaten.getKabupatenByCode(code);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(kabupatenEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupatenByCode(code);
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("/get-by-code-provinsi/{code}")
	public ResponseEntity<?> getKabupatenByProvinsiCode(@PathVariable String code){
//		List<ProvinsiEntity> cariprovinsiEntity = serviceProv.getProvinsi();
//
//		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
//		for (ProvinsiEntity e : cariprovinsiEntity) {
//			if(code.equals(e.getProvinsiCode())) {
//				List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupatenByProvinsiCode(code);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupatenByProvinsiCode(code);
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getKabupatenActive(){
		List<KabupatenEntity> kabupatenEntities = serviceKabupaten.getKabupatenActive();
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	
	@PostMapping("/insert-kabupaten")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto dto){
		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
		if(dto.getKabupatenCode().length() != 2) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Kabupaten tidak 2 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getKabupatenName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Kabupaten tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				KabupatenEntity kabupatenEntity = serviceKabupaten.insertKabupaten(dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Add Data!");
				result.setData(kabupatenEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@PutMapping("/update-kabupaten/{id}")
	public ResponseEntity<?> updateKabupaten(@PathVariable Integer id, @RequestBody KabupatenDto dto){
		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
		if(dto.getKabupatenCode().length() != 2) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code Kabupaten tidak 2 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getKabupatenName().length() < 1) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Kabupaten tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				KabupatenEntity kabupatenEntity = serviceKabupaten.updateKabupaten(id, dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Update Data!");
				result.setData(kabupatenEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@DeleteMapping("/delete-kabupaten/{id}")
	public ResponseEntity<?> deleteKabupaten(@PathVariable Integer id){
		List<KabupatenEntity> cariKabupatenEntity = serviceKabupaten.getKabupaten();

		StatusMessage<KabupatenEntity> result = new StatusMessage<>();
		for (KabupatenEntity e : cariKabupatenEntity) {
			if(id == e.getId()) {
				KabupatenEntity kabupatenEntity = serviceKabupaten.deleteKabupaten(id);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Delete Data!");
				result.setData(kabupatenEntity);
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
