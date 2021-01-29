package com.ApiBanco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ApiBanco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT c FROM Cliente c WHERE CPF = :cpf")
	public List<Cliente> buscarCpfIguais(Long cpf);
	
	
	@Query(value = "SELECT c FROM Cliente c WHERE CPF = :cpf")
	public Cliente obterClienteComCpf(Long cpf);
			
}

 
	