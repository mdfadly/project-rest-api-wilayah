package com.quiz.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.projectWilayah.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {
	
	ProvinsiEntity findByProvinsiCode(String provinsiCode);
	
	
	@Query(value = "select * from provinsi_entity where status = 1 and id = ?", nativeQuery = true)
	List<ProvinsiEntity> findProvinsiActiveById(Integer id);
	
	@Query(value = "select * from provinsi_entity where status = 1 and provinsi_code = ?", nativeQuery = true)
	List<ProvinsiEntity> findProvinsiActiveByCode(String provinsiCode);
	
	@Query(value = "select * from provinsi_entity where status = 1", nativeQuery = true)
	List<ProvinsiEntity> findAllProvinsiActive();
	
}
