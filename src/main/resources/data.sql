INSERT INTO BRAND (NAME) VALUES ('XYZ');

INSERT INTO PRICES (BRAND_ID, PRICE_LIST, PRODUCT_ID, START_DATE, END_DATE, PRIORITY, PRICE, RATE, CURRENCY)
VALUES
(1, 1, 35455, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.00, 10.00, 'EUR'),
(1, 2, 35455, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 25.45, 8.00, 'EUR'),
(1, 3, 35455, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 30.50, 9.20, 'EUR'),
(1, 4, 35455, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 10.00, 'EUR');