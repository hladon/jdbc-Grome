CREATE TABLE ROOM(
ID INT,
CONSTRAINT ROOM_ID PRIMARY KEY(ID),
NUMBER_OF_GUEST INT,
PRICE NUMBER,
BREAKFAST_INCLUDED NUMBER(1,0),
PETS_ALLOWED NUMBER(1,0) ,
DATE_AVAILABLE_FROM TIMESTAMP,
HOTEL_ID INT,
CONSTRAINT HOTEL_FK FOREIGN KEY (HOTEL)
REFERENCES HOTEL(ID)
);