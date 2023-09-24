CREATE TABLE IF NOT EXISTS BRAND (
  BRAND_ID INTEGER PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS PRICES (
  BRAND_ID INTEGER NOT NULL,
  PRICE_LIST INTEGER NOT NULL,
  PRODUCT_ID INTEGER NOT NULL,
  START_DATE DATETIME NOT NULL,
  END_DATE DATETIME NOT NULL,
  PRIORITY INT NOT NULL,
  PRICE DECIMAL(20,2) NOT NULL,
  RATE DECIMAL(20,2) NOT NULL,
  CURRENCY VARCHAR(10) NOT NULL,
  CONSTRAINT brand_id_brand_fk
    FOREIGN KEY (BRAND_ID)
    REFERENCES BRAND (BRAND_ID));

CREATE INDEX active_product_with_high_priority_idx ON PRICES (PRODUCT_ID, BRAND_ID, START_DATE, END_DATE, PRIORITY);
CREATE INDEX product_id_idx ON PRICES(PRODUCT_ID);
CREATE INDEX active_date_idx ON PRICES (START_DATE, END_DATE);