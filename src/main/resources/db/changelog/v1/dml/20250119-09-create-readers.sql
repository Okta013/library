--liquibase formatted sql
--changeset Anikeeva:20250119-09-create-readers

INSERT INTO readers VALUES('51ed71bc-d865-4503-91fd-e3c4e8f2b9cc', 'Михаил', 'Дементьев', 'MALE', '1986-09-13', '89176667755');
INSERT INTO readers VALUES('1323316b-8d7b-43b6-a94c-e4b0a32a13fe', 'Егор', 'Семин', 'MALE', '1997-01-12', '89512345678');
INSERT INTO readers VALUES('25564ef4-d5bf-4319-b3e7-95a9ab743528', 'Ольга', 'Орлова', 'FEMALE', '1972-09-09', '89272727277');
INSERT INTO readers VALUES('86e12755-de66-4fcd-9711-c35964fc9f60', 'Илья', 'Фомин', 'MALE', '1994-07-15', '89378769955');
INSERT INTO readers VALUES('5ba1abd4-c88d-4c89-972f-c60b9ca47e07', 'Дарья', 'Соловьева', 'FEMALE', '1976-04-21', '89022220987')