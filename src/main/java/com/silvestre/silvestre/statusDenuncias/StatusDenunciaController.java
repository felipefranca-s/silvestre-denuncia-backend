package com.silvestre.silvestre.statusDenuncias;

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
@RequestMapping("/statusDenuncias")
@AllArgsConstructor
public class StatusDenunciaController {

	@Autowired
	StatusDenunciaRepository repository;
	
	@GetMapping("/retornaTodos")
	List<StatusDenuncia> todosStatusDenuncias(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	StatusDenuncia novoStatusDenuncia(@RequestBody StatusDenuncia statusDenuncia) {
		return repository.save(statusDenuncia);
	}
	
	@GetMapping("/{id}")
		Optional<StatusDenuncia> retornaStatusDenuncia(@PathVariable Long id) {
			return repository.findById(id);
		}
	
	@PutMapping("/{id}")
	StatusDenuncia atualizaStatusDenucia(@RequestBody StatusDenuncia statusDenuncia, @PathVariable Long id) {
		
		statusDenuncia.setId(id);
		return repository.save(statusDenuncia);
	}
	
	@DeleteMapping("/deleta/{id}")
		void deletaStatusDenuncia(@PathVariable Long id) {
			repository.deleteById(id);
		}	
}