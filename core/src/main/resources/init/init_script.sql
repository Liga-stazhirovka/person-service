CREATE TABLE if not exists medical_card
(
    medical_card_id serial PRIMARY KEY,
    client_status   char NOT NULL,
    med_status      char NOT NULL,
    registry_dt     date NOT NULL,
    comment         text,
    CHECK (medical_card.client_status != '' AND medical_card.med_status != '')
);

CREATE TABLE if not exists contact
(
    contact_id   serial PRIMARY KEY,
    phone_number varchar(255) UNIQUE NOT NULL,
    email        varchar(32) UNIQUE,
    profile_link text
        CHECK ( contact.phone_number != '' AND contact.email != '' )
);

CREATE TABLE if not exists illness
(
    illness_id      serial PRIMARY KEY,
    medical_card_id bigint    NOT NULL UNIQUE REFERENCES medical_card ON DELETE CASCADE ON UPDATE CASCADE,
    type_id         bigint    NOT NULL,
    heaviness       char      NOT NULL,
    appearance_dttm timestamp NOT NULL,
    recovery_dt     date      NOT NULL
        CHECK (illness.heaviness != '' )

);

CREATE TABLE if not exists person_data
(
    person_data_id  serial PRIMARY KEY,
    last_name       varchar(255) NOT NULL,
    first_name      varchar(255) NOT NULL,
    birth_dt        date         NOT NULL,
    age             smallint     NOT NULL,
    sex             char         NOT NULL,
    contact_id      bigint       NOT NULL REFERENCES contact ON DELETE CASCADE ON UPDATE CASCADE,
    medical_card_id bigint       NOT NULL UNIQUE REFERENCES medical_card ON DELETE CASCADE ON UPDATE CASCADE,
    parent_id       bigint REFERENCES person_data ON DELETE CASCADE ON UPDATE CASCADE,
    CHECK ( person_data.last_name != '' AND person_data.first_name != '' AND person_data.sex != '' AND age > 0 AND
            person_data.person_data_id != person_data.parent_id)
);

CREATE TABLE if not exists address
(
    address_id serial PRIMARY KEY,
    contact_id bigint       NOT NULL REFERENCES contact ON DELETE CASCADE ON UPDATE CASCADE,
    country_id bigint       NOT NULL,
    city       varchar(255) NOT NULL,
    index      int          NOT NULL,
    street     varchar(255) NOT NULL,
    building   varchar(32)  NOT NULL,
    flat       varchar(32)  NOT NULL
        CHECK ( address.city != '' AND address.street != '' AND address.building != '' AND address.flat != '' AND
                index > 0 )
);

INSERT INTO medical_card (client_status, med_status, registry_dt, comment)
VALUES ('cl_status_1', 'mes_status_1', current_date, 'comment1'),
       ('cl_status_2', 'mes_status_2', current_date, 'comment2'),
       ('cl_status_3', 'mes_status_3', current_date, 'comment3');

INSERT INTO contact(phone_number, email, profile_link)
VALUES ('8-831-222333', 'email1', 'link1'),
       ('8-831-222444', 'email2', 'link2'),
       ('8-831-222555', 'email3', 'link3');

INSERT INTO illness(medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt)
VALUES (1, 10, 'h', current_timestamp, current_date),
       (2, 20, 'h', current_timestamp, current_date),
       (3, 30, 'a', current_timestamp, current_date);


INSERT INTO person_data(last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
VALUES ('last name1', 'first name1', '10-10-2022', 18, 'men', 1, 1, 2),
       ('last name2', 'first name1', '10-08-2020', 50, 'men', 2, 2, NULL),
       ('last name4', 'first name4', '01-10-2005', 18, 'men', 1, 3, NULL);

INSERT INTO address(contact_id, country_id, city, index, street, building, flat)
VALUES (1, 831, 'city1', 603000, 'street1', 130, 159),
       (2, 831, 'city1', 603010, 'street2', 190, 59),
       (3, 750, 'city10', 993910, 'street25', 198, 159);

-- 1.Написать запрос, выводящий общие записи из 2 таблиц
CREATE VIEW public.medical_card_persons AS
SELECT *
FROM medical_card
         JOIN person_data USING (medical_card_id);

--2.Написать запрос, удаляющий повторяющиеся (без учета id) строки в таблице.

CREATE VIEW public.unique_first_name_person_data AS
SELECT p.first_name, p.sex
FROM person_data p
GROUP BY 1, 2;

SELECT *
FROM unique_first_name_person_data;

-- или
DELETE
FROM person_data p
WHERE p.person_data_id NOT IN (
    SELECT MAX(p2.person_data_id)
    FROM person_data p2
    GROUP BY first_name
);

--3.Написать запрос, выводящий первые 50% записей из таблицы
--(первые значит те где наименьший id).
CREATE VIEW public.half_person_data_table AS
SELECT *
FROM person_data p
LIMIT (
    SELECT count(*) / 2
    FROM person_data);

SELECT *
FROM half_person_data_table;

--4. Написать запрос, выводящий список ФЛ c их родителями,
SELECT (p3.first_name) AS child, (p.first_name) AS parent
FROM person_data p
JOIN person_data p3 ON p.person_data_id = p3.parent_id;

