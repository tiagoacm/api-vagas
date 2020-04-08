package br.com.l4e.vagas.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.l4e.vagas.model.Vaga;
import br.com.l4e.vagas.service.VagaService;

public class VagaFORM {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 50)
	private String cargo;
	
	@NotNull
	@NotEmpty
	@Length(min = 5, max = 100)
	private String descricao;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimento;
	
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
	public @NotNull LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(@NotNull LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public Vaga converter() {
		return new Vaga(this.cargo, this.descricao, this.dataVencimento);
	}
	
	public Vaga atualizar(Integer id, VagaService vagaService) {
		Vaga vaga = vagaService.getOne(id);
		vaga.setCargo(this.cargo);
		vaga.setDescricao(this.descricao);
		vaga.setDataVencimento(this.dataVencimento);
		return vaga;
	}
	
    	
}
