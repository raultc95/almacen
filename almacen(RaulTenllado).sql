-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-05-2021 a las 11:22:31
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacen`
--
CREATE DATABASE IF NOT EXISTS `almacen` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `almacen`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion`
--

DROP TABLE IF EXISTS `coleccion`;
CREATE TABLE IF NOT EXISTS `coleccion` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `serie` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `volumen`
--

DROP TABLE IF EXISTS `volumen`;
CREATE TABLE IF NOT EXISTS `volumen` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `id_coleccion` int(255) DEFAULT NULL,
  `titulo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `autor` varchar(255) COLLATE utf8_bin NOT NULL,
  `numero` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isbn` varchar(255) COLLATE utf8_bin NOT NULL,
  `editorial` varchar(100) COLLATE utf8_bin NOT NULL,
  `dibujante` varchar(100) COLLATE utf8_bin NOT NULL,
  `entintador` varchar(100) COLLATE utf8_bin NOT NULL,
  `colorista` varchar(100) COLLATE utf8_bin NOT NULL,
  `edicion` varchar(100) COLLATE utf8_bin NOT NULL,
  `color` varchar(100) COLLATE utf8_bin NOT NULL,
  `contenido` text COLLATE utf8_bin NOT NULL,
  `leido` tinyint(1) DEFAULT NULL,
  `portada` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `id_comic` (`id_coleccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `volumen`
--
ALTER TABLE `volumen`
  ADD CONSTRAINT `volumen_ibfk_1` FOREIGN KEY (`id_coleccion`) REFERENCES `coleccion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
