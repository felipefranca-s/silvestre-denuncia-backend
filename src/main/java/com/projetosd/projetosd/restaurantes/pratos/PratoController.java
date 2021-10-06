package com.projetosd.projetosd.restaurantes.pratos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pratos")
@AllArgsConstructor
public class PratoController {

	@Autowired
	PratoRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Prato> todosPratos(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Prato novoPrato(@RequestBody Prato prato) {
		return repository.save(prato);
	}
	
	@GetMapping("/{id}")
	Optional<Prato> retornaPrato(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Prato atualizaPrato(@RequestBody Prato prato, @PathVariable Long id) {
		prato.setId(id);
		return repository.save(prato);
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaPrato(@PathVariable Long id) {
		repository.deleteById(id);
	}
}