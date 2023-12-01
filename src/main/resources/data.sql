CREATE TABLE COIN
(
   ID INTEGER PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(100),
   DATETIME TIMESTAMP,
   PRICE NUMERIC(20, 2),
   QUANTITY NUMERIC(20,10)
);
