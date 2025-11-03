package br.com.cotiinformatica.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.requests.AutenticarUsuarioRequest;
import br.com.cotiinformatica.dtos.requests.CriarUsuarioRequest;
import br.com.cotiinformatica.dtos.responses.AutenticarUsuarioResponse;
import br.com.cotiinformatica.dtos.responses.CriarUsuarioResponse;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.helpers.CryptoHelper;
import br.com.cotiinformatica.repositories.PerfilRepository;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	public AutenticarUsuarioResponse autenticarUsuario(AutenticarUsuarioRequest request) {

		var usuario = usuarioRepository.find(request.getEmail(), CryptoHelper.encryptSHA256(request.getSenha()));

		if (usuario == null)
			throw new AcessoNegadoException();

		var response = new AutenticarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraAcesso(LocalDateTime.now());

		return response;

	}

	public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) {

		if (usuarioRepository.find(request.getEmail()) != null)
			throw new EmailJaCadastradoException();

		var usuario = new Usuario();

		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(CryptoHelper.encryptSHA256(request.getSenha()));
		usuario.setPerfil(perfilRepository.find("Operador"));

		usuarioRepository.save(usuario);

		var response = new CriarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraCriacao(LocalDateTime.now());
		response.setNomePerfil(usuario.getPerfil().getNome());

		return response;
	}
}
