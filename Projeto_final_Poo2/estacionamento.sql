CREATE DATABASE IF NOT EXISTS estacionamento_db;
USE estacionamento_db;

CREATE TABLE IF NOT EXISTS veiculo (
    placa VARCHAR(10) PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS vaga (
    numero INT PRIMARY KEY,
    estado VARCHAR(20) NOT NULL DEFAULT 'Livre'
);

CREATE TABLE IF NOT EXISTS ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa_veiculo VARCHAR(10) NOT NULL,
    numero_vaga INT NOT NULL,
    hora_entrada DATETIME NOT NULL,
    hora_saida DATETIME,
    servicos_extras VARCHAR(255),
    tipo_cobranca VARCHAR(50),
    valor_total DECIMAL(10,2),
    FOREIGN KEY (placa_veiculo) REFERENCES veiculo(placa),
    FOREIGN KEY (numero_vaga) REFERENCES vaga(numero)
);

INSERT IGNORE INTO vaga (numero, estado) VALUES
(1,'Livre'),(2,'Livre'),(3,'Livre'),(4,'Livre'),(5,'Livre'),
(6,'Livre'),(7,'Livre'),(8,'Livre'),(9,'Livre'),(10,'Livre');
