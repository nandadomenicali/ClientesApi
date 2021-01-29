package com.ApiBanco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiBanco.controller.dto.StatusDto;
import com.ApiBanco.controller.dto.ClienteDto;
import com.ApiBanco.controller.form.CadastroForm;
import com.ApiBanco.service.ClienteService;


@RestController
@RequestMapping(value = "cliente")
public class ClienteApi {
	
	@Autowired
	private ClienteService clienteService;
	
	ClienteDto cliente = new ClienteDto();
	

	public 	List<ClienteDto> listarClientes() {
		List<ClienteDto> clientes = clienteService.listarClientes();
		 		
		return clientes;	
	}

	@GetMapping("cpf/{cpf}") 	                               
	public StatusDto obterClienteComCpf(@PathVariable Long cpf) {
		StatusDto dto = new StatusDto();
		
		try {
			ClienteDto clienteDto = clienteService.obterClienteComCpf(cpf);
			dto.setStatusCode(HttpStatus.OK.value());
			
			if(clienteDto != null) {
				dto.setBody(clienteDto);
				dto.setMensagem(HttpStatus.OK.name());				
			}else {
				dto.setMensagem("Cpf não encontrado!");
			}
			
		} catch (Exception e) {
			dto.setMensagem(e.getMessage());
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		 		
		return dto;	
	}
	
	@PostMapping("cadastrar") 
	public ResponseEntity<StatusDto> cadastrar(@RequestBody CadastroForm form) {
		StatusDto statusDto = new StatusDto();
		
		try {
			ClienteDto clienteDto = clienteService.cadastrar(form);
			
			statusDto.setBody(clienteDto);
			statusDto.setMensagem(HttpStatus.CREATED.name());
			statusDto.setStatusCode(HttpStatus.CREATED.value());
		
		} catch (IllegalArgumentException e) {
			statusDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
			statusDto.setMensagem(e.getMessage());
				
		} catch (Exception e) {
			statusDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			statusDto.setMensagem("Erro inesperado, por favor tente mais tarde.");
		}
		
		return ResponseEntity.status(statusDto.getStatusCode()).body(statusDto);
	}
}
