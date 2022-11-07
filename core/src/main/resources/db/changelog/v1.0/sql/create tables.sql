CREATE TABLE if not exists medical_card
(
    medical_card_id bigserial PRIMARY KEY,
    client_status   char NOT NULL,
    med_status      char NOT NULL,
    registry_dt     date NOT NULL,
    comment         text,
    CHECK (medical_card.client_status != '' AND medical_card.med_status != '')
);

CREATE TABLE if not exists contact
(
    contact_id   bigserial PRIMARY KEY,
    phone_number varchar(255) UNIQUE NOT NULL,
    email        varchar(32) UNIQUE,
    profile_link text
        CHECK ( contact.phone_number != '' AND contact.email != '' )
);

CREATE TABLE if not exists illness
(
    illness_id      bigserial PRIMARY KEY,
    medical_card_id bigint      NOT NULL UNIQUE REFERENCES medical_card ON DELETE CASCADE ON UPDATE CASCADE,
    type_id         bigint      NOT NULL,
    heaviness       char        NOT NULL,
    appearance_dttm timestamptz NOT NULL,
    recovery_dt     date
        CHECK (illness.heaviness != '' )

);

CREATE TABLE if not exists person_data
(
    person_data_id  bigserial PRIMARY KEY,
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
    address_id bigserial PRIMARY KEY,
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

CREATE TABLE if not exists roles
(
    roles_id  bigserial PRIMARY KEY,
    role_name varchar(255) NOT NULL UNIQUE
        CHECK (role_name != '')
);

CREATE TABLE if not exists users
(
    users_id   bigserial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    email      varchar(255) NOT NULL UNIQUE,
    password   varchar(255) NOT NULL
        CHECK (first_name != '' AND last_name != '' AND email != '' AND password != '')
);

CREATE TABLE if not exists users_roles
(
    users_id bigint NOT NULL REFERENCES users ON DELETE CASCADE ON UPDATE CASCADE,
    roles_id bigint NOT NULL REFERENCES roles ON DELETE CASCADE ON UPDATE CASCADE

);