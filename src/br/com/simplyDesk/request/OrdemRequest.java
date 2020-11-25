package br.com.simplyDesk.request;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemRequest {

	private Long id;

	private ClienteRequest cliente;

	private MoedaRequest moeda;

	private String tipo;

	private Integer quantidadeMoedas;

	private String dataOrdem;

	private BigDecimal valorOrdem;

	private String statusOrdem;
	
}
