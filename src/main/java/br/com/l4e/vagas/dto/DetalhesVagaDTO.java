package br.com.l4e.vagas.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.l4e.vagas.model.Vaga;

public class DetalhesVagaDTO {
	
	private int id;
	private String cargo;
	private String descricao;
	private LocalDate dataVencimento;
	private List<CandidatoDTO> candidatos;
	
	public DetalhesVagaDTO(Vaga vaga) {
		this.id = vaga.getId();
		this.cargo = vaga.getCargo();
		this.descricao = vaga.getDescricao();
		this.dataVencimento = vaga.getDataVencimento();
		this.candidatos = new ArrayList<>();
		this.candidatos.addAll(vaga.getCandidatos().stream().map(CandidatoDTO::new).collect(Collectors.toList()));
	}

	public int getId() {
		return id;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public List<CandidatoDTO> getCandidatos() {
		return candidatos;
	}
	
	
	
	

}
