insert into role(name) values ('ROLE_ADMIN');
insert into role(name) values ('ROLE_USER');
insert into role(name) values ('ROLE_MODERATOR');

insert into region(name) values ('Tashkent');
insert into region(name) values ('Surkhandarya');
insert into region(name) values ('Andijan');
insert into region(name) values ('Samarqand');
insert into region(name) values ('Navoiy');


insert into organization(name,region_id) values ('mchj',1);
insert into organization(name,region_id) values ('schj',1);
insert into organization(name,region_id) values ('alka',1);
insert into organization(name,region_id) values ('mer',2);
insert into organization(name,region_id) values ('mel',3);
insert into organization(name,region_id) values ('sel',4);



insert into department(name,organization_id) values ('con',1);
insert into department(name,organization_id) values ('vol',1);
insert into department(name,organization_id) values ('lol',3);
insert into department(name,organization_id) values ('cola',2);
insert into department(name,organization_id) values ('sola',2);
insert into department(name,organization_id) values ('pepsi',4);
insert into department(name,organization_id) values ('nola',1);



insert into employee(name,position,department_id) values ('murod','programmer',1);
insert into employee(name,position,department_id) values ('safar','programmer',1);
insert into employee(name,position,department_id) values ('hello','hello',2);
insert into employee(name,position,department_id) values ('murod','tester',1);
insert into employee(name,position,department_id) values ('murod','yalqov',3);



-- insert into rate(comment,status,created_at,created_by_id,employee_id) values ('juda yomon hizmat',1,'2018-12-12',1,1)