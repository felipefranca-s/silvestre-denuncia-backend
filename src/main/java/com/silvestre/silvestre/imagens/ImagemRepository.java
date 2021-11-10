package com.silvestre.silvestre.imagens;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImagemRepository extends JpaRepository<Imagem, Long>{
	
	 @Query(value = "SELECT * FROM imagem where denuncia_id = ?1",
	            nativeQuery = true)
	    Optional<Imagem> findByDenunciaId(Long denunciaId);
}