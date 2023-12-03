
-- Dados fictícios para a tabela Endereco (adicionando mais alguns endereços)
    INSERT INTO Endereco (logradouro, numero, estado, complemento, cidade, cep)
    VALUES
        ('Rua X', 567, 'Rio Grande do Sul', 'Apto 202', 'Porto Alegre', '56789-012'),
        ('Avenida Y', 890, 'Bahia', 'Casa 3', 'Salvador', '67890-123'),
        ('Rua Z', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Rua Quinze de novembro', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Rua Azevedo', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Av. Nove de Julho', 3186, 'SP', 'Prédio', 'São Paulo', '98901-234'),
        ('Av. Tucuruvi', 3186, 'SP', 'Prédio', 'São Paulo', '98901-234');


-- Dados fictícios para a tabela Empresa (adicionando mais algumas empresas)
INSERT INTO Empresa (razao_Social, cnpj, fk_Endereco)
VALUES
    ('Empresa K', '10987654321011', 1),
    ('Empresa L', '21098765432102', 2),
    ('Empresa M', '32109876543203', 3),
    ('Empresa N', '43210987654304', 4),
    ('Empresa O', '54321098765405', 5),
    ('C6 Bank', '11321098765405', 6);

-- Dados fictícios para a tabela Agenda (adicionando mais alguns agendamentos)
INSERT INTO Agenda (data, hora, status)
VALUES
    ('2023-11-05', '09:30:00', 'Agendado'),
    ('2023-11-06', '14:00:00', 'Agendado'),
    ('2023-11-07', '16:45:00', 'Reagendado'),
    ('2023-11-08', '11:15:00', 'Agendado'),
    ('2023-11-09', '10:00:00', 'Agendado');

INSERT INTO Agenda (data, hora, status)
VALUES
    ('2023-11-10', '08:00:00', 'Agendado'),
    ('2023-11-11', '13:30:00', 'Agendado'),
    ('2023-11-12', '15:45:00', 'Reagendado'),
    ('2023-11-13', '10:30:00', 'Agendado'),
    ('2023-11-14', '12:00:00', 'Agendado'),
    ('2023-11-15', '14:15:00', 'Reagendado'),
    ('2023-11-16', '09:45:00', 'Agendado'),
    ('2023-11-17', '16:30:00', 'Agendado'),
    ('2023-11-18', '11:00:00', 'Reagendado'),
    ('2023-11-19', '13:15:00', 'Agendado'),
    ('2023-11-20', '15:00:00', 'Agendado'),
    ('2023-11-21', '10:45:00', 'Reagendado'),
    ('2023-11-22', '12:30:00', 'Agendado');


-- Dados fictícios para a tabela Servico (adicionando mais alguns serviços)
INSERT INTO Servico (nome_Servico, descricao, tipo_Servico ,preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('Maquiagem Profissional', 'Maquiagem para eventos especiais', 'tintura', 80.00, '01:30:00', 1, 1, 2),
    ('Manicure e Pedicure', 'Cuidados com as unhas', 'cabelo', 50.00, '01:00:00', 2, 2, 4),
    ('Tratamento Capilar', 'Hidratação e cuidados com os cabelos', 'cabelo', 60.00, '01:15:00', 3, 3, 1),
    ('Depilação', 'Remoção de pelos', 'barba', 40.00, '00:45:00',4, 4, 3),
    ('Massagem Relaxante', 'Massagem terapêutica', 'tintura', 70.00, '01:30:00', 5, 5, 3);

-- Dados fictícios para a tabela Historico_Servico (adicionando mais alguns registros)
INSERT INTO Historico_Servico (ano, mes, semana, faturamento, fk_Agenda)
VALUES
    (2023, 5, 11, 1200.00, 1),
    (2023, 5, 12, 1500.00, 2),
    (2023, 5, 13, 1000.00, 3),
    (2023, 6, 14, 1300.00, 4),
    (2023, 6, 15, 1600.00, 5);

    -- Dados fictícios para a tabela Usuario com a senha cryptografada senha123
    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('11122233344', 'Maria Silva', 'maria@example.com', '$2a$10$w0gN7PUZHk0DdGG7WDkr4eYmSgKjZ0R8tsoJosJXq6p0EjTOu6tG.', '(55) 5555-1111', true, 1, 1, 1, 1);

    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('22233344455', 'João Oliveira', 'joao@example.com', '$2a$10$AQxLHSwvn58Rr0SRhiDj.uhu9mg.pB3AhkISz/MsMrD9KDuVn3jyq', '(55) 5555-2222', false, null, 2, null, 2);

    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('33344455566', 'Ana Souza', 'ana@example.com', '$2a$10$59xAE8sQDBgVO1FxC58kX.HsHzmC9EZbulGCMb34QXZQEvFTO5dli', '(55) 5555-3333', true, 3, 3, 3, 3);

    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('44455566677', 'Carlos Santos', 'carlos@example.com', '$2a$10$KrBn7PSMNWKkOVM6nnCn2Ox.VXb53vBVF4S/Aj5EvqHLQMX9qr226', '(55) 5555-4444', false, null, 4, null, 4);

    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('55566677788', 'Mariana Lima', 'mariana@example.com', '$2a$10$wTdV1/83.HYZcl3.PL5NSe0/t4uVEksQisP6EIvAJJfVFU5lCY.DS', '(55) 5555-5555', true, 5, 5, 5, 5);

-- Atualizando o serviço do usuário com ID 1 para o novo serviço adicionado
UPDATE Usuario SET fk_Servico = 1 WHERE id_Usuario = 1;


-- Inserir 2 serviços
INSERT INTO Servico (nome_Servico, descricao, preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa)
VALUES
    ('Pezinho', 'Descrição do Serviço A', 70.00, '01:30:00', 6, 5),
    ('Barba', 'Descrição do Serviço B', 80.00, '02:00:00', 7, 5);

    -- Inserir 9 serviços adicionais
    INSERT INTO Servico (nome_Servico, descricao, preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa)
    VALUES
        ('Restauração', 'Restaura a raiz do cabelo', 55.00, '01:10:00', 8, 6),
        ('Botox', 'Relaxamento de cabelo', 65.00, '01:25:00', 9, 6),
        ('Luzes', 'Tingir o cabelo com tinta a sua escolha', 75.00, '01:40:00', 10, 5),
        ('Escova', 'Escovamento de cabelo', 85.00, '01:55:00', 11, 6),
        ('Sobracelha', 'Limpeza facial na região dos olhos', 95.00, '02:10:00', 12, 6),
        ('Progressiva', 'Alisamento de cabelo', 105.00, '02:25:00', 13, 6),
        ('Lavagem', 'Lavagem com produtos profissionais', 115.00, '02:40:00', 14, 6),
        ('Aplique', 'Adição e disfarce de cabelos', 125.00, '02:55:00', 15, 6),
        ('Trança', 'Penteado de cabelos curtos e longos com trança', 135.00, '03:10:00', 16, 6);

-- Inserir 2 funcionários com a senha cryptografada senha123
INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233303', 'Leo Jacinto', 'lJacinto@gmail.com', '$2a$10$zoY4yM3Cv3POiS8xblYzW.ugNjCoCbl929sIUlySNA8/CF1upPPMW', '(55) 5555-1113', false, null, null, null, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233304', 'Julia Da Viste', 'juVista@gmail.com', '$2a$10$0y4AVQZFIwotLc54.9f0A.3Dwecr.dR7Dmjwme.Pi1Id86zvV/hmq', '(55) 5555-1114', false, null, null, null, null);



-- Inserir 9 funcionários com a senha cryptografada senha123
INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('44122233303', 'Gabriel Bebel', 'bebel@gamil.com', '$2a$10$Pjfmw8.nxs8NIh.Qqg5Kf.bSHC/GQ5kuic.6teiCCZYl8PCvuG/56', '(55) 5555-1113', true, 8, 6, 6, 6);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('33122233304', 'Wesley Carvalho', 'wsCarvalho@gmail.com', '$2a$10$CixShkZdu94JMSvMcCeyqe02hc6iSQc32f8p98hmQDAoNhgagn6Ki', '(55) 5555-1114', true, 9, 7, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('22122233305', 'Claudinete da Rosa', 'clauRosa@gmail.com', '$2a$10$SAaOLJDFy85KhDNdJAW8p.N/E85SfW/cJ2FAPvaZH4ZSkmZTU2X3K', '(55) 5555-1115', true, 10, 8, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233306', 'João Vitor', 'joVitor@gmail.com', '$2a$10$Ix2GXk2KjIu.bB7UaiCdd.GWeCVd2G9IrBMFUGFK/5tvnaH5GoE/.', '(55) 5555-1116', true, 11, 9, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('00122233307', 'Andrew Silva', 'aSival@gmail.com', '$2a$10$hhmYnB8WySQWp902ER/29uL3QqcNGcyCYC6AFei5fbhf9t91/5.ta', '(55) 5555-1117', true, 12, 10, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('77122233308', 'Anderson Souza', 'anSouza@gamil.com', '$2a$10$bKEcXc2NMLUPZOxqf2h8D.fP7uQg4FKHYqXz4RBFSiM70/B5ulXAe', '(55) 5555-1118', true, 13, 11, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('88122233309', 'Cleitim do Santos', 'cleiSantos@gmail.com', '$2a$10$wL1HKN7HEkKbGUeOhk2Xj.IK6dLZvKFi9iEI3/9JHDnzDtC6dhOBm', '(55) 5555-1119', true, 14, 12, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('99122233310', 'Flavim de Queira', 'fQueira@gmail.com', '$2a$10$eplEgYyNG.dGp13edOZyv.7eB1Cx.2TdCh7ei8uwBF91hAqETmv7C', '(55) 5555-1120', true, 15, 13, 6, null);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('55122233311', 'Fabinho Melo', 'fMelo@gmail.com', '$2a$10$8cCjOX/CwaQzDuIWSxJJd.H0wIvQ4fhpjR28ZRlfXYIjA.1nNqzIq', '(55) 5555-1121', true, 16, 14, 6, null);


-- Dados fictícios para a tabela Avaliacao (adicionando algumas avaliações)
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Excelente atendimento! Profissionais muito competentes.', 1, 1);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (3, 'Poderia melhorar no atendimento ao cliente.', 3, 3);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Adorei o serviço prestado. Voltarei com certeza!', 4, 4);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Ambiente agradável e profissionais dedicados.', 5, 5);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço de alta qualidade. Recomendo a todos.', 2, 2);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (2, 'Não gostei do serviço. Não atendeu às minhas expectativas.', 1, 6);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Atendimento impecável. Empresa altamente recomendada.', 2, 6);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Bom serviço, mas o preço poderia ser mais acessível.', 3, 5);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (3, 'Esperava mais. Não fiquei completamente satisfeito.', 4, 6);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço excelente! Superou minhas expectativas.', 5, 6);

