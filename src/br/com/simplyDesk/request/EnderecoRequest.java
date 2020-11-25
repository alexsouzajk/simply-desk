package br.com.simplyDesk.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

	private Long id;

	private String logradouro;

	private String bairo;

	private String Uf;

	private Integer numero;

	private String complemento;

	private String cidade;

	private String cep;
	
}
