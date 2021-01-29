package com.ApiBanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ApiBanco.controller.dto.ClienteDto;
import com.ApiBanco.controller.dto.EnderecoDto;
import com.ApiBanco.controller.dto.ViaCepDto;
import com.ApiBanco.controller.form.CadastroForm;
import com.ApiBanco.model.Cliente;
import com.ApiBanco.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDto> listarClientes() {
		List<Cliente> cadastro = clienteRepository.findAll();

		return ClienteDto.converter(cadastro);
	}
	

	public ClienteDto cadastrar(CadastroForm form) throws Exception {
		
		validarClienteExistente(form);
		
		EnderecoDto enderecoDto = buscarEndereco(form.getCep());
		
		Cliente entity = clienteRepository.save(Cliente.gerarClienteEntity(form, enderecoDto));
		
		return ClienteDto.gerarClienteDto(entity);
	}
	
	public ClienteDto obterClienteComCpf(Long cpf) {
		Cliente entity = clienteRepository.obterClienteComCpf(cpf);
		
		return ClienteDto.gerarClienteDto(entity);
	}
	
	
	public EnderecoDto buscarEndereco(Integer cep) {
		String cepFormatado = cep.toString();
		
		if (cepFormatado.length() < 8) {
			for(;cepFormatado.length() < 8;) {
				cepFormatado = "0" + cepFormatado;
			}
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://viacep.com.br/ws/";
		ResponseEntity<ViaCepDto> response = restTemplate.getForEntity(url + cepFormatado + "/json/", ViaCepDto.class);
		
		return EnderecoDto.gerarEndereco(response.getBody());
	}
	
	public void validarClienteExistente (CadastroForm cadastroForm) throws IllegalArgumentException {
		List<Cliente> cliente = clienteRepository.buscarCpfIguais(cadastroForm.getCpf());

		if (cliente.size() > 0) {
			throw new IllegalArgumentException("CPF ja cadastrado.");
		}
		
	}
	
}
