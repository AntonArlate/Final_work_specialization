/*
7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
*/

DROP DATABASE IF EXISTS друзья_человека;
CREATE DATABASE друзья_человека;

/*
8. Создать таблицы с иерархией из диаграммы в БД
*/

USE друзья_человека;

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    owner_name VARCHAR(50),
    breed VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
    animal_id BIGINT UNSIGNED NOT NULL UNIQUE,
    kind VARCHAR(50),
    brith_day DATE,
    name VARCHAR(50),
    
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
    animal_id BIGINT UNSIGNED NOT NULL UNIQUE,
    kind VARCHAR(50),
    brith_day DATE,
    name VARCHAR(50),
    
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

DROP TABLE IF EXISTS skill_types;
CREATE TABLE skill_types(
	id SERIAL,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS animal_skill;
CREATE TABLE animal_skill(
	id SERIAL,
    skill_type_id BIGINT UNSIGNED NOT NULL,
    animal_id BIGINT UNSIGNED NOT NULL,
    
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (skill_type_id) REFERENCES skill_types(id),
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);


