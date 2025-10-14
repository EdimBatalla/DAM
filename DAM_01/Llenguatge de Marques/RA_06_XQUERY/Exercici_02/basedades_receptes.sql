CREATE DATABASE IF NOT EXISTS receptesDB;
USE receptesDB;

CREATE TABLE IF NOT EXISTS recepta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255),
    temps VARCHAR(50),
    imagen VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ingredient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_recepta INT,
    nom VARCHAR(255),
    FOREIGN KEY (id_recepta) REFERENCES recepta(id)
);

INSERT INTO recepta (titol, temps, imagen) VALUES ('Hummus', '15 minuts', 'IMG/img1.jpg');
INSERT INTO ingredient (id_recepta, nom) VALUES (1, 'Cigrons');
INSERT INTO ingredient (id_recepta, nom) VALUES (1, 'Oli oliva');
INSERT INTO ingredient (id_recepta, nom) VALUES (1, 'Llimona');
INSERT INTO recepta (titol, temps, imagen) VALUES ('Ceviche', '20 minuts', 'IMG/img2.jpg');
INSERT INTO ingredient (id_recepta, nom) VALUES (2, 'Tomate');
INSERT INTO ingredient (id_recepta, nom) VALUES (2, 'Cebolla');
INSERT INTO ingredient (id_recepta, nom) VALUES (2, 'Pescado');
INSERT INTO recepta (titol, temps, imagen) VALUES ('Chocoplatano', '5 minuts', 'IMG/img3.jpg');
INSERT INTO ingredient (id_recepta, nom) VALUES (3, 'Chocolate');
INSERT INTO ingredient (id_recepta, nom) VALUES (3, 'platano');
INSERT INTO ingredient (id_recepta, nom) VALUES (3, 'azucar');

SELECT * FROM recepta;

SELECT r.titol, i.nom AS ingredient
FROM recepta r
JOIN ingredient i ON r.id = i.id_recepta
ORDER BY r.id;