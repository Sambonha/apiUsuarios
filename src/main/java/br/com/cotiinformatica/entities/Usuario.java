package br.com.cotiinformatica.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // define a classe como uma entidade do banco de dados
public class Usuario {

	@Id // mapear o atributo como chave primária da tabela no banco
	@GeneratedValue(strategy = GenerationType.UUID) // gerado automaticamente
	@Column // coluna da tabela
	private UUID id;

	// coluna da tabela com max de 150 caracteres e campo obrigatório (not null)
	@Column(length = 150, nullable = false)
	private String nome;

	// coluna da tabela com max de 100 caracteres e campo obrigatório (not null) e
	// unique
	@Column(length = 100, nullable = false, unique = true)
	private String email;

	// coluna da tabela com max de 100 caracteres e campo obrigatório (not null)
	@Column(length = 100, nullable = false)
	private String senha;

	@ManyToOne
	@JoinColumn()
	private Perfil perfil;
}
