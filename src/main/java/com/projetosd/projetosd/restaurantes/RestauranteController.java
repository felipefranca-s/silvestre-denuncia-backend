package com.projetosd.projetosd.restaurantes;

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
@RequestMapping("/restaurantes")
@AllArgsConstructor
public class RestauranteController {

	@Autowired // Injeta a dependencia
	RestauranteRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Restaurante> todosRestaurantes(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Restaurante novoRestaurante(@RequestBody Restaurante restaurante) {
		return repository.save(restaurante); // ja cria e retorna				
	}
	
	@GetMapping("/{id}")
		Optional<Restaurante> retornaRestaurante(@PathVariable Long id) {
			return repository.findById(id);
		}
	
	@PutMapping("/{id}")
	Restaurante atualiza(@RequestBody Restaurante restaurante, @PathVariable Long id) {
		
		restaurante.setId(id);
		return repository.save(restaurante);
	}
	
	@DeleteMapping("/deleta/{id}")
		void deletaRestaurante(@PathVariable Long id) {
			repository.deleteById(id);
		}	
}