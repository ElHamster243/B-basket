#tabla para almacenar las cuentas de los clientes
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  UNIQUE KEY `correo_UNIQUE` (`correo`)
);
#tabla para almacenar los productos
CREATE TABLE `bbasket_db`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `tamano` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);
#tabla para almacenar la información de las tiendas
CREATE TABLE `bbasket_db`.`tienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `colonia` VARCHAR(45) NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE
);
#tabla para almacenar y relacionar las ofertas, tiendas y productos
CREATE TABLE `bbasket_db`.`oferta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `precio` VARCHAR(15) NOT NULL,
  `descuento` VARCHAR(15) NULL,
  `producto` INT NOT NULL,
  `tienda` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `contiene_idx` (`producto` ASC) VISIBLE,
  INDEX `oferta_idx` (`tienda` ASC) VISIBLE,
  CONSTRAINT `contiene`
    FOREIGN KEY (`producto`)
    REFERENCES `bbasket_db`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `oferta`
    FOREIGN KEY (`tienda`)
    REFERENCES `bbasket_db`.`tienda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
