CREATE TABLE fruit (
	fruit_id INT unsigned NOT NULL AUTO_INCREMENT,
	fruit_name VARCHAR(255) NOT NULL,
	stocking_date DATE NOT NULL,
	unit VARCHAR(255) NOT NULL,
	price INT unsigned NOT NULL,
	origin VARCHAR(255) NOT NULL,
	CONSTRAINT pk_fruit PRIMARY KEY (fruit_id)
);

CREATE TABLE ordered (
	order_id INT unsigned NOT NULL AUTO_INCREMENT,
	customer_name VARCHAR(255) NOT NULL,
	order_date DATE NOT NULL,
	CONSTRAINT pk_order PRIMARY KEY (order_id),
);

CREATE TABLE order_item (
	order_item_id INT unsigned NOT NULL ,
	order_id INT unsigned NOT NULL,
	fruit_id INT unsigned NOT NULL,
	CONSTRAINT pk_order_item PRIMARY KEY (order_item_id),
	CONSTRAINT fk_order FOREIGN KEY order_id REFERENCES ordered(order_id),
	CONSTRAINT fk_fruit FOREIGN KEY fruit_id REFERENCES fruit(fruit_id)
);

INSERT INTO Fruit (fruit_name, stocking_date, unit, price, origin) VALUES ('복숭아', '2023-06-15', '5개', 10000, '옥천');
INSERT INTO Fruit (fruit_name, stocking_date, unit, price, origin) VALUES ('샤인머스켓', '2023-06-12', '1송이', 15000, '오카야마');
INSERT INTO Fruit (fruit_name, stocking_date, unit, price, origin) VALUES ('체리', '2023-06-14', '500g', 9900, '칠레');
INSERT INTO Fruit (fruit_name, stocking_date, unit, price, origin) VALUES ('블루베리', '2023-06-13', '200g', 8000, '미국');
INSERT INTO Fruit (fruit_name, stocking_date, unit, price, origin) VALUES ('망고스틴', '2023-06-10', '500g', 15000, '태국');

INSERT INTO Ordered (fruit_id, quantity) VALUES (1, 2);

