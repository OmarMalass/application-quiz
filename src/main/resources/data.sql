INSERT INTO PRODUCT(name, description, category) VALUES
('product-1', 'This is the first product', 'CAT-1'),
('product-2', 'This is the second product', 'CAT-2'),
('product-3', 'This is the third product', 'CAT-3'),
('product-4', 'This is the fourth product', 'CAT-4'),
('product-5', 'This is the fifth product', 'CAT-5');


INSERT INTO CLIENT(name, last_name, mobile_number) VALUES
('client-1', 'This is the first client', '+199999999'),
('client-2', 'This is the second client','+299999999'),
('client-3', 'This is the third client', '+399999999'),
('client-4', 'This is the fourth client','+499999999'),
('client-5', 'This is the fifth client', '+599999999');

INSERT INTO SALESPERSON(name, last_name) VALUES
('Jim', 'Halpert'),
('Dwight', 'Schrute');


INSERT INTO SALE(salesperson_id, client_id) VALUES
(1,1),
(1,2),
(2,1),
(2,2);

INSERT INTO TRANSACTION(sale_id, product_id, quantity, unit_price) VALUES
(1, 1, 50, 20),
(1, 2, 2, 3000),
(1, 4, 10, 40),
(2, 3, 95, 1),
(2, 1, 10, 1000),
(3, 5, 100, 80),
(4, 1, 17, 40);