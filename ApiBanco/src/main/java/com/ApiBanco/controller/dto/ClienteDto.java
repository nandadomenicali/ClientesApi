package com.ApiBanco.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import com.ApiBanco.model.Cliente;

public class ClienteDto {

	private String nome;
	private Long cpf;
	private int agencia = 0001;
	private int conta;
	private int cep;
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	
	public ClienteDto() {
		super();// TODO Auto-generated constructor stub
	}
	
	
	
	public ClienteDto(String nome, Long cpf, int agencia, int conta,  int cep, String logradouro, int numero, String cidade,
			String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.agencia = agencia;
		this.conta = conta;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public ClienteDto(Cliente cadastro) {
		this.nome = cadastro.getNome();
		this.cpf = cadastro.getCpf();
		this.agencia = cadastro.getAgencia();
		this.conta = cadastro.getConta();
		this.cep = cadastro.getCep();
		this.logradouro = cadastro.getLogradouro();
		this.numero = cadastro.getNumero();
		this.cidade = cadastro.getCidade();
		this.estado = cadastro.getEstado();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	} 
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public static ClienteDto gerarClienteDto(Cliente entity) {
		ClienteDto dto = null;
		
		if(entity != null) {
			dto = new ClienteDto(
					entity.getNome(), 
					entity.getCpf(), 
					entity.getAgencia(),
					entity.getConta(),
					entity.getCep(), 
					entity.getLogradouro(), 
					entity.getNumero(), 
					entity.getCidade(), 
					entity.getEstado());
		}
		
		return dto;
	}

	
	public static List<ClienteDto> converter(List<Cliente> cliente){
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	public static ClienteDto converter(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		
		clienteDto.setNome(cliente.getNome());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setAgencia(cliente.getAgencia());
		clienteDto.setConta(cliente.getConta());
		clienteDto.setCep(cliente.getCep());
		clienteDto.setLogradouro(cliente.getLogradouro());
		clienteDto.setNumero(cliente.getNumero());
		clienteDto.setCidade(cliente.getCidade());
		clienteDto.setEstado(cliente.getEstado());
		
		
		
		return clienteDto;
	}
	
}
