package br.com.l4e.vagas.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.l4e.vagas.model.Vaga;

public class VagaDTO {

	private int id;
	private String cargo;
	private String descricao;
	private LocalDate dataVencimento;
	
	public VagaDTO(Vaga vaga) {
		this.id = vaga.getId();
		this.cargo = vaga.getCargo();
		this.descricao = vaga.getDescricao();
		this.dataVencimento = vaga.getDataVencimento();
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
	
	// converter uma lista de vagas em vagasDTO
	public static List<VagaDTO> converter(List<Vaga> vagas) {
		return vagas.stream().map(VagaDTO::new).collect(Collectors.toList());
	}
}
