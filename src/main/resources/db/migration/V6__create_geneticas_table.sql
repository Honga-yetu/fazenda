-- Tabela de Genéticas
CREATE TABLE IF NOT EXISTS geneticas (
   id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único da genética
   animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal relacionado
   genetic_code VARCHAR(255), -- Código genético
   lineage VARCHAR(255), -- Linhagem
   consanguinity_coefficient DOUBLE, -- Coeficiente de consanguinidade
   father_id BIGINT UNSIGNED, -- ID do pai
   mother_id BIGINT UNSIGNED, -- ID da mãe
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização do registro
   FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE, -- Relacionamento com a tabela animals
   FOREIGN KEY (father_id) REFERENCES animals(id) ON DELETE SET NULL ON UPDATE CASCADE, -- Relacionamento com o pai
   FOREIGN KEY (mother_id) REFERENCES animals(id) ON DELETE SET NULL ON UPDATE CASCADE -- Relacionamento com a mãe
);
