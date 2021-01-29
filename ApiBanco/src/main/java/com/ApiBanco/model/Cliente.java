 package com.ApiBanco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ApiBanco.controller.dto.EnderecoDto;
import com.ApiBanco.controller.form.CadastroForm;

@Entity
public class Cliente {
 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Long cpf;
	private int agencia = 0001;
	private int conta;
	private int cep;
	private String logradouro;
	private String cidade;
	private String estado;
	private int numero; 
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Long id, String nome, Long cpf, int agencia, int conta,  int cep, String logradouro, String cidade,
			String estado, int numero) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.agencia = agencia;
		this.conta = conta;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static Cliente gerarClienteEntity(CadastroForm cadastroForm, EnderecoDto enderecoDto) {
		Cliente cliente = new Cliente();
		
		cliente.setCpf(cadastroForm.getCpf());
		cliente.setNome(cadastroForm.getNome());
		cliente.setAgencia(cadastroForm.getAgencia());
		cliente.setConta(cadastroForm.getConta());
		cliente.setCep(cadastroForm.getCep());
		cliente.setNumero(cadastroForm.getNumero());
		cliente.setLogradouro(enderecoDto.getLogradouro());
		cliente.setCidade(enderecoDto.getCidade());
		cliente.setEstado(enderecoDto.getEstado());
		
		return cliente;
	}
	
}
