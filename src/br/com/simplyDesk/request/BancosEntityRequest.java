package br.com.simplyDesk.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancosEntityRequest {

	private Long codigo;

	private String banco;
	
}
