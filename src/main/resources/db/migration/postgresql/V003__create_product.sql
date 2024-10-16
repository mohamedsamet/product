CREATE TABLE PRODUCT (
    ID BIGSERIAL PRIMARY KEY,
    PUBLIC_ID UUID NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    CATEGORY VARCHAR(16) NOT NULL
);

CREATE INDEX IDX_PRODUCT_ID ON PRODUCT (ID);
CREATE INDEX IDX_PRODUCT_NAME ON PRODUCT (NAME);
