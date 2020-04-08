package br.com.l4e.vagas.dto;

public class ErroNegocioDTO {
	
	private String mensagem;

	public ErroNegocioDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
