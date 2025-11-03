INSERT INTO perfil(id,nome)
VALUES(gen_random_uuid(), 'Administrador');

INSERT INTO perfil(id, nome)
VALUES(gen_random_uuid(), 'Operador');

SELECT
	id, nome
FROM
	perfil
ORDER BY
	nome;