DROP TABLE employee;
CREATE TABLE employee (
  `id` BINARY(16) NOT NULL,
  `employee_name` VARCHAR(45) NOT NULL,
  `employee_password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);