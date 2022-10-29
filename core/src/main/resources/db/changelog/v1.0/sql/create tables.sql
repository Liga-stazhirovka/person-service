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