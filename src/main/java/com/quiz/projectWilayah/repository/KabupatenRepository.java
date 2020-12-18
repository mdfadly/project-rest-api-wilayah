package com.quiz.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.projectWilayah.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	KabupatenEntity findByKabupatenCode(String kabupatenCode);
	List<KabupatenEntity> findByProvinsiEntityProvinsiCode(String provinsiCode);
	
	@Query(value = "select * from kabupaten_entity where status = 1 and id = ?", nativeQuery = true)
	List<KabupatenEntity> findKabupatenActiveById(Integer id);
	
	@Query(value = "select * from kabupaten_entity where status = 1 and kabupaten_code = ?", nativeQuery = true)
	List<KabupatenEntity> findKabupatenActiveByCode(String provinsiCode);
	
	@Query(value = "select * from kabupaten_entity where status = 1", nativeQuery = true)
	List<KabupatenEntity> findAllKabupatenActive();
}
