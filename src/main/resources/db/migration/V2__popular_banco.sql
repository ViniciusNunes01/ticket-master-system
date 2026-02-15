-- 1. Geografia
INSERT INTO pais (nome, sigla) VALUES ('Brasil', 'BR');

INSERT INTO estado (nome, sigla, id_pais) VALUES ('São Paulo', 'SP', 1);
INSERT INTO estado (nome, sigla, id_pais) VALUES ('Rio de Janeiro', 'RJ', 1);

INSERT INTO cidade (nome, id_estado) VALUES ('Jundiaí', 1);
INSERT INTO cidade (nome, id_estado) VALUES ('São Paulo', 1);
INSERT INTO cidade (nome, id_estado) VALUES ('Niterói', 2);

-- 2. Endereços
-- Endereço 1 (para o Vinicius)
INSERT INTO endereco (logradouro, numero, bairro, cep, complemento, id_cidade)
VALUES ('Rua Java', '10', 'Centro', '13200-000', 'Casa', 1); -- Jundiaí

-- Endereço 2 (para a Maria)
INSERT INTO endereco (logradouro, numero, bairro, cep, complemento, id_cidade)
VALUES ('Av. Paulista', '1000', 'Bela Vista', '01310-100', 'Apto 10', 2); -- São Paulo

-- 3. Clientes (Vinculando aos Endereços criados acima)
INSERT INTO cliente (nome, cpf, email, telefone, data_nascimento, id_endereco)
VALUES ('Vinicius Nunes', '123.456.789-00', 'vinicius@email.com', '(11) 99999-9999', '1999-01-01', 1);

INSERT INTO cliente (nome, cpf, email, telefone, data_nascimento, id_endereco)
VALUES ('Maria Silva', '111.222.333-44', 'maria@email.com', '(11) 88888-8888', '1995-05-20', 2);

-- 4. Eventos e Ingressos (Igual ao anterior)
INSERT INTO evento (nome, data, capacidade_maxima, ingressos_restantes, preco_base)
VALUES ('Rock in Rio 2026', '2026-09-20 18:00:00', 100000, 100, 550.00);

INSERT INTO evento (nome, data, capacidade_maxima, ingressos_restantes, preco_base)
VALUES ('Workshop Spring Boot', '2026-03-15 09:00:00', 50, 50, 100.00);

INSERT INTO ingresso (data_compra, valor_pago, id_cliente, id_evento)
VALUES ('2026-02-12 10:00:00', 550.00, 1, 1);