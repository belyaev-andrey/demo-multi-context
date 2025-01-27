CREATE TABLE components
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       DECIMAL(19, 2)
);
INSERT INTO components (name, description, price)
VALUES ('Arabica Beans', 'Premium Colombian Arabica coffee beans, medium roast', 24.99);

INSERT INTO components (name, description, price)
VALUES ('Oat Milk', 'Barista grade oat milk for perfect coffee drinks', 4.99);

INSERT INTO components (name, description, price)
VALUES ('Vanilla Syrup', 'Natural vanilla flavoring syrup for coffee', 8.99);
