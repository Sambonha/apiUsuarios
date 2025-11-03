package br.com.cotiinformatica.helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoHelper {

	/*
	 * Método para receber um valor string (texto) e retornar este valor
	 * criptografado com algoritmo de HASH SHA256
	 */
	public static String encryptSHA256(String texto) {
		try {
// Cria uma instância do MessageDigest com SHA-256
			MessageDigest digest = MessageDigest

					.getInstance("SHA-256");
// Converte a string em bytes e gera o hash
			byte[] hashBytes = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
// Converte os bytes em uma string hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
// Caso SHA-256 não esteja disponível
			throw new RuntimeException

			("Erro ao criptografar com SHA-256", e);

		}
	}
}