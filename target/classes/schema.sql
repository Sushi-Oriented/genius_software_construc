-- PostGres SQL Schema

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id serial PRIMARY KEY NOT NULL,
    studentmatric VARCHAR(9) UNIQUE NOT NULL ,
    studentname VARCHAR(90) NOT NULL
);

-- MySQL Schema

-- DROP TABLE IF EXISTS students;

-- CREATE TABLE students (
--                           id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
--                           studentmatric VARCHAR(9) NOT NULL,
--                           studentname VARCHAR(90) NOT NULL,
--                           PRIMARY KEY (id),
--                           UNIQUE KEY UX_student_matric (studentmatric)
-- );