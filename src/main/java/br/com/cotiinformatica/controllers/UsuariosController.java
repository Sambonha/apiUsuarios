package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.requests.AutenticarUsuarioRequest;
import br.com.cotiinformatica.dtos.requests.CriarUsuarioRequest;
import br.com.cotiinformatica.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("autenticar")
	public ResponseEntity<?> autenticar(@RequestBody @Valid AutenticarUsuarioRequest request) {

		try {
			var response = usuarioService.autenticarUsuario(request);

			return ResponseEntity.ok().body(response);
		} catch (AcessoNegadoException e) {
			return ResponseEntity.status(401).body(e.getMessage());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("criar")
	public ResponseEntity<?> criar(@RequestBody @Valid CriarUsuarioRequest request) {

		try {

			var response = usuarioService.criarUsuario(request);

			return ResponseEntity.ok().body(response);

		} catch (EmailJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		} catch (Exception e) {

			return ResponseEntity.internalServerError().build();
		}
	}
}
