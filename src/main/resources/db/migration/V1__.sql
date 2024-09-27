CREATE TABLE settings (
    id SERIAL PRIMARY KEY,
    distance_ratio_threshold double_precision NOT NULL DEFAULT 0.9
);

CREATE TABLE request_content (
    id SERIAL PRIMARY KEY,
    content JSONB NOT NULL
);

CREATE TABLE reg_person (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);

CREATE TABLE verified_name (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255)
);