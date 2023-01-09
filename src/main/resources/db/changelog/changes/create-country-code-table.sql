--liquibase formatted sql
--changeset <tchupika>:<create-country-code-table>
CREATE table IF NOT EXISTS countries
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    country_code varchar (255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    country_name varchar (255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (id)
);

insert into countries (country_code, country_name) values ('AD', 'Андорра');
insert into countries (country_code, country_name) values ('AF', 'Афганістан');
insert into countries (country_code, country_name) values ('AG', 'Антиґуа і Барбуда');
insert into countries (country_code, country_name) values ('AL', 'Албанія');
insert into countries (country_code, country_name) values ('AO', 'Ангола');
insert into countries (country_code, country_name) values ('AR', 'Аргентина');
insert into countries (country_code, country_name) values ('AT', 'Австрія');
insert into countries (country_code, country_name) values ('AU', 'Австралія');
insert into countries (country_code, country_name) values ('AZ', 'Азербайджан');
insert into countries (country_code, country_name) values ('BA', 'Боснія і Герцеґовина');
insert into countries (country_code, country_name) values ('BB', 'Барбадос');
insert into countries (country_code, country_name) values ('BD', 'Бангладеш');
insert into countries (country_code, country_name) values ('BE', 'Бельґія');
insert into countries (country_code, country_name) values ('BF', 'Буркіна-Фасо');
insert into countries (country_code, country_name) values ('BG', 'Болгарія');
insert into countries (country_code, country_name) values ('BH', 'Бахрейн');
insert into countries (country_code, country_name) values ('BI', 'Бурунді');
insert into countries (country_code, country_name) values ('BJ', 'Бенін');
insert into countries (country_code, country_name) values ('BN', 'Бруней');
insert into countries (country_code, country_name) values ('BO', 'Болівія');
insert into countries (country_code, country_name) values ('BR', 'Бразілія');
insert into countries (country_code, country_name) values ('BS', 'Багамські Острови');
insert into countries (country_code, country_name) values ('BT', 'Бутан');
insert into countries (country_code, country_name) values ('BW', 'Ботсвана');
insert into countries (country_code, country_name) values ('BY', 'Білорусь');
insert into countries (country_code, country_name) values ('BZ', 'Беліз');
insert into countries (country_code, country_name) values ('DZ', 'Алжир');

--rollback DROP TABLE countries;