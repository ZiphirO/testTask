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
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255)
);
CREATE SEQUENCE sq_reg_person_id START WITH 1 INCREMENT BY 1;

CREATE TABLE verified_name (
    id bigint PRIMARY KEY,
    first_name VARCHAR(255) ,
    other_name VARCHAR(255),
    surname VARCHAR(255) ,
    reg_person_id BIGINT ,
    CONSTRAINT fk_verified_person FOREIGN KEY (reg_person_id) REFERENCES reg_person(id)
);
CREATE SEQUENCE sq_verified_name_id START WITH 1 INCREMENT BY 1;

CREATE TABLE credit_bureau (
    id bigint PRIMARY KEY,
    account_number VARCHAR(255) ,
    account_status VARCHAR(50) ,
    current_balance NUMERIC(19, 5) ,
    date_opened VARCHAR(255) ,
    days_in_arrears INT,
    delinquency_code VARCHAR(10),
    highest_days_in_arrears INT,
    is_your_account BOOLEAN ,
    last_payment_amount NUMERIC(19, 5),
    last_payment_date VARCHAR(255),
    loaded_at VARCHAR(255) ,
    original_amount NUMERIC(19, 5) ,
    overdue_balance NUMERIC(19, 5),
    overdue_date VARCHAR(255),
    product_type_id INT,
    reg_person_id BIGINT ,
    CONSTRAINT fk_reg_person FOREIGN KEY (reg_person_id) REFERENCES reg_person(id)
);
CREATE SEQUENCE sq_credit_bureau_id START WITH 1 INCREMENT BY 1;

CREATE TABLE stop_factor (
    id bigint PRIMARY KEY,
    person_stop_factor BOOLEAN,
    CONSTRAINT fk_reg_person FOREIGN KEY (reg_person_id) REFERENCES reg_person(id)
);
CREATE SEQUENCE sq_credit_bureau_id START WITH 1 INCREMENT BY 1;