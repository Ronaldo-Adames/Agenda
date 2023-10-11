INSERT
INTO
  tb_medico
  (nome, is_active, especialidade)
VALUES
  ('Doutor 1', TRUE, 'Pediatra');

INSERT
INTO
  tb_medico
  (nome, is_active, especialidade)
VALUES
  ('Doutor 2', TRUE, 'Pediatra');

INSERT
INTO
  tb_medico
  (nome, is_active, especialidade)
VALUES
  ('Doutor 3', TRUE, 'ClinicoGeral');

INSERT
INTO
  tb_medico
  (nome, is_active, especialidade)
VALUES
  ('Doutor 4', TRUE, 'ClinicoGeral');


-- Inserção de dados na tabela tb_agenda
INSERT INTO tb_agenda (data_consulta, medico_id, fim, inicio, paciente_nome, tipo_consulta)
VALUES
    ('2023-10-11 08:00:00', 1, 'H_8_00', 'H_8_00', 'Paciente 1', 'Consulta A'),
    ('2023-10-11 09:00:00', 2, 'H_9_00', 'H_9_00', 'Paciente 2', 'Consulta B'),
    ('2023-10-11 10:00:00', 1, 'H_10_00', 'H_10_00', 'Paciente 3', 'Consulta C'),
    ('2023-10-11 11:00:00', 1, 'H_11_00', 'H_11_00', 'Paciente 4', 'Consulta D'),
    ('2023-10-11 12:00:00', 3, 'H_12_00', 'H_12_00', 'Paciente 5', 'Consulta E'),
    ('2023-10-11 13:00:00', 3, 'H_13_00', 'H_13_00', 'Paciente 6', 'Consulta F'),
    ('2023-10-11 14:00:00', 2, 'H_14_00', 'H_14_00', 'Paciente 7', 'Consulta G'),
    ('2023-10-11 15:00:00', 2, 'H_15_00', 'H_15_00', 'Paciente 8', 'Consulta H');
