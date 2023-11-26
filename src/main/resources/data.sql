
-- Dados fictícios para a tabela Endereco (adicionando mais alguns endereços)
    INSERT INTO Endereco (logradouro, numero, estado, complemento, cidade, cep)
    VALUES
        ('Rua X', 567, 'Rio Grande do Sul', 'Apto 202', 'Porto Alegre', '56789-012'),
        ('Avenida Y', 890, 'Bahia', 'Casa 3', 'Salvador', '67890-123'),
        ('Rua Z', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Rua Quinze de novembro', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Rua Azevedo', 111, 'Santa Catarina', 'Bloco 4', 'Florianópolis', '78901-234'),
        ('Av. Nove de Julho', 3186, 'São Paulo', 'Prédio', 'São Paulo', '98901-234');


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
INSERT INTO Servico (nome_Servico, descricao, preco, qtd_Tempo_Servico, fk_Agenda, fk_Empresa)
VALUES
    ('Maquiagem Profissional', 'Maquiagem para eventos especiais', 80.00, '01:30:00', 1, 1),
    ('Manicure e Pedicure', 'Cuidados com as unhas', 50.00, '01:00:00', 2, 2),
    ('Tratamento Capilar', 'Hidratação e cuidados com os cabelos', 60.00, '01:15:00', 3, 3),
    ('Depilação', 'Remoção de pelos', 40.00, '00:45:00',4, 4),
    ('Massagem Relaxante', 'Massagem terapêutica', 70.00, '01:30:00', 5, 5);

-- Dados fictícios para a tabela Historico_Servico (adicionando mais alguns registros)
INSERT INTO Historico_Servico (ano, mes, semana, faturamento, fk_Agenda)
VALUES
    (2023, 5, 11, 1200.00, 1),
    (2023, 5, 12, 1500.00, 2),
    (2023, 5, 13, 1000.00, 3),
    (2023, 6, 14, 1300.00, 4),
    (2023, 6, 15, 1600.00, 5);

    -- Dados fictícios para a tabela Usuario
    INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
    VALUES
        ('11122233344', 'Maria Silva', 'maria@example.com', 'maria123', '(55) 5555-1111', true, 1, 1, 1, 1),
        ('22233344455', 'João Oliveira', 'joao@example.com', 'joao456', '(55) 5555-2222', false, null, 2, 2, 2),
        ('33344455566', 'Ana Souza', 'ana@example.com', 'ana789', '(55) 5555-3333', true, 3, 3, 3, 3),
        ('44455566677', 'Carlos Santos', 'carlos@example.com', 'carlos012', '(55) 5555-4444', false, null, 4, 4, 4),
        ('55566677788', 'Mariana Lima', 'mariana@example.com', 'mariana345', '(55) 5555-5555', true, 5, 5, 5, 5);

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

-- Inserir 2 funcionários
INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('11122233303', 'Leo Jacinto', 'lJacinto@gmail.com', 'senha123', '(55) 5555-1113', false, null, null, null, null),
    ('11122233304', 'Julia Da Viste', 'juVista@gmail.com', 'senha123', '(55) 5555-1114', false, null, null, null, null);



-- Inserir 9 funcionários adicionais
INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)
VALUES
    ('44122233303', 'Gabriel Bebel', 'bebel@gamil.com', 'senha123', '(55) 5555-1113', true, 8, 6, 6, null),
    ('33122233304', 'Wesley Carvalho', 'wsCarvalho@gmail.com', 'senha123', '(55) 5555-1114', true, 9, 7, 6, null),
    ('22122233305', 'Claudinete da Rosa', 'clauRosa@gmail.com', 'senha123', '(55) 5555-1115', true, 10, 8, 6, null),
    ('11122233306', 'João Vitor', 'joVitor@gmail.com', 'senha123', '(55) 5555-1116', true, 11, 9, 6, null),
    ('00122233307', 'Andrew Silva', 'aSival@gmail.com', 'senha123', '(55) 5555-1117', true, 12, 10, 6, null),
    ('77122233308', 'Anderson Souza', 'anSouza@gamil.com', 'senha123', '(55) 5555-1118', true, 13, 11, 6, null),
    ('88122233309', 'Cleitim do Santos', 'cleiSantos@gmail.com', 'senha123', '(55) 5555-1119', true, 14, 12, 6, null),
    ('99122233310', 'Flavim de Queira', 'fQueira@gmail.com', 'senha123', '(55) 5555-1120', true, 15, 13, 6, null),
    ('55122233311', 'Fabinho Melo', 'fMelo@gmail.com', 'senha123', '(55) 5555-1121', true, 16, 14, 6, null);
