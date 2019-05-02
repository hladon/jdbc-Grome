CREATE TABLE STORAGE(
    ID NUMBER ,
    CONSTRAINT STORAGE_PK PRIMARY KEY(ID),
    FORMATS_SUPPORTED NVARCHAR2(100),
    STORAGE_COUNTRY NVARCHAR2(50),
    STORAGE_MAX_SIZE NUMBER
);

CREATE TABLE FILES(
    ID NUMBER ,
    CONSTRAINT FILES_PK PRIMARY KEY(ID),
    NAME NVARCHAR2(50),
    FORMAT NVARCHAR2(20),
    FILE_SIZE NUMBER,
    STORAGE_ID NUMBER,
    CONSTRAINT STORAGE_FK FOREIGN KEY(STORAGE)
    REFERENCES STORAGE(ID)
);

