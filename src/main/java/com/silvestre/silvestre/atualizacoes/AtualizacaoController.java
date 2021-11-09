package com.silvestre.silvestre.atualizacoes;

import com.silvestre.silvestre.statusDenuncias.StatusDenuncia;
import com.silvestre.silvestre.statusDenuncias.StatusDenunciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atualizacoes")
@AllArgsConstructor
public class AtualizacaoController {

    @Autowired
    AtualizacaoRepository repository;

    @GetMapping("/retornaTodos")
    List<Atualizacao> todasAtualizacoes(){
        return repository.findAll();
    }

    @PostMapping("/novo")
    Atualizacao novaAtualizacao(@RequestBody Atualizacao atualizacao) {
        return repository.save(atualizacao);
    }

    @GetMapping("/{id}")
    Optional<Atualizacao> retornaAtualizacao(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Atualizacao atualizaAtualizacao(@RequestBody Atualizacao atualizacao, @PathVariable Long id) {

        atualizacao.setId(id);
        return repository.save(atualizacao);
    }

    @DeleteMapping("/deleta/{id}")
    void deletaAtualizacao(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
