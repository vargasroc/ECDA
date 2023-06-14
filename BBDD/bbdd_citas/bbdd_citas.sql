CREATE TABLE citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(255),
author VARCHAR(255),
    category VARCHAR(255)
);
LOAD DATA INFILE 'C:/Users/SL/Desktop/Proyectos/E.C.D.A/BBDD/bbdd_citas/bbdd_citas.cvs' INTO TABLE citas
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS;
