insert into CREDENTIAL
  (CREATED_AT, MODIFIED_AT, EMAIL, IS_IN_BLACK_LIST, LOGIN, PASSWORD, ROLE)
values
  (timestamp(now()), timestamp(now()),'ivanov@ivanov.com', 0, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'ROLE_ADMIN');
insert into USER
  (CREATED_AT, MODIFIED_AT, ADDRESS, CREDENTIAL_ID, DISCOUNT, NAME, SURNAME, PHONE_NUMBER)
values
    (timestamp(now()), timestamp(now()), 'address1', 1, 0, 'ivan', 'Ivanov', '+1 11 111 11 11');
insert into CART
  (CREATED_AT, MODIFIED_AT, USER_ID, TOTAL_COST)
values (timestamp(now()), timestamp(now()), 1, 0);

insert into CREDENTIAL
  (CREATED_AT, MODIFIED_AT, EMAIL, IS_IN_BLACK_LIST, LOGIN, PASSWORD, ROLE)
values
  (timestamp(now()), timestamp(now()), 'petrov@petrov.com', 0, 'customer0', '862f18ead4fd52b5b4e8dd610ff19f5cc9b100c4', 'ROLE_CUSTOMER');
insert into USER
  (CREATED_AT, MODIFIED_AT, ADDRESS, CREDENTIAL_ID, DISCOUNT, NAME, SURNAME, PHONE_NUMBER)
values
  (timestamp(now()), timestamp(now()), 'address2', 2, 0, 'petr', 'petrov', '+2 22 222 22 22');
insert into CART
  (CREATED_AT, MODIFIED_AT, USER_ID, TOTAL_COST)
values (timestamp(now()), timestamp(now()), 2, 0);

insert into CREDENTIAL
  (CREATED_AT, MODIFIED_AT, EMAIL, IS_IN_BLACK_LIST, LOGIN, PASSWORD, ROLE)
values
  (timestamp(now()), timestamp(now()), 'sidorov@sidorov.com', 0, 'customer1', 'e2ea3c6b50c654e7c809c252b97d94386fb283fc', 'ROLE_CUSTOMER');
insert into USER
  (CREATED_AT, MODIFIED_AT, ADDRESS, CREDENTIAL_ID, DISCOUNT, NAME, SURNAME, PHONE_NUMBER)
values
  (timestamp(now()), timestamp(now()), 'address3', 3, 0, 'sidor', 'sidorov', '+3 33 333 33 33');
insert into CART
  (CREATED_AT, MODIFIED_AT, USER_ID, TOTAL_COST)
values (timestamp(now()), timestamp(now()), 3, 0);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'FIRST', 'product1', 1000, 10);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'FIRST', 'product2', 10000, 5);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'FIRST', 'product3', 2000, 20);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'FIRST', 'product4', 2999, 0);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'SECOND', 'product5', 99, 6);

insert into PRODUCT
  (CREATED_AT, MODIFIED_AT, CATEGORY, NAME, PRICE, QUANTITY)
values
  (timestamp(now()), timestamp(now()), 'SECOND', 'product6', 9999, 99);