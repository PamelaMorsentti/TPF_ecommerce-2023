-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2023 a las 21:51:09
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpf_ecommerce`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `tamaño` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `enable` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `categoria`, `descripcion`, `foto`, `nombre`, `precio`, `tamaño`, `tipo`, `enable`) VALUES
(1, 'lacteos', 'Sachet', '', 'Leche entera La Serenisima', 260.92, 1, 'perecedero', NULL),
(2, 'lacteos', 'Sachet', '', 'Leche parcialemte descremada La Serenisima', 260.92, 1, 'perecedero', NULL),
(3, 'lacteos', 'Pote', '', 'Queso entero untable La Serenisima', 545.7, 290, 'perecedero', NULL),
(4, 'lacteo', 'Pote', '', 'Postre Danette dulce de leche', 259.9, 85, 'perecedero', NULL),
(5, 'lacteo', 'Pote', '', 'Flan Deli con caramelo', 223.4, 95, 'perecedero', NULL),
(6, 'lacteo', 'pan', '', 'Manteca DIA', 607.95, 200, 'perecedero', NULL),
(7, 'lacteo', 'Pote', '', 'Yogur Cremoso La Serenisima', 63.8, 120, 'perecedero', NULL),
(8, 'carnes', 'bolsa', '', 'Solomillo de cerdo congelado', 2399, 1000, 'perecedero', NULL),
(9, 'carnes', 'bolsa', '', 'Lechón congelado', 999, 1000, 'perecedero', NULL),
(10, 'carnes', 'bolsa', '', 'Tapa de nalga envasada al vacío', 2199, 1000, 'perecedero', NULL),
(11, 'carnes', 'bolsa', '', 'Pollo fresco', 599, 1000, 'perecedero', NULL),
(12, 'carnes', 'bolsa', '', 'Asado de novillo al vacío', 2199, 1000, 'perecedero', NULL),
(13, 'carnes', 'bolsa', '', 'Carne picada especial', 2898, 1000, 'perecedero', NULL),
(14, 'panaderia', 'bolsa', '', 'Pan rallado Mama Cocina', 272.39, 1000, 'perecedero', NULL),
(15, 'panaderia', 'bolsa', '', 'Pan lactal blanco Fargo', 525.2, 550, 'perecedero', NULL),
(16, 'panaderia', 'bolsa', '', 'Pan de hamburguesa sin TACC Binifit con sésamo', 639.27, 120, 'perecedero', NULL),
(17, 'panaderia', 'bolsa', '', 'Madalenas DIA vainilla', 492.77, 180, 'perecedero', NULL),
(18, 'panaderia', 'bolsa', '', 'Pudin Doubel Chocolate con chips', 763.6, 300, 'perecedero', NULL),
(19, 'panaderia', 'bolsa', '', 'Pan de molde doble integral', 689.6, 570, 'perecedero', NULL),
(20, 'panaderia', 'bolsa', '', 'Budin de chocolate Pureza', 165.2, 250, 'perecedero', NULL),
(21, 'panaderia', 'bolsa', '', 'Pan flauta', 66.03, 1, 'perecedero', NULL),
(22, 'panaderia', 'bolsa', '', 'Pan para pancho', 357.4, 390, 'perecedero', NULL),
(23, 'verduleria', 'bolsa', '', 'Limon', 199, 1000, 'perecedero', NULL),
(24, 'verduleria', 'bolsa', '', 'Anco', 139, 1000, 'perecedero', NULL),
(25, 'verduleria', 'bolsa', '', 'Palta', 209, 1000, 'perecedero', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
