insert into user_details(id, birthdate, name) values(1, current_date(), 'Anand');
insert into user_details(id, birthdate, name) values(2, current_date(), 'Mohan');
insert into user_details(id, birthdate, name) values(3, current_date(), 'Sharma');


insert into post(id, desc, user_id) values(1, 'I am Anand Mohan Sharma', 2);
insert into post(id, desc, user_id) values(2, 'I am a backend developer', 2);
insert into post(id, desc, user_id) values(3, 'I use spring-boot for the development', 2);

insert into post(id, desc, user_id) values(4, 'I am Someone', 1);
insert into post(id, desc, user_id) values(5, 'I am a MERN full-stack developer', 1);
insert into post(id, desc, user_id) values(6, 'I use spring-boot for the development', 1);
