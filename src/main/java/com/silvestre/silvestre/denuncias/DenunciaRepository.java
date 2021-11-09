
package com.silvestre.silvestre.denuncias;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{

//    @Query(nativeQuery = true, value="SELECT * FROM denuncia where codigo = ?1")
////    Denuncia findByCodigo(String codigo);

    @Query(value = "SELECT * FROM denuncia where codigo = ?1",
            nativeQuery = true)
    Denuncia findByCodigo(String codigo);
}