-- Tabela de Produções
CREATE TABLE IF NOT EXISTS producaos (
   id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único da produção
   animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal relacionado
   milk_production_daily DECIMAL(8,2), -- Produção diária de leite (em litros)
   milk_production_cycle DECIMAL(8,2), -- Produção por ciclo (em litros)
   milk_composition DECIMAL(8,2), -- Composição do leite
   carcass_weight DECIMAL(8,2), -- Peso da carcaça (em kg)
   growth_rate DECIMAL(5,2), -- Taxa de crescimento (em %)
   fattening_period DECIMAL(5,2), -- Período de engorda (em meses)
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização
   FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela animals
);
