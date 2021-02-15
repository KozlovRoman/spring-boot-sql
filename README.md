<p align="center">
  <img src="https://seeklogo.com/images/S/spring-logo-9A2BC78AAF-seeklogo.com.png" width="120">
</p>

# Spring Boot, SQL - an example with PostgreSQL and JPA

A simple Spring Boot application and PostgreSQL database connects to this App.

### Technologies
- Spring Boot
- PostrgreSQL
- JPA

I created a simple database called "usersmanagement". 
It will have two tables: users and address. We have a very standard subject area: user management. Users have some attributes and an address.

```sh
create database usersmanagement;

CREATE TABLE public.address
(
    id SERIAL PRIMARY KEY NOT NULL,
    city TEXT,
    street TEXT,
    home_number VARCHAR(5)
);
CREATE UNIQUE INDEX address_id_uindex ON public.address (id);
 
CREATE TABLE public.users
(
    id SERIAL NOT NULL,
    name TEXT,
    email VARCHAR(20),
    address_id INT PRIMARY KEY,
    CONSTRAINT users_address_id_fk FOREIGN KEY (address_id) REFERENCES address (id)
);
CREATE UNIQUE INDEX users_id_uindex ON public.users (id);
```

Since I specified FetchType.LAZY in entities, this will mean that Address will not be automatically retrieved from the database when Account is selected. 
From a performance standpoint, this is a very good practice. Try to avoid FetchType.EAGER in real projects if you want to reduce the number of database queries. 
In order to avoid the above error, you need to add @Transactional annotation above the service methods. This should fix the problem.

## Contributions are welcome!

This App is open source. Feel free to suggest and implement improvements.
