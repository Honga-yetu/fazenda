-- Criação da tabela animals
CREATE TABLE IF NOT EXISTS animals (
     id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     species VARCHAR(255),
     breed VARCHAR(255),
     gender ENUM('Macho', 'Femea') NOT NULL,
     birth_date DATE,
     identification_number VARCHAR(255),
     color VARCHAR(255),
     current_pasture VARCHAR(255),
     fazenda_id BIGINT UNSIGNED,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     FOREIGN KEY (fazenda_id) REFERENCES fazendas(id) ON DELETE SET NULL ON UPDATE CASCADE
);