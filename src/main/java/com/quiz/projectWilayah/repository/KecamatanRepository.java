package com.quiz.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.projectWilayah.entity.KecamatanEntity;
import com.quiz.projectWilayah.entity.ProvinsiEntity;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer>{
	
	KecamatanEntity findByKecamatanCode(String kecamatanCode);
	List<KecamatanEntity> findByProvinsiEntityProvinsiCode(String provinsiCode);
	List<KecamatanEntity> findByKabupatenEntityKabupatenCode(String kabupatenCode);
	
	@Query(value = "select * from kecamatan_entity where status = 1 and id = ?", nativeQuery = true)
	List<KecamatanEntity> findKecamatanActiveById(Integer id);
	
	@Query(value = "select * from kecamatan_entity where status = 1 and kecamatan_code = ?", nativeQuery = true)
	List<KecamatanEntity> findKecamatanActiveByCode(String code);
	
	@Query(value = "select * from kecamatan_entity where status = 1", nativeQuery = true)
	List<KecamatanEntity> findAllKecamatanActive();
}
