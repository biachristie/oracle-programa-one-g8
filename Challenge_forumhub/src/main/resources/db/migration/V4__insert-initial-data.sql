-- Inserindo categorias
INSERT INTO categorias(id, nome) VALUES(1, 'Programação');
INSERT INTO categorias(id, nome) VALUES(2, 'Front-end');
INSERT INTO categorias(id, nome) VALUES(3, 'Data Science');
INSERT INTO categorias(id, nome) VALUES(4, 'DevOps');


-- Inserindo cursos
INSERT INTO cursos(id, nome, categoria_id) VALUES(1, 'Java e Spring Boot', 1);
INSERT INTO cursos(id, nome, categoria_id) VALUES(2, 'Python e Flask', 1);
INSERT INTO cursos(id, nome, categoria_id) VALUES(3, 'HTML, CSS e Javascript', 2);
INSERT INTO cursos(id, nome, categoria_id) VALUES(4, 'SQL e Bancos de Dados', 3);
INSERT INTO cursos(id, nome, categoria_id) VALUES(5, 'Docker e Kubernetes', 4);