CREATE DATABASE IF NOT EXISTS bd_receptes DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE bd_receptes;

DROP TABLE IF EXISTS receptes;

CREATE TABLE receptes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    temps VARCHAR(50) NOT NULL,
    ingredients TEXT,
    imagen VARCHAR(255)
);