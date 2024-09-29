CREATE TABLE settings (
    id bigint PRIMARY KEY,
    distance_ratio_threshold real NOT NULL DEFAULT 0.9
);
CREATE SEQUENCE sq_settings_id START WITH 1 INCREMENT BY 1;

CREATE TABLE request_content (
    id bigint PRIMARY KEY,
    content json NOT NULL
);
CREATE SEQUENCE sq_request_content_id START WITH 1 INCREMENT BY 1;

CREATE TABLE reg_person (
    id bigint PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);
CREATE SEQUENCE sq_reg_person_id START WITH 1 INCREMENT BY 1;

CREATE TABLE verified_name (
    id bigint PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);
CREATE SEQUENCE sq_verified_name_id START WITH 1 INCREMENT BY 1;