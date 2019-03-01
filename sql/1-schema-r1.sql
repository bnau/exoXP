drop schema if exists "computer-database-db" CASCADE;
create schema if not exists "computer-database-db";
SET search_path TO "computer-database-db";

drop sequence if exists seq_computer;
drop sequence if exists seq_company;

drop table if exists computer;
drop table if exists company;

create sequence seq_computer;
create sequence seq_company;

create table company (
  id                        bigint not null DEFAULT nextval('seq_company'),
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null DEFAULT nextval('seq_computer'),
  name                      varchar(255),
  introduced                timestamp NULL,
  discontinued              timestamp NULL,
  company_id                bigint default NULL,
  constraint pk_computer primary key (id))
;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);