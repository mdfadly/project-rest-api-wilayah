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

import com.quiz.projectWilayah.dto.ProvinsiDto;
import com.quiz.projectWilayah.dto.StatusMessage;
import com.quiz.projectWilayah.entity.ProvinsiEntity;
import com.quiz.projectWilayah.repository.ProvinsiRepository;
import com.quiz.projectWilayah.service.ProvinsiServiceImpl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {

	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Autowired
	private ProvinsiServiceImpl serviceProv;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getProvinsi(){
		List<ProvinsiEntity> provinsiEntity = serviceProv.getProvinsi();
		return ResponseEntity.ok(provinsiEntity);	
	}
	
	@GetMapping("/get-by-id/{idProv}")
	public ResponseEntity<?> getProvinsiById(@PathVariable Integer idProv){
//		List<ProvinsiEntity> cariprovinsiEntity = serviceProv.getProvinsi();
//
//		StatusMessage<ProvinsiEntity> result = new StatusMessage<>();
//		for (ProvinsiEntity e : cariprovinsiEntity) {
//			if(idProv == e.getId()) {
//				ProvinsiEntity provinsiEntity = serviceProv.getProvinsiById(idProv);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(provinsiEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<ProvinsiEntity> provinsiEntity = serviceProv.getProvinsiById(idProv);
		return ResponseEntity.ok(provinsiEntity);	
	}
	
	@GetMapping("/get-by-code/{codeProv}")
	public ResponseEntity<?> getProvinsiByCode(@PathVariable String codeProv){
//		List<ProvinsiEntity> cariprovinsiEntity = serviceProv.getProvinsi();
//
//		StatusMessage<ProvinsiEntity> result = new StatusMessage<>();
//		for (ProvinsiEntity e : cariprovinsiEntity) {
//			if(codeProv.equals(e.getProvinsiCode())) {
//				ProvinsiEntity provinsiEntity = serviceProv.getProvinsiByCode(codeProv);
//				result.setStatus(HttpStatus.OK.value());
//				result.setMessage("Success!");
//				result.setData(provinsiEntity);
//				break;
//			}else {
//				result.setStatus(HttpStatus.NO_CONTENT.value());
//				result.setMessage("no data found");
//				result.setData(null);
//			}
//		}
//		
//		return ResponseEntity.ok(result);
		List<ProvinsiEntity> provinsiEntity = serviceProv.getProvinsiByCode(codeProv);
		return ResponseEntity.ok(provinsiEntity);	
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getProvinsiActive(){
		List<ProvinsiEntity> provinsiEntity = serviceProv.getProvinsiActive();
		return ResponseEntity.ok(provinsiEntity);	
	}
	
	@PostMapping("/insert-provinsi")
	public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto dto){
		StatusMessage<ProvinsiEntity> result = new StatusMessage<>();
		if(dto.getProvinsiCode().length() != 2) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code provinsi tidak 2 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getProvinsiName().equals("")) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Provinsi tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				ProvinsiEntity provinsiEntity = serviceProv.insertProvinsi(dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Add Data!");
				result.setData(provinsiEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@PutMapping("/update-provinsi/{idProv}")
	public ResponseEntity<?> updateProvinsi (@PathVariable Integer idProv, @RequestBody ProvinsiDto dto){
		StatusMessage<ProvinsiEntity> result = new StatusMessage<>();
		if(dto.getProvinsiCode().length() != 2) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Code provinsi tidak 2 digit");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			if(dto.getProvinsiName().equals("")) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama Provinsi tidak sesuai");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			}else {
				ProvinsiEntity provinsiEntity = serviceProv.updateProvinsi(idProv, dto);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Update Data!");
				result.setData(provinsiEntity);
				return ResponseEntity.ok(result);				
			}
		}
	}
	
	@DeleteMapping("/delete-provinsi/{idProv}")
	public ResponseEntity<?> deleteProvinsi (@PathVariable Integer idProv){
		List<ProvinsiEntity> cariprovinsiEntity = serviceProv.getProvinsi();

		StatusMessage<ProvinsiEntity> result = new StatusMessage<>();
		for (ProvinsiEntity e : cariprovinsiEntity) {
			if(idProv == e.getId()) {
				ProvinsiEntity provinsiEntity = serviceProv.deleteProvinsi(idProv);
				result.setStatus(HttpStatus.OK.value());
				result.setMessage("Success Delete Data!");
				result.setData(provinsiEntity);
				break;
			}else {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Tidak Ada data");
				result.setData(null);
			}
		}
		return ResponseEntity.ok(result);
	}
	
}
