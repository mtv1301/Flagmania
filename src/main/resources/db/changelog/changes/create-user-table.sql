--liquibase formatted sql
--changeset <tchupika>:<create-user-table>
CREATE table IF NOT EXISTS flagmania_users
(
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar (256) NOT NULL,
    email varchar (256) NOT NULL,
    password varchar (256) NOT NULL,
    points int DEFAULT 0,
    constraint user_pk PRIMARY KEY (id)
);
--rollback DROP TABLE flagmania_users;

