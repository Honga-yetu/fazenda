-- Tabela de Vendas
CREATE TABLE IF NOT EXISTS vendas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- ID único da venda
    cliente_id BIGINT UNSIGNED NOT NULL, -- ID do cliente
    animal_id BIGINT UNSIGNED NOT NULL, -- ID do animal vendido
    quantity INT, -- Quantidade vendida
    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data da venda
    total_amount DECIMAL(10,2), -- Valor total da venda
    status VARCHAR(20), -- Status da venda (ex.: paga, pendente)
    invoice_no VARCHAR(20), -- Número da fatura
    hash VARCHAR(520), -- Hash de segurança
    hash_control VARCHAR(1), -- Controle de hash
    periodo INT, -- Período (em meses ou anos)
    invoice_date DATE, -- Data de emissão da fatura
    invoice_date_end DATE, -- Data final de emissão da fatura
    invoice_type ENUM('FT','FR','RG','FG','NC'), -- Tipo de fatura (ex.: FT = Fatura, NC = Nota de Crédito)
    fazenda_id BIGINT UNSIGNED NOT NULL, -- ID da fazenda relacionada
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação do registro
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Data de última atualização
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE CASCADE, -- Relacionamento com a tabela clientes
    FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE ON UPDATE CASCADE, -- Relacionamento com a tabela animals
    FOREIGN KEY (fazenda_id) REFERENCES fazendas(id) ON DELETE CASCADE ON UPDATE CASCADE -- Relacionamento com a tabela fazendas
);
