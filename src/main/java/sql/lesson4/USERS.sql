CREATE TABLE USERS(
ID INT,
CONSTRAINT USERS_ID PRIMARY KEY (ID),
USER_NAME VARCHAR2(50),
PASSWORD VARCHAR2(50),
COUNTRY VARCHAR2(50),
USER_TYPE VARCHAR2(50)
);
CREATE SEQUENCE USER_SQ MINVALUE 1 MAXVALUE 100 START WITH 1 INCREMENT BY 1 ;