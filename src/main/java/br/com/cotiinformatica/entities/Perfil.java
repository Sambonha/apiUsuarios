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
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column
	private UUID id;

	@Column(length = 25, nullable = false, unique = true)
	private String nome;

}
