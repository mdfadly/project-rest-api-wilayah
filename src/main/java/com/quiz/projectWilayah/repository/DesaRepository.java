package com.quiz.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.projectWilayah.entity.DesaEntity;
import com.quiz.projectWilayah.entity.KecamatanEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer>{
	
	List<DesaEntity> findByKecamatanEntityKecamatanCode(String kecamatanCode);
	List<DesaEntity> findByProvinsiEntityProvinsiCode(String provinsiCode);
	List<DesaEntity> findByKabupatenEntityKabupatenCode(String kabupatenCode);
	
	@Query(value = "select * from desa_entity where status = 1 and id = ?", nativeQuery = true)
	List<DesaEntity> findDesaActiveById(Integer id);
	
	@Query(value = "select * from desa_entity where status = 1 and desa_code = ?", nativeQuery = true)
	List<DesaEntity> findDesaActiveByCode(String code);
	
	@Query(value = "select * from desa_entity where status = 1", nativeQuery = true)
	List<DesaEntity> findAllDesaActive();

}
