package br.com.cotiinformatica.dtos.responses;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutenticarUsuarioResponse {

	private UUID id;
	private String nome;
	private String email;
	private LocalDateTime dataHoraAcesso;
	private LocalDateTime dataHoraExpiracao;
	private String accessToken;
}
