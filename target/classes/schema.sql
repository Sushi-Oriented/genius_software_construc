-- PostGres SQL Schema

-- DROP TABLE IF EXISTS products;
--
-- CREATE TABLE products (
--                           id serial PRIMARY KEY,
--                           code VARCHAR(9) UNIQUE NOT NULL ,
--                           name VARCHAR(90) NOT NULL,
--                           category VARCHAR(28) NOT NULL,
--                           brand VARCHAR(28) DEFAULT NULL,
--                           type VARCHAR(21) DEFAULT NULL,
--                           description VARCHAR(180) DEFAULT NULL
--   PRIMARY KEY (id),
--   UNIQUE KEY UX_product_code (code)
-- )

-- MySQL Schema

DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                          code VARCHAR(9) NOT NULL,
                          name VARCHAR(90) NOT NULL,
                          category VARCHAR(28) NOT NULL,
                          brand VARCHAR(28) DEFAULT NULL,
                          type VARCHAR(21) DEFAULT NULL,
                          description VARCHAR(180) DEFAULT NULL,
                          PRIMARY KEY (id),
                          UNIQUE KEY UX_product_code (code)
);