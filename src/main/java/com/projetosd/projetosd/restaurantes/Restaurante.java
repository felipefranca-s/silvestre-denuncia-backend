package com.projetosd.projetosd.restaurantes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data 				// Cria os getters e setters, tava retornando vazio o request
@AllArgsConstructor // Construtor
@NoArgsConstructor 	// Construtor
@Entity 			// Para o banco de dados
//@Table(name = "restaurante") // Caso queira referenciar a tabela
public class Restaurante {

	// @Id // Serve caso queira referenciar o campo na tabela, porem
	// utilizando outro nome de variavel aqui
	//private Long numeroDoRestaurante;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement
	private Long id;
	
	private String nome;
	
	private String local;
	
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}