drop table if exists CART;
drop table if exists CART_ITEM;
drop table if exists CREDENTIAL;
drop table if exists ORDERED_PRODUCT;
drop table if exists ORDERS;
drop table if exists PRODUCT;
drop table if exists USER;

create table CART (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  USER_ID integer,
  primary key (id))
  engine=MyISAM;

create table CART_ITEM (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  QUANTITY integer,
  CART_ID integer not null,
  PRODUCT_ID integer not null,
  primary key (id))
  engine=MyISAM;

create table CREDENTIAL (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  EMAIL varchar(64),
  IS_IN_BLACK_LIST bit not null,
  LOGIN varchar(255) not null,
  PASSWORD varchar(255) not null,
  ROLE varchar(255) not null,
  primary key (id))
  engine=MyISAM;

create table ORDERED_PRODUCT (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  QUANTITY integer,
  ORDER_ID integer not null,
  PRODUCT_ID integer not null,
  primary key (id))
  engine=MyISAM;

create table ORDERS (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  STATUS varchar(255) not null,
  TOTAL_COST integer,
  USER_ID integer,
  primary key (id))
  engine=MyISAM;

create table PRODUCT (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  CATEGORY varchar(255) not null,
  NAME varchar(255) not null,
  PRICE integer not null,
  QUANTITY integer not null,
  primary key (id))
  engine=MyISAM;

create table USER (
  id integer not null auto_increment,
  CREATED_AT datetime not null,
  MODIFIED_AT datetime,
  ADDRESS varchar(255),
  DISCOUNT integer,
  NAME varchar(255) not null,
  PHONE_NUMBER varchar(255),
  SURNAME varchar(255) not null,
  CREDENTIAL_ID integer not null,
  primary key (id))
  engine=MyISAM;

alter table CREDENTIAL add constraint UK_lb18ba67jvf9gp3cxn3u8re2j unique (EMAIL);
alter table CREDENTIAL add constraint UK_m6x809xwq4ws9yvd1dtamqpr2 unique (LOGIN);
alter table CREDENTIAL add constraint UK_eyql4cryx211o8jneu5ftgbew unique (PASSWORD);
alter table USER add constraint UK_7qvj1s1jc7s9hajf5q2lgkebu unique (CREDENTIAL_ID);
alter table CART add constraint FKf8brys1x787u0vbal3mtbf138 foreign key (USER_ID) references USER (id);
alter table CART_ITEM add constraint FKg42mul038shrflcsxrkaasje4 foreign key (CART_ID) references CART (id);
alter table CART_ITEM add constraint FKguoc9ufbi8ffjxpv8mj7rrhl1 foreign key (PRODUCT_ID) references PRODUCT (id);
alter table ORDERED_PRODUCT add constraint FKlwh94nrj10ef9vshdyjo20a9x foreign key (ORDER_ID) references ORDERS (id);
alter table ORDERED_PRODUCT add constraint FKasa9048cs4ol6vdrlqf59ie6f foreign key (PRODUCT_ID) references PRODUCT (id);
alter table ORDERS add constraint FK90axj458blwuqkm8314rulchx foreign key (USER_ID) references USER (id);
alter table USER add constraint FKrey7tj0xcksoq9xgkafvhhii6 foreign key (CREDENTIAL_ID) references CREDENTIAL (id);
