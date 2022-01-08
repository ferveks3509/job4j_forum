insert into authorities (authority) values ('ROLE_USER') ON CONFLICT DO NOTHING;
insert into authorities (authority) values ('ROLE_ADMIN') ON CONFLICT DO NOTHING;

insert into posts (name) values ('О чем этот форум?') ON CONFLICT DO NOTHING;
insert into posts (name) values ('Правила форума.') ON CONFLICT DO NOTHING;