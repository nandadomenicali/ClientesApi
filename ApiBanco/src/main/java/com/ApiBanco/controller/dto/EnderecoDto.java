package com.ApiBanco.controller.dto;

public class EnderecoDto {

	private String cep;
	private String logradouro;
	private String cidade;
	private String estado;
	
	public EnderecoDto(String cep, String logradouro, String cidade, String estado) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static EnderecoDto gerarEndereco(ViaCepDto viacep){
		
		if(viacep == null || viacep.getLogradouro() == null) {
			throw new IllegalArgumentException("CEP inválido.");
		}
		
		EnderecoDto dto = new EnderecoDto(
				viacep.getCep(), 
				viacep.getLogradouro(), 
				viacep.getLocalidade(), 
				viacep.getUf());
		
		return dto;
	}
	
}
