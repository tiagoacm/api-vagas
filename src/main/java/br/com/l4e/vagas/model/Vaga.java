package br.com.l4e.vagas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cargo", nullable = false, length = 50)
	private String cargo;

	@Column(name="descricao", nullable = false, length = 100)
	private String descricao;
	
	
	@Column(name="dt_vencimento")
	private LocalDate dataVencimento;
	
	@OneToMany(mappedBy = "vaga")	
	private List<Candidato> candidatos = new ArrayList<>();
	
	
	public Vaga() {
		
	}

	public Vaga(String cargo, String descricao, LocalDate dataVencimento) {
		this.cargo = cargo;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

}
