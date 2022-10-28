--liquibase formatted sql
--changeset <tchupika>:<create-country-code-table>
CREATE table IF NOT EXISTS countries
(
    id bigint NOT NULL AUTO_INCREMENT,
    country_code varchar (256) NOT NULL,
    country_name varchar (256) NOT NULL,
    constraint country_pk PRIMARY KEY (id)
);
--rollback DROP TABLE countries;

-- add countries
insert into countries (id, country_code, country_name) values (1, 'AD', 'Андорра');
insert into countries (id, country_code, country_name) values (2, 'AF', 'Афганістан');
insert into countries (id, country_code, country_name) values (3, 'AG', 'Антиґуа і Барбуда');
insert into countries (id, country_code, country_name) values (4, 'AL', 'Албанія');
insert into countries (id, country_code, country_name) values (5, 'AO', 'Ангола');
insert into countries (id, country_code, country_name) values (6, 'AR', 'Аргентина');
insert into countries (id, country_code, country_name) values (7, 'AT', 'Австрія');
insert into countries (id, country_code, country_name) values (8, 'AU', 'Австралія');
insert into countries (id, country_code, country_name) values (9, 'AZ', 'Азербайджан');
insert into countries (id, country_code, country_name) values (10, 'BA', 'Боснія і Герцеґовина');
insert into countries (id, country_code, country_name) values (11, 'BB', 'Барбадос');
insert into countries (id, country_code, country_name) values (12, 'BD', 'Бангладеш');
insert into countries (id, country_code, country_name) values (13, 'BE', 'Бельґія');
insert into countries (id, country_code, country_name) values (14, 'BF', 'Буркіна-Фасо');
insert into countries (id, country_code, country_name) values (15, 'BG', 'Болгарія');
insert into countries (id, country_code, country_name) values (16, 'BH', 'Бахрейн');
insert into countries (id, country_code, country_name) values (17, 'BI', 'Бурунді');
insert into countries (id, country_code, country_name) values (18, 'BJ', 'Бенін');
insert into countries (id, country_code, country_name) values (19, 'BN', 'Бруней');
insert into countries (id, country_code, country_name) values (20, 'BO', 'Болівія');
insert into countries (id, country_code, country_name) values (21, 'BR', 'Бразілія');
insert into countries (id, country_code, country_name) values (22, 'BS', 'Багамські Острови');
insert into countries (id, country_code, country_name) values (23, 'BT', 'Бутан');
insert into countries (id, country_code, country_name) values (24, 'BW', 'Ботсвана');
insert into countries (id, country_code, country_name) values (25, 'BY', 'Білорусь');
insert into countries (id, country_code, country_name) values (26, 'BZ', 'Беліз');
insert into countries (id, country_code, country_name) values (27, 'DZ', 'Алжир');

