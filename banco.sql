/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : banco

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2016-10-06 20:41:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidop` varchar(255) NOT NULL,
  `apellidom` varchar(255) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', '70000000', 'Ramon', 'valdez', 'alcacer', '758469');
INSERT INTO `cliente` VALUES ('2', '70000002', 'Jose', 'Cruz', 'Carmona', '524168');
INSERT INTO `cliente` VALUES ('3', '80121314', 'luis', 'cuellar', 'diaz', '748596');
INSERT INTO `cliente` VALUES ('4', '31425364', 'gilberto', 'cueto', 'solano', '147484');
INSERT INTO `cliente` VALUES ('5', '68957425', 'valeria', 'davila', 'cortes', '235645');
INSERT INTO `cliente` VALUES ('6', '34210958', 'omar', 'fuentes', 'cerdan', '841457');
INSERT INTO `cliente` VALUES ('7', '31426870', 'maria', 'forment', 'sanchez', '251030');

-- ----------------------------
-- Table structure for cuenta
-- ----------------------------
DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` double NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `fechaa` date NOT NULL,
  `propietario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_cuenta_fk` (`propietario`),
  CONSTRAINT `cliente_cuenta_fk` FOREIGN KEY (`propietario`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cuenta
-- ----------------------------
INSERT INTO `cuenta` VALUES ('1', '800', 'ahorros', '2016-09-28', '1');
INSERT INTO `cuenta` VALUES ('2', '15000', 'ahorros', '2016-09-28', '1');
INSERT INTO `cuenta` VALUES ('3', '0.5', 'ahorros', '1976-09-04', '2');
INSERT INTO `cuenta` VALUES ('4', '5000', 'ahorros', '2016-06-19', '3');
INSERT INTO `cuenta` VALUES ('5', '12.83', 'ahorros', '2016-09-11', '4');
INSERT INTO `cuenta` VALUES ('6', '400', 'ahorros', '2016-09-11', '4');
INSERT INTO `cuenta` VALUES ('7', '7415', 'ahorros', '2016-09-13', '5');
INSERT INTO `cuenta` VALUES ('8', '0', 'ahorros', '2015-09-05', '6');
INSERT INTO `cuenta` VALUES ('9', '21000', 'ahorros', '2010-11-27', '7');

-- ----------------------------
-- Table structure for movimientos
-- ----------------------------
DROP TABLE IF EXISTS `movimientos`;
CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monto` double NOT NULL,
  `usuario` int(11) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `origenc` int(11) DEFAULT NULL,
  `origene` varchar(255) DEFAULT NULL,
  `destinoc` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_movimientos_fk` (`usuario`),
  KEY `cuenta_movimientos_fk` (`origenc`),
  CONSTRAINT `cuenta_movimientos_fk` FOREIGN KEY (`origenc`) REFERENCES `cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario_movimientos_fk` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of movimientos
-- ----------------------------
INSERT INTO `movimientos` VALUES ('1', '5', '1', 'transferencia', '1', null, '2', '2016-10-05');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'racm', '1234');
INSERT INTO `usuario` VALUES ('2', 'hugo', '4321');
INSERT INTO `usuario` VALUES ('3', 'admin', 'admin');
