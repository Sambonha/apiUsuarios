package br.com.cotiinformatica.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriarUsuarioRequest {

	@Size(min = 8, max = 150, message = "O nome do usuário deve ter de 8 a 150 caracteres.")
	@NotBlank(message = "O nome do usuário é obrigatório.")
	private String nome;

	@Email(message = "Informe um endereço de email válido.")
	@NotBlank(message = "O email do usuário é obrigatório.")
	private String email;

	
	@Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
	@Pattern(regexp = ".*[A-Z].*", message = "A senha deve ter pelo menos uma letra maiúscula.")
	@Pattern(regexp = ".*[a-z].*", message = "A senha deve ter pelo menos uma letra minúscula.")
	@Pattern(regexp = ".*\\d.*", message = "A senha deve ter pelo menos um número.")
	@NotBlank(message = "A senha do usuário é obrigatória.")
	private String senha;
}
