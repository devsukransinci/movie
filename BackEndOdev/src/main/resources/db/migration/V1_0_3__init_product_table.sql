CREATE TABLE product (
  `id` BINARY(16) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_description` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
