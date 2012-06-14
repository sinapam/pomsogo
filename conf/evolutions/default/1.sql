# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table deal (
  id                        bigint not null,
  title                     varchar(255),
  price                     double,
  constraint pk_deal primary key (id))
;

create sequence deal_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists deal;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists deal_seq;

