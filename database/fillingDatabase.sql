use oliviaflowers;
alter table user auto_increment = 1;
insert into user (password, email, phoneNumber, name, surname, dateOfBirth, isAdministrator) 
values ('111111', '11111@mail.ru', '89111111111', 'Анна', 'Иванова', '1991-01-01', true);
insert into user (password, email, phoneNumber, name, surname, dateOfBirth, isAdministrator) 
values ('22222', '22222@mail.ru', '89222222222', 'Иван', 'Сидоров', '1992-02-02', false);
insert into user (password, email, phoneNumber, name, surname, dateOfBirth, isAdministrator) 
values ('333333', '33333@mail.ru', '89333333333', 'Николай', 'Петров', '1993-03-03', false);
insert into user (password, email, phoneNumber, name, surname, dateOfBirth, isAdministrator) 
values ('444444', '444444@mail.ru', '89444444444', 'Ольга', 'Борисова', '1994-04-04', false);
insert into user (password, email, phoneNumber, name, surname, dateOfBirth, isAdministrator) 
values ('555555', '555555@mail.ru', '89555555555', 'Мария', 'Смирнова', '1995-05-05', false);
select * from user;


alter table bouquet auto_increment = 1;
insert into bouquet (name, photo, price, composition) values ('Розы 15 штук', '11111', '2000', 'Розы - 15 шт');
insert into bouquet (name, photo, price, composition) values ('Тюльпаны 21 штука', '22222', '2000', 'Тюльпаны - 21 шт');
insert into bouquet (name, photo, price, composition) values ('Гортензия 3 штуки', '33333', '1500', 'Гортензия - 3 шт');
insert into bouquet (name, photo, price, composition) values ('Хризантемы 7 штук', '44444', '1200', 'Хризантемы - 7 шт');
select * from bouquet;

-- order надо писать с обратными кавычками, так как order является зарезервированным словом
alter table `order` auto_increment = 1;
insert into `order` (idUser, typePostcard, textPostcard, delivery, addressDelivery, dateTimeDelivery, 
sumOrder) values ('1', '3', 'С днем рождения', true, 'Солнечная 35, 45', '2024-04-01 15:00:00', '2000');
insert into `order` (idUser, typePostcard, textPostcard, delivery, addressDelivery, dateTimeDelivery, 
sumOrder) values ('2', '1', 'Люблю', false, 'Красная глинка', '2024-04-02 17:00:00', '3500',);
insert into `order` (idUser, typePostcard, textPostcard, delivery, addressDelivery, dateTimeDelivery, 
sumOrder) values ('1', null, null, true, 'Полевая 43, 85', '2024-04-03 10:00:00', '1200');
insert into `order` (idUser, typePostcard, textPostcard, delivery, addressDelivery, dateTimeDelivery, 
sumOrder) values ('3', '2', 'С днем рождения', true, 'Куйбышева 15, 89', '2024-04-01 12:00:00', '2000');
insert into `order` (idUser, typePostcard, textPostcard, delivery, addressDelivery, dateTimeDelivery, 
sumOrder) values ('4', '3', 'Поздравляю', false, 'Красная глинка', '2024-04-05 20:00:00', '4000');
select * from `order`;

alter table order_has_bouquet auto_increment = 1;
insert into order_has_bouquet (idOrder, idBouquet, count) values ('1', '1', '1');
insert into order_has_bouquet (idOrder, idBouquet, count) values ('2', '2', '1');
insert into order_has_bouquet (idOrder, idBouquet, count) values ('2', '3', '1');
insert into order_has_bouquet (idOrder, idBouquet, count) values ('3', '4', '1');
insert into order_has_bouquet (idOrder, idBouquet, count) values ('4', '2', '1');
insert into order_has_bouquet (idOrder, idBouquet, count) values ('5', '1', '2');
select * from order_has_bouquet;
