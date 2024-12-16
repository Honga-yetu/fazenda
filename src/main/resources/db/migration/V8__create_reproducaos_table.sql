-- Tabela de Reprodução
CREATE TABLE IF NOT EXISTS reproducaos (
     id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único da reprodução
     animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal relacionado
     reproductive_status VARCHAR(255), -- Status reprodutivo (ex.: gestante, em cio)
     total_births INT, -- Total de partos realizados
     last_insemination_date DATE, -- Data da última inseminação
     pregnancy_diagnosis_date DATE, -- Data do diagnóstico de gravidez
     expected_birth_date DATE, -- Data esperada do parto
     offspring_per_birth INT, -- Número de filhotes por parto
     fertility_index INT, -- Índice de fertilidade
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização
     FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela animals
);
