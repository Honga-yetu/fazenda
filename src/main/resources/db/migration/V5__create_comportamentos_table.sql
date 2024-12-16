-- Tabela de Comportamentos
CREATE TABLE IF NOT EXISTS comportamentos (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único do comportamento
    animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal relacionado
    temperament VARCHAR(255), -- Temperamento do animal
    herd_behavior VARCHAR(255), -- Comportamento no rebanho
    handling_ease VARCHAR(255), -- Facilidade de manejo
    performance_history TEXT, -- Histórico de desempenho
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização do registro
    FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela animals
);
