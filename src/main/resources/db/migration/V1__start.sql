CREATE TABLE settings (
    id bigint PRIMARY KEY,
    distance_ratio_threshold real NOT NULL DEFAULT 0.9
);

CREATE TABLE request_content (
    id bigint PRIMARY KEY,
    content json NOT NULL
);

CREATE TABLE reg_person (
    id bigint PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);

CREATE TABLE verified_name (
    id bigint PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);