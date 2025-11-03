package br.com.cotiinformatica.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutenticarUsuarioRequest {

	@Email(message = "Informe um endereço de email válido.")
	@NotBlank(message = "O email do usuário é obrigatório.")
	private String email;

	@Size(min = 8, message = "Informe a senha de acesso com pelo menos 8 caracteres.")
	@NotBlank(message = "A senha do usuário é obrigatória.")
	private String senha;
}
