-- Criação da tabela fazendas
CREATE TABLE IF NOT EXISTS fazendas (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(200) NOT NULL,
  localizacao VARCHAR(200),
  lat DECIMAL(8,6),
  lon DECIMAL(8,6),
  provincia VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);