CREATE TABLE `comprador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(90) NOT NULL,
  `apellidos` varchar(90) NOT NULL,
  `usuario` varchar(90) NOT NULL,
  `correo` varchar(90) NOT NULL,
  `foto` mediumblob,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `comprador_eliminado` (
  `idcomprador_eliminado` int NOT NULL,
  `nombres` varchar(90) NOT NULL,
  `apellidos` varchar(90) NOT NULL,
  `usuario` varchar(90) NOT NULL,
  `correo` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE DEFINER=`root`@`localhost` TRIGGER `comprador_BEFORE_DELETE` BEFORE DELETE ON `comprador` FOR EACH ROW BEGIN
INSERT INTO `bbasket_bd`.`comprador_eliminado`
(`idcomprador_eliminado`,
`nombres`,
`apellidos`,
`usuario`,
`correo`)
VALUES
(OLD.id,
OLD.nombres,
OLD.apellidos,
OLD.usuario,
OLD.correo);

END