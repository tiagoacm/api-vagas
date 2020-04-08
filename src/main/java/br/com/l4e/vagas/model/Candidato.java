package br.com.l4e.vagas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name="nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name="telefone", nullable = false, length = 11)
	private String telefone;
	
	@ManyToOne
	private Vaga vaga;

	public Candidato() {
		
	}

	public Candidato(String cpf, String nome, String telefone, Vaga vaga) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.vaga = vaga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	
	

}
