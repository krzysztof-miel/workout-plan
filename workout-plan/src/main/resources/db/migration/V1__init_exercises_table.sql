CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE exercises (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255),
   reps INT NOT NULL,
   done BOOLEAN NOT NULL
);