package br.com.l4e.vagas.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.l4e.vagas.model.Candidato;

public class CandidatoDTO {
	
	private int id;
	private String cpf;
	private String nome;
	private String telefone;
	private int idVaga;
	private String cargoVaga;
	
	public CandidatoDTO(Candidato candidato) {
		this.id = candidato.getId();
		this.cpf = candidato.getCpf();
		this.nome = candidato.getNome();
		this.telefone = candidato.getTelefone();
		this.idVaga = candidato.getVaga().getId();
		this.cargoVaga = candidato.getVaga().getCargo();
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getIdVaga() {
		return idVaga;
	}

	public String getCargoVaga() {
		return cargoVaga;
	}
	
	// converter uma lista de Candidato em CandidatoDTO
	public static List<CandidatoDTO> converter(List<Candidato> candidatos) {
		return candidatos.stream().map(CandidatoDTO::new).collect(Collectors.toList());
	}
		

}
