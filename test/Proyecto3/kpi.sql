-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2017 a las 10:38:02
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kpi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `dia` int(11) DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `linea` varchar(6) DEFAULT NULL,
  `tema` varchar(35) DEFAULT NULL,
  `operacion` varchar(5) DEFAULT NULL,
  `area` varchar(40) DEFAULT NULL,
  `problema` varchar(100) DEFAULT NULL,
  `cliente` varchar(15) DEFAULT NULL,
  `noParte` varchar(20) DEFAULT NULL,
  `cantPzas` int(11) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `noParteCambio` varchar(20) DEFAULT NULL,
  `scrap` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`dia`, `mes`, `anio`, `linea`, `tema`, `operacion`, `area`, `problema`, `cliente`, `noParte`, `cantPzas`, `duracion`, `noParteCambio`, `scrap`) VALUES
(3, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PREV', '124655442', 47, 54, '', 0),
(4, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 48, 60, '', 0),
(5, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 140, 60, '', 0),
(5, 10, 2017, 'L003', 'Tecnicas', '1190', 'Mecanicos', 'Falla st.1190 no da inicio ciclo', 'VW', '1179009', 0, 60, '', 0),
(5, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525103', 71, 40, '', 0),
(6, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 107, 47, '', 0),
(7, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'FORD', '1180603', 230, 60, '', 0),
(7, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 145, 60, '', 0),
(10, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312156', 82, 36, '', 0),
(10, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 112, 60, '', 0),
(11, 10, 2017, 'L612', 'Cambio de Modelo', 'L612', 'Planeado', 'CNH-0124315056 a JD-0124515194', 'CNH', '124315056', 0, 13, '124515194', 0),
(11, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312158', 76, 33, '', 0),
(12, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 126, 54, '', 0),
(12, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 225, 60, '', 0),
(12, 10, 2017, 'L612', 'Tecnicas', '1230', 'Mecanicos', 'Cambio de electrodos', 'GM', '124425105', 0, 8, '', 0),
(13, 10, 2017, 'L022', 'Organizacionales', 'L022', 'Logistica', 'Desabasto de material - Logistica interna', 'VW', '125716010', 0, 27, '', 0),
(13, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'AUDI', '1174605', 80, 40, '', 0),
(13, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 125, 53, '', 0),
(14, 10, 2017, 'L022', 'Tecnicas', '1080', 'Reajuste Maquina', 'Reajuste punteadora', 'GM', '126312010', 0, 22, '', 0),
(15, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 44, 54, '', 0),
(16, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(17, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(26, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CNH', '124625059', 42, 60, '', 0),
(27, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 151, 57, '', 0),
(27, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 36, 60, '', 0),
(28, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'JD', '124625091', 43, 60, '', 0),
(30, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 145, 55, '', 0),
(30, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124525164', 43, 60, '', 0),
(1, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 40, 60, '', 0),
(1, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 114, 50, '', 0),
(3, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655076', 42, 60, '', 0),
(4, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 144, 60, '', 0),
(4, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 42, 60, '', 0),
(6, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124625120', 'AFIL', '124525164', 0, 10, '124625120', 0),
(7, 11, 2017, 'L625', 'Calidad', '1070', 'Scrap Maquina', 'Regulador danado en proceso', 'PAC', '124625076', 0, 10, '', 1),
(8, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 65, 35, '', 0),
(8, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179009', 220, 55, '', 0),
(8, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CUMM', '124655130', 36, 52, '', 0),
(9, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 100, 60, '', 0),
(9, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 150, 38, '', 0),
(9, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625098', 42, 60, '', 0),
(10, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 128, 56, '', 0),
(10, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'NAVI-0124625048 a PAC-0124625076', 'NAVI', '124625048', 0, 10, '124625076', 0),
(11, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124525109', 'AFIL', '124525164', 0, 10, '124525109', 0),
(11, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'JD', 'F000BL0310', 56, 25, '', 0),
(13, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'CAT-0124655162 a CAT-0124625081', 'CAT', '124655162', 0, 10, '124625081', 0),
(13, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 131, 60, '', 0),
(14, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', 'AFIL', 42, 60, '', 0),
(3, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PREV', '124655442', 47, 54, '', 0),
(4, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 48, 60, '', 0),
(5, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 140, 60, '', 0),
(5, 10, 2017, 'L003', 'Tecnicas', '1190', 'Mecanicos', 'Falla st.1190 no da inicio ciclo', 'VW', '1179009', 0, 60, '', 0),
(5, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525103', 71, 40, '', 0),
(6, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 107, 47, '', 0),
(7, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'FORD', '1180603', 230, 60, '', 0),
(7, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 145, 60, '', 0),
(10, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312156', 82, 36, '', 0),
(10, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 112, 60, '', 0),
(11, 10, 2017, 'L612', 'Cambio de Modelo', 'L612', 'Planeado', 'CNH-0124315056 a JD-0124515194', 'CNH', '124315056', 0, 13, '124515194', 0),
(11, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312158', 76, 33, '', 0),
(12, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 126, 54, '', 0),
(12, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 225, 60, '', 0),
(12, 10, 2017, 'L612', 'Tecnicas', '1230', 'Mecanicos', 'Cambio de electrodos', 'GM', '124425105', 0, 8, '', 0),
(13, 10, 2017, 'L022', 'Organizacionales', 'L022', 'Logistica', 'Desabasto de material - Logistica interna', 'VW', '125716010', 0, 27, '', 0),
(13, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'AUDI', '1174605', 80, 40, '', 0),
(13, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 125, 53, '', 0),
(14, 10, 2017, 'L022', 'Tecnicas', '1080', 'Reajuste Maquina', 'Reajuste punteadora', 'GM', '126312010', 0, 22, '', 0),
(15, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 44, 54, '', 0),
(16, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(17, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(26, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CNH', '124625059', 42, 60, '', 0),
(27, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 151, 57, '', 0),
(27, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 36, 60, '', 0),
(28, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'JD', '124625091', 43, 60, '', 0),
(30, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 145, 55, '', 0),
(30, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124525164', 43, 60, '', 0),
(1, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 40, 60, '', 0),
(1, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 114, 50, '', 0),
(3, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655076', 42, 60, '', 0),
(4, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 144, 60, '', 0),
(4, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 42, 60, '', 0),
(6, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124625120', 'AFIL', '124525164', 0, 10, '124625120', 0),
(7, 11, 2017, 'L625', 'Calidad', '1070', 'Scrap Maquina', 'Regulador danado en proceso', 'PAC', '124625076', 0, 10, '', 1),
(8, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 65, 35, '', 0),
(8, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179009', 220, 55, '', 0),
(8, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CUMM', '124655130', 36, 52, '', 0),
(9, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 100, 60, '', 0),
(9, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 150, 38, '', 0),
(9, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625098', 42, 60, '', 0),
(10, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 128, 56, '', 0),
(10, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'NAVI-0124625048 a PAC-0124625076', 'NAVI', '124625048', 0, 10, '124625076', 0),
(11, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124525109', 'AFIL', '124525164', 0, 10, '124525109', 0),
(11, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'JD', 'F000BL0310', 56, 25, '', 0),
(13, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'CAT-0124655162 a CAT-0124625081', 'CAT', '124655162', 0, 10, '124625081', 0),
(13, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 131, 60, '', 0),
(14, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', 'AFIL', 42, 60, '', 0),
(3, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PREV', '124655442', 47, 54, '', 0),
(4, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 48, 60, '', 0),
(5, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 140, 60, '', 0),
(5, 10, 2017, 'L003', 'Tecnicas', '1190', 'Mecanicos', 'Falla st.1190 no da inicio ciclo', 'VW', '1179009', 0, 60, '', 0),
(5, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525103', 71, 40, '', 0),
(6, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 107, 47, '', 0),
(7, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'FORD', '1180603', 230, 60, '', 0),
(7, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 145, 60, '', 0),
(10, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312156', 82, 36, '', 0),
(10, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 112, 60, '', 0),
(11, 10, 2017, 'L612', 'Cambio de Modelo', 'L612', 'Planeado', 'CNH-0124315056 a JD-0124515194', 'CNH', '124315056', 0, 13, '124515194', 0),
(11, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312158', 76, 33, '', 0),
(12, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 126, 54, '', 0),
(12, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 225, 60, '', 0),
(12, 10, 2017, 'L612', 'Tecnicas', '1230', 'Mecanicos', 'Cambio de electrodos', 'GM', '124425105', 0, 8, '', 0),
(13, 10, 2017, 'L022', 'Organizacionales', 'L022', 'Logistica', 'Desabasto de material - Logistica interna', 'VW', '125716010', 0, 27, '', 0),
(13, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'AUDI', '1174605', 80, 40, '', 0),
(13, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 125, 53, '', 0),
(14, 10, 2017, 'L022', 'Tecnicas', '1080', 'Reajuste Maquina', 'Reajuste punteadora', 'GM', '126312010', 0, 22, '', 0),
(15, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 44, 54, '', 0),
(16, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(17, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(26, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CNH', '124625059', 42, 60, '', 0),
(27, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 151, 57, '', 0),
(27, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 36, 60, '', 0),
(28, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'JD', '124625091', 43, 60, '', 0),
(30, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 145, 55, '', 0),
(30, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124525164', 43, 60, '', 0),
(1, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 40, 60, '', 0),
(1, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 114, 50, '', 0),
(3, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655076', 42, 60, '', 0),
(4, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 144, 60, '', 0),
(4, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 42, 60, '', 0),
(6, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124625120', 'AFIL', '124525164', 0, 10, '124625120', 0),
(7, 11, 2017, 'L625', 'Calidad', '1070', 'Scrap Maquina', 'Regulador danado en proceso', 'PAC', '124625076', 0, 10, '', 1),
(8, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 65, 35, '', 0),
(8, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179009', 220, 55, '', 0),
(8, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CUMM', '124655130', 36, 52, '', 0),
(9, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 100, 60, '', 0),
(9, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 150, 38, '', 0),
(9, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625098', 42, 60, '', 0),
(10, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 128, 56, '', 0),
(10, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'NAVI-0124625048 a PAC-0124625076', 'NAVI', '124625048', 0, 10, '124625076', 0),
(11, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124525109', 'AFIL', '124525164', 0, 10, '124525109', 0),
(11, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'JD', 'F000BL0310', 56, 25, '', 0),
(13, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'CAT-0124655162 a CAT-0124625081', 'CAT', '124655162', 0, 10, '124625081', 0),
(13, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 131, 60, '', 0),
(14, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', 'AFIL', 42, 60, '', 0),
(3, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PREV', '124655442', 47, 54, '', 0),
(4, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 48, 60, '', 0),
(5, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 140, 60, '', 0),
(5, 10, 2017, 'L003', 'Tecnicas', '1190', 'Mecanicos', 'Falla st.1190 no da inicio ciclo', 'VW', '1179009', 0, 60, '', 0),
(5, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525103', 71, 40, '', 0),
(6, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 107, 47, '', 0),
(7, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'FORD', '1180603', 230, 60, '', 0),
(7, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 145, 60, '', 0),
(10, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312156', 82, 36, '', 0),
(10, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 112, 60, '', 0),
(11, 10, 2017, 'L612', 'Cambio de Modelo', 'L612', 'Planeado', 'CNH-0124315056 a JD-0124515194', 'CNH', '124315056', 0, 13, '124515194', 0),
(11, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312158', 76, 33, '', 0),
(12, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312102', 126, 54, '', 0),
(12, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 225, 60, '', 0),
(12, 10, 2017, 'L612', 'Tecnicas', '1230', 'Mecanicos', 'Cambio de electrodos', 'GM', '124425105', 0, 8, '', 0),
(13, 10, 2017, 'L022', 'Organizacionales', 'L022', 'Logistica', 'Desabasto de material - Logistica interna', 'VW', '125716010', 0, 27, '', 0),
(13, 10, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'AUDI', '1174605', 80, 40, '', 0),
(13, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 125, 53, '', 0),
(14, 10, 2017, 'L022', 'Tecnicas', '1080', 'Reajuste Maquina', 'Reajuste punteadora', 'GM', '126312010', 0, 22, '', 0),
(15, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 44, 54, '', 0),
(16, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(17, 10, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'VW', '124525091', 110, 47, '', 0),
(26, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CNH', '124625059', 42, 60, '', 0),
(27, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 151, 57, '', 0),
(27, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 36, 60, '', 0),
(28, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'JD', '124625091', 43, 60, '', 0),
(30, 10, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 145, 55, '', 0),
(30, 10, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124525164', 43, 60, '', 0),
(1, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625120', 40, 60, '', 0),
(1, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 114, 50, '', 0),
(3, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655076', 42, 60, '', 0),
(4, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'VW', '125716010', 144, 60, '', 0),
(4, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', '124655099', 42, 60, '', 0),
(6, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124625120', 'AFIL', '124525164', 0, 10, '124625120', 0),
(7, 11, 2017, 'L625', 'Calidad', '1070', 'Scrap Maquina', 'Regulador danado en proceso', 'PAC', '124625076', 0, 10, '', 1),
(8, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL06Z9', 65, 35, '', 0),
(8, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179009', 220, 55, '', 0),
(8, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'CUMM', '124655130', 36, 52, '', 0),
(9, 11, 2017, 'L612', 'Piezas Producidas', 'L612', '', '', 'NISSAN', 'F000BL04L6', 100, 60, '', 0),
(9, 11, 2017, 'L003', 'Piezas Producidas', 'L003', '', '', 'VW', '1179517', 150, 38, '', 0),
(9, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'PAC', '124625098', 42, 60, '', 0),
(10, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 128, 56, '', 0),
(10, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'NAVI-0124625048 a PAC-0124625076', 'NAVI', '124625048', 0, 10, '124625076', 0),
(11, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'AFIL-0124525164 a PAC-0124525109', 'AFIL', '124525164', 0, 10, '124525109', 0),
(11, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'JD', 'F000BL0310', 56, 25, '', 0),
(13, 11, 2017, 'L625', 'Cambio de Modelo', 'L625', 'Planeado', 'CAT-0124655162 a CAT-0124625081', 'CAT', '124655162', 0, 10, '124625081', 0),
(13, 11, 2017, 'L022', 'Piezas Producidas', 'L022', '', '', 'GM', '126312142', 131, 60, '', 0),
(14, 11, 2017, 'L625', 'Piezas Producidas', 'L625', '', '', 'AFIL', 'AFIL', 42, 60, '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dat`
--

CREATE TABLE `dat` (
  `valor` int(11) NOT NULL,
  `timepo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dat`
--

INSERT INTO `dat` (`valor`, `timepo`) VALUES
(12, '2017-11-01'),
(5, '2017-11-29'),
(45, '2017-11-30'),
(20, '2017-11-28'),
(20, '2017-11-28'),
(45, '2017-11-20');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
