CREATE TABLE IF NOT EXISTS persons (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    user_role VARCHAR(10),
    person_id INT NOT NULL,
    FOREIGN KEY(person_id) REFERENCES persons(id)
);
