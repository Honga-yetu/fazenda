-- Tabela de Saúde
CREATE TABLE IF NOT EXISTS saudes (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único da saúde
    animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal relacionado
    weight DECIMAL(8,2), -- Peso do animal (em kg)
    height DECIMAL(5,2), -- Altura do animal (em metros)
    body_condition INT, -- Condição corporal (ex.: pontuação de 1 a 5)
    health_status VARCHAR(255), -- Status de saúde (ex.: saudável, doente)
    last_vaccination_date DATE, -- Data da última vacinação
    disease_history TEXT, -- Histórico de doenças
    allergies TEXT, -- Informações sobre alergias
    health_tests TEXT, -- Testes de saúde realizados
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização
    FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela animals
);
