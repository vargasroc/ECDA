CREATE TABLE citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(255),
    category VARCHAR(255)
);
INSERT INTO citas (text, category)
VALUES
    ('Texto de ejemplo 1', 'Semana 1'),
    ('Texto de ejemplo 2', 'Semana 1'),
    ('Texto de ejemplo 3', 'Categoría 1');
