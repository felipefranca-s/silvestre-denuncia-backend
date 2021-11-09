package com.silvestre.silvestre.denuncias;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.silvestre.silvestre.atualizacoes.Atualizacao;
import com.silvestre.silvestre.evidencias.Evidencia;
import com.silvestre.silvestre.statusDenuncias.StatusDenuncia;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private Date data;

	private Time hora;

	private String local;

	private String descricao;

	private String codigo;

	@ManyToOne
	@JsonIgnoreProperties("denuncias")
	private StatusDenuncia status_denuncia;

	@OneToMany(mappedBy = "denuncia", targetEntity = Atualizacao.class, cascade = CascadeType.ALL)
	private List<Atualizacao> atualizacoes;

	@OneToMany(mappedBy = "denuncia", targetEntity = Evidencia.class, cascade = CascadeType.ALL)
	private List<Evidencia> evidencias;

	// Getters e setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public StatusDenuncia getStatus_denuncia() {
		return status_denuncia;
	}

	public void setStatus_denuncia(StatusDenuncia status_denuncia) {
		this.status_denuncia = status_denuncia;
	}

	public List<Atualizacao> getAtualizacoes() {
		return atualizacoes;
	}

	public void setAtualizacoes(List<Atualizacao> atualizacoes) {
		this.atualizacoes = atualizacoes;
	}

	public List<Evidencia> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(List<Evidencia> evidencias) {
		this.evidencias = evidencias;
	}
}