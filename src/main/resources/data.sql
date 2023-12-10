
-- Dados fictícios para a tabela Endereco (adicionando mais alguns endereços)
    INSERT INTO Endereco (logradouro, numero, estado, complemento, cidade, cep)
    VALUES
        ('Rua X', 567, 'Rio Grande do Sul', 'Apto 202', 'RS', '56789-012'),
        ('Avenida Y', 890, 'Bahia', 'Casa 3', 'BH', '67890-123'),
        ('Rua Z', 111, 'Santa Catarina', 'Bloco 4', 'SC', '78901-234'),
        ('Rua Quinze de novembro', 111, 'SC', 'Bloco 4', 'SP', '78901-234'),
        ('Rua Azevedo', 111, 'SC', 'Bloco 4', 'SP', '78901-234'),
        ('Av. Nove de Julho', 3186, 'SP', 'Prédio', 'SP', '98901-234'),
        ('Av. Tucuruvi', 3186, 'SP', 'Prédio', 'SP', '98901-234');

-- Inserções fictícias para a tabela Endereco
INSERT INTO Endereco (logradouro, numero, estado, complemento, cidade, cep)
VALUES
    ('Rua Cabeleireiro 1', 123, 'Rio Grande do Sul', 'Apto 101', 'SP', '56789-012'),
    ('Avenida dos Cortes', 456, 'Bahia', 'Casa 5', 'BH', '67890-123'),
    ('Rua das Tesouras', 789, 'Santa Catarina', 'Bloco 7', 'RS', '78901-234'),
    ('Rua dos Penteados', 222, 'Santa Catarina', 'Bloco 8', 'RS', '78901-234'),
    ('Avenida dos Estilos', 555, 'Santa Catarina', 'Bloco 9', 'RS', '78901-234'),
    ('Av. Cabelo Perfeito', 777, 'SP', 'Prédio', 'SP', '98901-234'),
    ('Av. dos Cortes Modernos', 999, 'SP', 'Prédio', 'SP', '98901-234'),
    ('Rua dos Cortes Elegantes', 111, 'SP', 'Prédio', 'SP', '98901-234'),
    ('Avenida dos Penteados', 333, 'SP', 'Prédio', 'SP', '98901-234'),
    ('Av. Cabelo Fashion', 444, 'RJ', 'Loja 1', 'RJ', '45678-901'),
    ('Rua do Estilo Trendy', 666, 'RJ', 'Loja 2', 'RJ', '45678-901'),
    ('Av. Fashion Hair', 888, 'RJ', 'Loja 3', 'RJ', '45678-901'),
    ('Rua Estilista Chic', 999, 'RS', 'Sala 101', 'RS', '12345-678'),
    ('Av. dos Cortes Sofisticados', 333, 'RS', 'Sala 102', 'RS', '12345-678'),
    ('Rua da Beleza Eterna', 555, 'RS', 'Sala 103', 'RS', '12345-678'),
    ('Av. da Elegância', 777, 'RS', 'Sala 104', 'SP', '12345-678'),
    ('Rua dos Cabelos', 999, 'BA', 'Salão 1', 'SP', '23456-789'),
    ('Av. dos Cortes Divinos', 111, 'BA', 'Salão 2', 'BH', '23456-789'),
    ('Rua dos Estilos Únicos', 333, 'BA', 'Salão 3', 'BH', '23456-789'),
    ('Av. da Beleza', 555, 'BA', 'Salão 4', 'BH', '23456-789');

-- Dados fictícios para a tabela Empresa (adicionando mais algumas empresas)
INSERT INTO Empresa (razao_Social, cnpj, fk_Endereco)
VALUES
    ('Empresa K', '10987654321011', 1),
    ('Empresa L', '21098765432102', 2),
    ('Empresa M', '32109876543203', 3),
    ('Empresa N', '43210987654304', 4),
    ('Empresa O', '54321098765405', 5),
    ('C6 Bank', '11321098765405', 6);

-- Inserções fictícias para a tabela Empresa
INSERT INTO Empresa (razao_Social, cnpj, fk_Endereco)
VALUES
    ('Salão Elegante', '01234567890123', 7),
    ('Estilo Perfeito', '12345678901234', 8),
    ('Cortes Modernos', '23456789012345', 9),
    ('Beleza Fashion', '34567890123456', 10),
    ('Visual Trendy', '45678901234567', 11),
    ('Elegância Total', '56789012345678', 12),
    ('Cortes Charmosos', '67890123456789', 13),
    ('Salão Chic', '78901234567890', 14),
    ('Estilo Único', '89012345678901', 15),
    ('Hair Fashion', '90123456789012', 16),
    ('Eterna Beleza', '10987654321098', 17),
    ('Cabelo Sofisticado', '21098765432109', 18),
    ('Cortes Elegantes', '32109876543210', 19),
    ('Beleza Infinita', '43210987654321', 20),
    ('Estilo Divino', '54321098765432', 21),
    ('Elegância Pura', '65432109876543', 22),
    ('Beleza Celestial', '76543210987654', 23),
    ('Cortes Moderníssimos', '87654321098765', 24),
    ('Estilo Inovador', '98765432109876', 25),
    ('Cabelo Charmoso', '09876543210987', 26);

-- Dados fictícios para a tabela Agenda (adicionando mais alguns agendamentos)
INSERT INTO Agenda (data, hora, status, fk_Empresa)
VALUES
    ('2023-11-05', '09:30:00', 'Agendado',1),
    ('2023-11-06', '14:00:00', 'Agendado',2),
    ('2023-11-07', '16:45:00', 'Reagendado',3),
    ('2023-11-08', '11:15:00', 'Agendado',4),
    ('2023-11-09', '10:00:00', 'Agendado',5);

INSERT INTO Agenda (data, hora, status, fk_Empresa)
VALUES
    ('2023-11-10', '08:00:00', 'Agendado',6),
    ('2023-11-11', '13:30:00', 'Agendado',6),
    ('2023-11-12', '15:45:00', 'Reagendado',6),
    ('2023-11-13', '10:30:00', 'Agendado',6),
    ('2023-11-14', '12:00:00', 'Agendado',6),
    ('2023-11-15', '14:15:00', 'Reagendado',6),
    ('2023-11-16', '09:45:00', 'Agendado',6),
    ('2023-11-17', '16:30:00', 'Agendado',6),
    ('2023-11-18', '11:00:00', 'Reagendado',6),
    ('2023-11-19', '13:15:00', 'Agendado',6),
    ('2023-11-20', '15:00:00', 'Agendado',6),
    ('2023-11-21', '10:45:00', 'Reagendado',6),
    ('2023-11-22', '12:30:00', 'Agendado',6);


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
    INSERT INTO Servico (nome_Servico, categoria, descricao, preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa)
    VALUES
        ('Restauração','Cabelo', 'Restaura a raiz do cabelo', 55.00, '01:10:00', 8, 6),
        ('Botox','Cabelo', 'Relaxamento de cabelo', 65.00, '01:25:00', 9, 6),
        ('Luzes','Tintura', 'Tingir o cabelo com tinta a sua escolha', 75.00, '01:40:00', 10, 5),
        ('Escova','Cabelo', 'Escovamento de cabelo', 85.00, '01:55:00', 11, 6),
        ('Sobracelha','Tintura', 'Limpeza facial na região dos olhos', 95.00, '02:10:00', 12, 6),
        ('Progressiva','Cabelo', 'Alisamento de cabelo', 105.00, '02:25:00', 13, 6),
        ('Lavagem','Barba', 'Lavagem com produtos profissionais', 115.00, '02:40:00', 14, 6),
        ('Aplique','Barba', 'Adição e disfarce de cabelos', 125.00, '02:55:00', 15, 6),
        ('Trança','Barba', 'Penteado de cabelos curtos e longos com trança', 135.00, '03:10:00', 16, 6);

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
    ('44122233303', 'Gabriel Bebel', 'bebel@gmail.com', '$2a$10$Pjfmw8.nxs8NIh.Qqg5Kf.bSHC/GQ5kuic.6teiCCZYl8PCvuG/56', '(55) 5555-1113', true, 8, 6, 6, 6);

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

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233301', 'Alice Oliveira', 'alice@gmail.com', '$2a$10$a1LQnmiQTv3rO4WSh0.cjeamF5fV8SU7U/ipV1.TxqWy5kt3MWPSO', '(55) 5555-1111', true, null, null, 7, 7);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('22233344402', 'Bruno Silva', 'bruno@gmail.com', '$2a$10$B.qAoH3eiN.EEwwL8NwI0.D5BfqcAmvp4CDqSutO4vIaLqUH8oZ.W', '(55) 5555-2222', true, null, null, 8, 8);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('33344455503', 'Clara Souza', 'clara@gmail.com', '$2a$10$OJXtChxys0rL6FBi5o8FRethK3P7YEw6ky47rUIQm38cOPANrEtQy', '(55) 5555-3333', true, null, null, 9, 9);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('44455566604', 'Daniel Santos', 'daniel@gmail.com', '$2a$10$uHp4YgfRykZpOAaRi8zdLerM0bMr/3zIYXPDSYW/CRyXI7NgWP8/u', '(55) 5555-4444', true, null, null, 10, 10);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('55566677705', 'Eva Lima', 'eva@gmail.com', '$2a$10$ypSyOB3HxNDpqgsgRQEo4OKTHEDNRf0WOB8qz77wFMtNi8mO3dxIq', '(55) 5555-5555', true, null, null, 11, 11);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('66677788806', 'Felipe Oliveira', 'felipe@gmail.com', '$2a$10$a/ALn.P/sZMe2Aw3z2ZDYubALOeQjusAiTCqD.CCSlJkcqAEInpcG', '(55) 5555-6666', true, null, null, 12, 12);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('77788899907', 'Gabriela Silva', 'gabriela@gmail.com', '$2a$10$gVhUrOASFLECIEtqW0WZUeXuZv8pSU0CS0zmbUmyn8Lqkj3lmNkh.', '(55) 5555-7777', true, null, null, 13, 13);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('88899900008', 'Henrique Souza', 'henrique@gmail.com', '$2a$10$31.N0iGJCnmvf41UADlKbeCY9NVadczuqKAN.x2S7vLXnLOJLL7XK', '(55) 5555-8888', true, null, null, 14, 14);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('99900011109', 'Isabela Santos', 'isabela@gmail.com', '$2a$10$Aa1rw8Q7fkBJ6r4T1ktnWeek0Y7lgHifpMyeTveO4j3kE.i40VoUy', '(55) 5555-9999', true, null, null, 15, 15);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233310', 'João Lima', 'joao@gmail.com', '$2a$10$UZmsuAOJaP4GuUGB0QuwX.Cr.nZij3v9dD9GTY6HiBOqrf08C5mNa', '(55) 5555-1010', true, null, null, 16, 16);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('22233344411', 'Karen Oliveira', 'karen@gmail.com', '$2a$10$LMKq2XI6vg.fCh.XCfHGXOKCr2ASP53whbrBCzvnI/DmG8hbpMH.O', '(55) 5555-1111', true, null, null, 17, 17);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('33344455512', 'Lucas Silva', 'lucas@gmail.com', '$2a$10$Dp40G5/WM29fSpPsTw/YD.gvQpwIWHowp/im3DSBsbywMy.OE8.06', '(55) 5555-1212', true, null, null, 18, 18);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('44455566613', 'Mariana Souza', 'mariana@gmail.com', '$2a$10$476iMljF7S50J2LV4cGgNuj/FdqH5ii6PcTU8pBiW4SFCzNFoHH3q', '(55) 5555-1313', true, null, null, 19, 19);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('55566677714', 'Nathan Santos', 'nathan@gmail.com', '$2a$10$8jm6nqZbyr/8LVeSDrUpQObOWKeLtyhOsaViFNF1V.3ZzzCCtXiiK', '(55) 5555-1414', true, null, null, 20, 20);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('66677788815', 'Olivia Lima', 'olivia@gmail.com', '$2a$10$mfr7lTksY70hTybTW7CmW.HD9WICpFhkEC95cidjHfAeXsgGwCipy', '(55) 5555-1515', true, null, null, 21, 21);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('77788899916', 'Paulo Oliveira', 'paulo@gmail.com', '$2a$10$DXNzXxrD78.8gKejfOrQGu4GZT2hbOq1udc3EG6jg.yVYqoadhKGu', '(55) 5555-1616', true, null, null, 22, 22);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('88899900017', 'Quezia Souza', 'quezia@gmail.com', '$2a$10$bKyC/6Sbnb3NMcpmWajUi.1XTzx1hdD1MWIJcPnH/80UAi11nDAhy', '(55) 5555-1717', true, null, null, 23, 23);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('99900011118', 'Rafael Santos', 'rafael@gmail.com', '$2a$10$wuHDtxLet6/THTrVC26BUesz8PpLeyn5b3kwcjrvT114eNRz3dmLy', '(55) 5555-1818', true, null, null, 24, 24);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233319', 'Sabrina Lima', 'sabrina@gmail.com', '$2a$10$vFHpIFHIKEhP/L2Jya/bxuP7gTU86k.mygjsP9Q/4/f/W2se56gTG', '(55) 5555-1919', true, null, null, 25, 25);

INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('22233344420', 'Thiago Oliveira', 'thiago@gmail.com', '$2a$10$SZl1Il8T5IjlT7nTvr56E.a2CTQkdhDH9sgr4JVdtx30GCDSCBuzW', '(55) 5555-2020', true, null, null, 26, 26);


-- Dados fictícios para a tabela Avaliacao (adicionando algumas avaliações)
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Excelente atendimento! Profissionais muito competentes.', 1, 1);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Poderia melhorar no atendimento ao cliente.', 2, 2);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Adorei o serviço prestado. Voltarei com certeza!', 3, 3);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Ambiente agradável e profissionais dedicados.', 4, 4);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço de alta qualidade. Recomendo a todos.', 5, 5);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (2, 'Não gostei do serviço. Não atendeu às minhas expectativas.', 6, 6);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Atendimento impecável. Empresa altamente recomendada.', 7, 7);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Bom serviço, mas o preço poderia ser mais acessível.', 8, 8);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (3, 'Esperava mais. Não fiquei completamente satisfeito.', 9, 9);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço excelente! Superou minhas expectativas.', 10, 10);
-- Dados fictícios para a tabela Avaliacao (adicionando algumas avaliações)
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Excelente atendimento! Profissionais muito competentes.', 11, 11);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Poderia melhorar no atendimento ao cliente.', 12, 12);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Adorei o serviço prestado. Voltarei com certeza!', 13, 13);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Ambiente agradável e profissionais dedicados.', 14, 15);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço de alta qualidade. Recomendo a todos.', 16, 16);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (2, 'Não gostei do serviço. Não atendeu às minhas expectativas.', 17, 17);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Atendimento impecável. Empresa altamente recomendada.', 18, 18);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (4, 'Bom serviço, mas o preço poderia ser mais acessível.', 19, 19);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (3, 'Esperava mais. Não fiquei completamente satisfeito.', 20, 20);
INSERT INTO Avaliacao (nivel, comentario, fk_Usuario, fk_Empresa) VALUES (5, 'Serviço excelente! Superou minhas expectativas.', 21, 21);