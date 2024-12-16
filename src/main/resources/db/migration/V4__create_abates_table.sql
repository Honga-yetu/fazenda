-- Tabela de Abates
CREATE TABLE IF NOT EXISTS abates (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- ID único do abate
    animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal abatido
    slaughter_date DATE NOT NULL, -- Data do abate
    slaughter_weight DECIMAL(8,2), -- Peso do abate
    meat_yield DECIMAL(5,2), -- Rendimento de carne (em %)
    carcass_grade VARCHAR(255), -- Classificação da carcaça
    destination VARCHAR(255), -- Destino da carne
    sale_price DECIMAL(10,2), -- Preço de venda
    observations TEXT, -- Observações adicionais
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização do registro
    FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela animals
);
