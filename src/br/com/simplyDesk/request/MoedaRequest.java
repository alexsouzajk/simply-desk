package br.com.simplyDesk.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoedaRequest {

	private Long id;

	private String nome;

	private BigDecimal cotacao;
	
}
