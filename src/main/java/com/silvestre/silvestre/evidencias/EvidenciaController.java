package com.silvestre.silvestre.evidencias;


import com.silvestre.silvestre.denuncias.Denuncia;
import com.silvestre.silvestre.denuncias.DenunciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evidencias")
@AllArgsConstructor
public class EvidenciaController {

    @Autowired
    EvidenciaRepository repository;

    @GetMapping("/retornaTodos")
    List<Evidencia> todosEvidencias(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Evidencia> retornaEvidencia(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/novo")
    Evidencia novaEvidencia(@RequestBody Evidencia evidencia) {
        return repository.save(evidencia);
    }

    @PutMapping("/{id}")
    Evidencia atualizaEvidencia(@RequestBody Evidencia evidencia, @PathVariable Long id) {
        evidencia.setId(id);
        return repository.save(evidencia);
    }

    @DeleteMapping("/deleta/{id}")
    void deleteEvidencia(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
