package br.com.simplyDesk.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteContaRequest {

	private Long id;

	private BancosEntityRequest codigoBanco;

	private ClienteRequest idCliente;
	
	private Long codigoAgencia;
	
	private Long codigoConta;
	
	private Boolean principal;

}
