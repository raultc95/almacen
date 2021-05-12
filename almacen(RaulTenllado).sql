-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 12-05-2021 a las 07:26:29
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `coleccion`
--

INSERT INTO `coleccion` (`id`, `serie`) VALUES
(2, 'Akira'),
(3, 'Grandes Autores de Batman'),
(4, 'DC Comics Colección Novelas Gráficas'),
(5, 'DC Black Label Pocket'),
(6, 'DC Black Label'),
(7, 'Batman y Superman - Colección Novelas Gráficas'),
(8, 'Wonder Woman Saga'),
(9, 'Berserk'),
(10, 'Desaparecido'),
(11, 'Batgirl'),
(12, 'Coleccion Vertigo'),
(13, 'I am a Hero'),
(14, 'Sprite'),
(17, 'Elfen Lied'),
(18, 'Love Hina'),
(19, 'The Witcher'),
(20, 'Bloodborne'),
(21, 'Dark Souls'),
(22, 'Los Muertos Vivientes'),
(23, 'Violence Action'),
(24, 'Gigant'),
(25, 'My Hero Academia'),
(26, 'Gantz'),
(28, 'League of Legends'),
(29, 'Autoconclusivo'),
(30, 'Monster'),
(31, 'Prison School'),
(32, 'Made in Abyss'),
(33, 'DC Pocket'),
(34, 'Ghost in the Shell'),
(35, 'Ibitsu'),
(36, 'Inuyashiki'),
(37, 'Tomie'),
(38, 'Voces en la oscuridad'),
(39, 'Relatos Terrorificos'),
(40, 'Promociones'),
(41, 'Apocalipsis en el Instituto'),
(42, 'Montage'),
(43, 'Sidooh'),
(44, 'Antalogia'),
(45, 'Your Name');

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
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `volumen`
--

INSERT INTO `volumen` (`id`, `id_coleccion`, `titulo`, `autor`, `numero`, `isbn`, `editorial`, `dibujante`, `entintador`, `colorista`, `edicion`, `color`, `contenido`, `leido`, `portada`) VALUES
(1, 5, 'El Regreso del Caballero Oscuro', 'Frank Miller', '', '978-84-18475-42-9 ', 'ECC', 'Frank Miller', 'Klaus Janson', 'Lynn Varley', 'Primera', 'Color', 'The Dark Knight Returns USA', 1, NULL),
(2, 4, 'Batgirl: Año Uno', 'Chuck Dixon, Scott Beatty', '', '978-84-471-0487-1', 'ECC', 'Marcos Martín', 'Álvaro López', 'Javier Rodríguez', 'Primera', 'Color', 'Batgirl: Year One nums 1-9\nBatman num 139', 1, NULL),
(5, 3, 'El Contraataque del Caballero Oscuro', 'Frank Miller', '', '978-84-1744-27-2', 'ECC', 'Frank Miller', 'Frank Miller', 'Lynn Varley', 'Tercera', 'Color', 'Batman: The Dark Knight returns Strikes Again 1-3', 1, NULL),
(6, 7, 'Batman: Victoria Oscura Parte 1', 'Jeph Loeb', '', '978-84-17063-19-1', 'ECC', 'Tim Sale', 'Tim Sale', 'Gregory Wright', 'Primera', 'Color', 'Batman: Dark Victory núms. 0 a 6 USA', 1, NULL),
(7, 7, 'Batman: Victoria Oscura Parte 2', 'Jeph Loeb', '', '978-84-17063-20-7', 'ECC', 'Tim Sale', 'Tim Sale', 'Gregory Wright', 'Primera', 'Color', 'Batman: Dark Victory núms. 7 a 13 USA', 1, NULL),
(8, 6, 'Batman: El Largo Halloween', 'Jeph Loeb', '', '978-84-18225-72-7', 'ECC', 'Tim Sale', 'Riichard Starkings', 'Gregory Wright', 'Segunda', 'Color', 'Batman: The Long Halloween núms. 1-13 USA', 1, NULL),
(9, 8, 'Wonder Woman: Año Uno', 'Greg Rucka', '', '978-84-18043-53-6', 'ECC', 'Nicola Scott, Bilquis Evely', 'Nicola Scott, Bilquis Evely', 'Rómulo Fajardo JR.', 'Primera', 'Color', 'Wonder Woman nums. 2, 4, 6, 8, 10, 12, 14', 1, NULL),
(11, 9, 'Berserk', 'Kentaro Miura', '1', '84-932125-1-2', 'MangaLine', 'Kentaro Miura', 'Kentaro Miura', '', 'Primera', 'Blanco y Negro', 'El Guerrero de las tinieblas\nEl estigma del condenado\nÁngel de la guarda 1ª parte', 1, NULL),
(12, 9, 'Berserk', 'Kentaro Miura', '12', '978-84-9947-378-9', 'EDT', 'Kentaro Miura', 'Kentaro Miura', '', 'Primera', 'Blanco Y Negro', 'Berserk núms 70-79.', 1, NULL),
(13, 5, 'Batman: Año Uno', 'Frank Miller', '', '978-84-18475-38-2', 'ECC', 'David Mazzuccheli', 'David Mazzuccheli', 'Richmond Lewis', 'Primera', 'Color', 'Batman núms. 404-407 USA', 1, NULL),
(14, 5, 'Batman: Asilo Arkham', 'Grant Morrison', '', '978-84-18475-44-3', 'ECC', 'Dave McKean', 'Dave McKean', 'Dave McKean', 'Primera', 'Color', 'Batman: Arkham Asylum USA', 1, NULL),
(15, 5, 'Batman: Caballero Blanco', 'Sean Murphy', '', '978-84-18475-43-6', 'ECC', 'Sean Murphy', 'Sean Murphy', 'Matt Hollingsworth', 'Primera', 'Color', 'Batman: White Knight núms. 1-8 USA', 1, NULL),
(16, 5, 'Batman: Caballero Maldito', 'Jeph Loeb', '', '978-84-18475-41-2', 'ECC', 'Tim Sale', 'Tim Sale', 'Gregory Wright', 'Primera', 'Color', 'Batman: Legends of the Dark Knight Halloween Special núm. 1 USA, \nBatman: Madness - A Legends of the dark Knight Halloween Special USA, \nBatman: Ghosts - A Legends of the Dark Knight Halloween Special USA', 1, NULL),
(18, 7, 'All Star: Batman y Robin Parte 1', 'Frank Miller', '', '978-84-471-2972-0', 'ECC', 'Jim Lee', 'Scott Williams', 'Alex Sinclair', 'Primera', 'Color', 'All-Star Batman and Robin: The Boy Wonder núms. 1-5 USA', 1, NULL),
(19, 7, 'All Star: Batman y Robin Parte 2', 'Frank Miller', '', '978-84-471-2975-1', 'ECC', 'Jim Lee', 'Scott Williams', 'Alex Sinclair', 'Primera', 'Color', 'All-Star Batman and Robin: The Boy Wonder núms. 6-10 USA', 1, NULL),
(20, 6, 'Batman: Condenado', 'Brian Azzarello', 'LIBRO UNO', '978-84-17722-02-9', 'ECC', 'Lee Bermejo', 'Lee Bermejo', 'Lee Bermejo', 'Primera', 'Color', 'Batman: Damned 1', 1, NULL),
(21, 6, 'Batman: Condenado ', 'Brian Azzarello', 'LIBRO DOS', '978-84-17827-32-8', 'ECC', 'Lee Bermejo', 'Lee Bermejo', 'Lee Bermejo', 'Primera', 'Color', 'Batman: Damned 2', 1, NULL),
(22, 6, 'Batman: Condenado ', 'Brian Azzarello', 'LIBRO TRES', '978-84-17960-64-3', 'ECC', 'Lee Bermejo', 'Lee Bermejo', 'Lee Bermejo', 'Primera', 'Color', 'Batman: Damned 3', 1, NULL),
(23, 11, 'Batgirl: Primera Temporada', 'Mairghread Scott', '', '978-84-18120-12-1', 'ECC', 'Paul Pelletier, Elena Casagrande, Scott Godlewski', 'Norm Rapmund, José Marzán JR.', 'Jordie Bellaire, John Kalisz , HI-FI', 'Primera', 'Color', 'Batgirl núms. 25 a 36 USA', 1, NULL),
(24, 12, 'Sandman', 'Neil Gaiman', '1', '978-84-17509-88-0', 'ECC', 'Sam Kieth, Malcom Jomes III, Mike Dringenberg', 'Mike Dringenberg,Malcom Jomes III', 'Daniel Vozzo', 'Primera', 'Color', 'The Sandman núms. 1 a 8 USA', 1, NULL),
(33, 6, 'Catwoman: Si vas a Roma...', 'Jeph Loeb', '', '978-84-18382-94-9', 'ECC', 'Tim Sale', 'Tim Sale', 'Dave Stewart', 'Primera', 'Color', 'Catwoman: When in Rome... núms. 1-6 USA', 1, NULL),
(119, 19, 'The Witcher: La Maldición de los Cuervos', 'Paul Tobin', '', '978-84-679-2716-0', 'Norma Editorial', 'Piotr Kowalski', 'Piotr Kowalski', 'Brad Simpson', 'Segunda', 'Color', 'The Witcher: La Maldicion de los Cuervos núms 1-5', 1, NULL),
(120, 20, 'Bloodborne: La Sed Medicinal', 'Ales Kot', '', '978-84-679-3648', 'Norma Editorial', 'Piotr Kowalski', 'Piotr Kowalski', 'Brad Simpson', 'Primera', 'Color', 'Bloodborne núms 5-8', 1, NULL),
(220, 19, 'The Witcher: De Sangre y Fuego', 'Aleksandra Motyka', '', '978-84-679-3945-3', 'Norma Editorial', 'Marianna Strychowska', 'Marianna Strychowska', 'Lauren Affe', 'Primera', 'Color', 'The Witcher: Of Flesh and Flame nums. 1-4 ', 1, NULL),
(221, 20, 'Bloodborne: Cancion de Cuervos', 'Ales Kot', '', '978-84-679-4041', 'Norma Editorial', 'Piotr Kowalski', 'Piotr Kowalski', 'Brad Simpson', 'Primera', 'Color', 'Bloodborne nums. 9-12', 1, NULL);



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
