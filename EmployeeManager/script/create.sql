DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
    id  int(11) NOT NULL auto_increment PRIMARY KEY,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
    position VARCHAR(56),
    birth_date DATE,
    hire_date DATE,
    sex CHAR(1),
    salary DECIMAL(9,2),
    bonus DECIMAL(9,2)
);

DROP TABLE IF EXISTS clients;
CREATE TABLE clients (
    id  int(11) NOT NULL auto_increment PRIMARY KEY,
    first_name VARCHAR(56),
    last_name VARCHAR(56)
);