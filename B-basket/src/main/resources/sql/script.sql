CREATE DATABASE `bbasket_db`;
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
CREATE TABLE `oferta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  `descuento` varchar(15) DEFAULT 'SIN DESCUENTO',
  `producto` int NOT NULL,
  `tienda` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contiene_idx` (`producto`),
  KEY `oferta_idx` (`tienda`),
  CONSTRAINT `contiene` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`),
  CONSTRAINT `oferta` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`)
);
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `tamano` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `colonia` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
);
CREATE 
VIEW `tabla` AS
    SELECT 
        `producto`.`nombre` AS `producto`,
        `producto`.`tamano` AS `tamano`,
        `producto`.`marca` AS `marca`,
        `oferta`.`precio` AS `precio`,
        `oferta`.`descuento` AS `oferta`,
        `tienda`.`nombre` AS `tienda`,
        `tienda`.`colonia` AS `colonia`,
        `tienda`.`calle` AS `calle`,
        `tienda`.`numero` AS `numero`
    FROM
        ((`oferta`
        JOIN `producto`)
        JOIN `tienda`)
    WHERE
        ((`oferta`.`producto` = `producto`.`id`)
            AND (`oferta`.`tienda` = `tienda`.`id`))
    ORDER BY `oferta`.`precio`
;

