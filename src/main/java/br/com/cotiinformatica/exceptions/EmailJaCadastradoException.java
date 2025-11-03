package br.com.cotiinformatica.exceptions;

public class EmailJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O email informado já está cadastrado para outro usuário.";
	}
}
