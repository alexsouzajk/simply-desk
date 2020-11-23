package br.com.simplyDesk.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

	private Long id;
	
	private String cnpjCpf;

	private EnderecoRequest endereco;

	private String nome;

	private String dataNascimento;

	private String email;

	private String telefone;

	private String sexo;

	
}
