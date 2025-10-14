-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2025 a las 21:02:37
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_receptes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receptes`
--

CREATE TABLE `receptes` (
  `id` int(11) NOT NULL,
  `titol` varchar(255) NOT NULL,
  `temps` varchar(50) NOT NULL,
  `ingredients` text DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `receptes`
--

INSERT INTO `receptes` (`id`, `titol`, `temps`, `ingredients`, `imagen`) VALUES
(1, 'Hummus', '15 minuts', 'Cigrons, Oli d\'oliva, Llimona', 'IMG/img1.jpg'),
(2, 'Ceviche', '20 minuts', 'tomate, cebolla, pescado', 'IMG/img2.jpg'),
(3, 'chocoplatano', '5 minuts', 'chocolate, platano, azucar', 'IMG/img3.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `receptes`
--
ALTER TABLE `receptes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `receptes`
--
ALTER TABLE `receptes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
