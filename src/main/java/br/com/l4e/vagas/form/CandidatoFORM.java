package br.com.l4e.vagas.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.l4e.vagas.model.Candidato;
import br.com.l4e.vagas.model.Vaga;

public class CandidatoFORM {
	
	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
	@Length(min = 5, max = 50)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	private String telefone;

	@NotNull
	private int idVaga;

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

	public int getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	

	public Candidato converter() {
		Vaga vaga = new Vaga();
		vaga.setId(this.idVaga);
		return new Candidato(this.cpf, this.nome, this.telefone, vaga);
	}

	
	
	
}
