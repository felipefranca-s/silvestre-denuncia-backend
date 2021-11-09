package com.silvestre.silvestre.denuncias;

import java.util.List;
import java.util.Optional;

import com.silvestre.silvestre.statusDenuncias.StatusDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/denuncias")
@AllArgsConstructor
public class DenunciaController {

	@Autowired
	DenunciaRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Denuncia> todosDenuncias(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Denuncia> retornaDenuncia(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("/obterPorCodigo/{codigo}")
	Denuncia retornaDenunciaPorCodigo(@PathVariable String codigo) {
		return repository.findByCodigo(codigo);
	}

	@PostMapping("/novo")
	Denuncia novaDenuncia(@RequestBody Denuncia denuncia) {
		return repository.save(denuncia);
	}

	@PutMapping("/{id}")
	Denuncia atualizaDenuncia(@RequestBody Denuncia denuncia, @PathVariable Long id) {
		denuncia.setId(id);
		return repository.save(denuncia);
	}

	@DeleteMapping("/deleta/{id}")
	void deletaDenuncia(@PathVariable Long id) {
		repository.deleteById(id);
	}
}