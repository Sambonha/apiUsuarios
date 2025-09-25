package br.com.cotiinformatica.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column
	private UUID id;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(length = 100, nullable = false)
	private String senha;

}
