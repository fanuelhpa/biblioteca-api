INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Ana Lima', 'ana.lima@email.com', '11988880001', '111.111.111-01', 0);
INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Bruno Souza', 'bruno.souza@email.com', '11988880002', '111.111.111-02', 0);
INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Carla Mendes', 'carla.mendes@email.com', '11988880003', '111.111.111-03', 1);
INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Diego Ferreira', 'diego.ferreira@email.com', '11988880004', '111.111.111-04', 0);
INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Eduarda Costa', 'eduarda.costa@email.com', NULL, '111.111.111-05', 0);
INSERT INTO tb_usuario (nome, email, telefone, cpf, status) VALUES ('Felipe Ramos', 'felipe.ramos@email.com',   '11988880006', NULL, 2);

INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Robert C. Martin', 'Americano');
INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Martin Fowler', 'Britânico');
INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Eric Evans', 'Americano');
INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Joshua Bloch', 'Americano');
INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Machado de Assis', 'Brasileiro');
INSERT INTO tb_autor (nome, nacionalidade) VALUES ('Graciliano Ramos', 'Brasileiro');

INSERT INTO tb_categoria (nome, descricao) VALUES ('Engenharia de Software', 'Livros sobre boas práticas, padrões e arquitetura de software');
INSERT INTO tb_categoria (nome, descricao) VALUES ('Programação', 'Livros focados em linguagens de programação e algoritmos');
INSERT INTO tb_categoria (nome, descricao) VALUES ('Literatura Brasileira', 'Clássicos e obras contemporâneas da literatura nacional');
INSERT INTO tb_categoria (nome, descricao) VALUES ('Banco de Dados', 'Modelagem, SQL e administração de bancos de dados');

INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Clean Code', '978-0132350884', 2008, 3, 2, 1, 1);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Clean Architecture', '978-0134494166', 2017, 2, 2, 1, 1);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Refactoring', '978-0201485677', 1999, 2, 1, 2, 1);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Domain-Driven Design', '978-0321125217', 2003, 2, 2, 3, 1);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Effective Java', '978-0134685991', 2018, 3, 3, 4, 2);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Dom Casmurro', '978-8572328692', 1899, 4, 4, 5, 3);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Memórias Póstumas de Brás Cubas', '978-8535910663', 1881, 3, 3, 5, 3);
INSERT INTO tb_livro (titulo, isbn, ano_publicacao, quantidade_total, quantidade_disponivel, autor_id, categoria_id) VALUES ('Vidas Secas', '978-8535902693', 1938, 2, 1, 6, 3);

INSERT INTO tb_emprestimo (data_emprestimo, data_prevista_devolucao, data_devolucao, status, usuario_id, livro_id) VALUES ('2026-09-01', '2026-09-15', '2026-09-13', 1, 1, 1);
INSERT INTO tb_emprestimo (data_emprestimo, data_prevista_devolucao, data_devolucao, status, usuario_id, livro_id) VALUES ('2026-09-20', '2026-10-04', NULL, 0, 2, 2);
INSERT INTO tb_emprestimo (data_emprestimo, data_prevista_devolucao, data_devolucao, status, usuario_id, livro_id) VALUES ('2026-08-01', '2026-08-15', NULL, 2, 3, 3);
INSERT INTO tb_emprestimo (data_emprestimo, data_prevista_devolucao, data_devolucao, status, usuario_id, livro_id) VALUES ('2026-08-10', '2026-08-24', '2026-09-05', 1, 4, 6);
INSERT INTO tb_emprestimo (data_emprestimo, data_prevista_devolucao, data_devolucao, status, usuario_id, livro_id) VALUES ('2026-09-15', '2026-09-29', NULL, 0, 5, 8);

INSERT INTO tb_multa (emprestimo_id, valor, pago, data_pagamento) VALUES (3, 42.00, false, NULL);
INSERT INTO tb_multa (emprestimo_id, valor, pago, data_pagamento) VALUES (4, 12.00, true, '2026-09-10');

INSERT INTO tb_reserva (data_reserva, data_expiracao, status, usuario_id, livro_id) VALUES ('2026-09-25', '2026-09-28', 0, 1, 5);
INSERT INTO tb_reserva (data_reserva, data_expiracao, status, usuario_id, livro_id) VALUES ('2026-08-30', '2026-09-02', 1, 2, 1);
INSERT INTO tb_reserva (data_reserva, data_expiracao, status, usuario_id, livro_id) VALUES ('2026-09-10', '2026-09-13', 2, 4, 8);
INSERT INTO tb_reserva (data_reserva, data_expiracao, status, usuario_id, livro_id) VALUES ('2026-09-18', '2026-09-21', 3, 5, 4);
