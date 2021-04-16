-- Table: users
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    surname VARCHAR(25) DEFAULT NULL,
    phone_number VARCHAR(45) DEFAULT NULL
)
    ENGINE = InnoDB;

-- Table: contacts
CREATE TABLE contacts (
    id_contact INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    surname VARCHAR(25) DEFAULT NULL,
    phone_number VARCHAR(45) DEFAULT NULL,
    id_user INT NOT NULL,
    FOREIGN KEY (id_user) references users(id)
)
    ENGINE = InnoDB;