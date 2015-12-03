-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: vidreria
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria_prod`
--

DROP TABLE IF EXISTS `categoria_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_prod` (
  `id_categoria_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(20) NOT NULL,
  PRIMARY KEY (`id_categoria_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_prod`
--

LOCK TABLES `categoria_prod` WRITE;
/*!40000 ALTER TABLE `categoria_prod` DISABLE KEYS */;
INSERT INTO `categoria_prod` VALUES (4,'Vidrios'),(5,'Productividad'),(6,'Servicios');
/*!40000 ALTER TABLE `categoria_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_persona` (`id_persona`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,'1'),(2,2,'1'),(3,3,'1');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `comprobante` varchar(30) NOT NULL,
  `igv` double NOT NULL,
  `descuento` double DEFAULT NULL,
  `id_proveedor` int(11) NOT NULL,
  `serie` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2015-12-02','Boleta',0.18,1,1,'001'),(2,'2015-10-02','Factura',0.18,2,1,'002'),(3,'2015-12-02','Boleta',0,0,1,'001');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contadores`
--

DROP TABLE IF EXISTS `contadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contadores` (
  `nombre_tabla` varchar(40) NOT NULL,
  `contador` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombre_tabla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contadores`
--

LOCK TABLES `contadores` WRITE;
/*!40000 ALTER TABLE `contadores` DISABLE KEYS */;
INSERT INTO `contadores` VALUES ('compra',3),('venta',20);
/*!40000 ALTER TABLE `contadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crono_pago`
--

DROP TABLE IF EXISTS `crono_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crono_pago` (
  `id_crono_pago` int(11) NOT NULL AUTO_INCREMENT,
  `monto` decimal(6,2) NOT NULL,
  `interes` decimal(4,2) NOT NULL,
  `fecha_pago` date NOT NULL,
  `nro_cuota` varchar(15) NOT NULL,
  PRIMARY KEY (`id_crono_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crono_pago`
--

LOCK TABLES `crono_pago` WRITE;
/*!40000 ALTER TABLE `crono_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `crono_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compra` (
  `id_detalle_compra` int(11) NOT NULL AUTO_INCREMENT,
  `precio_unitario` double NOT NULL,
  `cantidad` int(8) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `importe` double NOT NULL,
  `id_productos` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_compra`),
  KEY `id_productos_idx` (`id_productos`),
  KEY `fk_detalle_compra_compra1_idx` (`id_compra`),
  CONSTRAINT `fk_detalle_compra_compra1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
INSERT INTO `detalle_compra` VALUES (1,12,2,'compra',24,1,1),(2,10,3,'compra',30,2,2),(3,200,19,'',10,7,3);
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) DEFAULT NULL,
  `cantidad` int(6) NOT NULL,
  `precio_unitario` double NOT NULL,
  `importe` double NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_venta`),
  KEY `id_venta` (`id_venta`),
  KEY `fk_detalle_venta_productos1_idx` (`id_productos`),
  CONSTRAINT `fk_detalle_venta_productos1` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_venta1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (20,'venta01',2,45,90,1,1),(21,'venta02',3,50,150,2,2),(22,'',1,50,10,18,1),(23,'',212,50,0,18,2),(24,'',55,50,0,18,2),(25,'',55,50,0,18,2),(26,'',32,50,10,19,1),(27,'',1,50,10,20,2);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apepat` varchar(20) NOT NULL,
  `apemat` varchar(20) DEFAULT NULL,
  `fecha_nac` varchar(10) DEFAULT NULL,
  `sexo` varchar(1) NOT NULL,
  `dni` int(8) DEFAULT NULL,
  `celular` int(10) DEFAULT NULL,
  `telefono` int(8) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Josias','Alcantara','Garcia','1996-10-25','M',71553114,949630192,9191919,'Av. Peru'),(2,'Jorge','Manya','Cieza','1996-03-12','M',18273648,928374637,NULL,'Jr. Leguia'),(3,'Luis','Herrera','Molocho','1996-05-12','M',7162534,91827364,NULL,'Jr. Lima'),(4,'Alberto','Lavado','Lllaro','1994-12-13','M',2343234,91283743,NULL,'SANTA LUCIA'),(5,'Kevin','Calderon','Pariacuri','1993-10-12','M',1235426,949853829,NULL,'Tarapoto'),(6,'Luis','Saavedra','Calderon',NULL,'M',883724,949638292,NULL,'Jr. Leguia'),(7,'Juan','Flores','Gomez',NULL,'M',71546393,918276354,NULL,'Jr. LIMA');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_almacen`
--

DROP TABLE IF EXISTS `producto_almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_almacen` (
  `id_producto_almacen` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_maxima` int(8) NOT NULL,
  `cantidad_minima` int(4) NOT NULL,
  `cantidad` int(9) DEFAULT NULL,
  PRIMARY KEY (`id_producto_almacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_almacen`
--

LOCK TABLES `producto_almacen` WRITE;
/*!40000 ALTER TABLE `producto_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_stock`
--

DROP TABLE IF EXISTS `producto_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_stock` (
  `id_producto_stock` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(8) NOT NULL,
  `cantidad_minima` int(4) DEFAULT NULL,
  `cantidad_maxima` int(8) DEFAULT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `id_producto_almacen` int(11) NOT NULL,
  PRIMARY KEY (`id_producto_stock`),
  KEY `fk_producto_stock_producto_almacen1_idx` (`id_producto_almacen`),
  CONSTRAINT `fk_producto_stock_producto_almacen1` FOREIGN KEY (`id_producto_almacen`) REFERENCES `producto_almacen` (`id_producto_almacen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_stock`
--

LOCK TABLES `producto_stock` WRITE;
/*!40000 ALTER TABLE `producto_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id_productos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `cantidad` int(8) NOT NULL,
  `precio` int(8) NOT NULL,
  `descripcion` varchar(35) DEFAULT NULL,
  `id_categoria_prod` int(11) NOT NULL,
  `id_unidad_medida` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_productos`),
  KEY `id_tipo_producto` (`id_categoria_prod`),
  KEY `id_unidad_medida` (`id_unidad_medida`),
  CONSTRAINT `fk_unidad_medida_ibfk_1` FOREIGN KEY (`id_unidad_medida`) REFERENCES `unidad_medida` (`id_unidad_medida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria_prod`) REFERENCES `categoria_prod` (`id_categoria_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'vidrios',8,45,'vidrio',5,1),(2,'Puerta',14,50,'Productividad',5,2);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `ruc` int(11) NOT NULL,
  `telefono` int(9) NOT NULL,
  `razon_social` varchar(60) DEFAULT NULL,
  `direccion` varchar(60) NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Lima Tambo',7789,1234,'2345','Av. Peru');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pago`
--

DROP TABLE IF EXISTS `tipo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_pago` (
  `id_tipo_pago` int(11) NOT NULL AUTO_INCREMENT,
  `forma_pago` varchar(15) NOT NULL,
  `descripcion` varchar(35) DEFAULT NULL,
  `crono_pago_id_crono_pago` int(11) NOT NULL,
  PRIMARY KEY (`id_tipo_pago`),
  KEY `fk_tipo_pago_crono_pago_idx` (`crono_pago_id_crono_pago`),
  CONSTRAINT `fk_tipo_pago_crono_pago` FOREIGN KEY (`crono_pago_id_crono_pago`) REFERENCES `crono_pago` (`id_crono_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pago`
--

LOCK TABLES `tipo_pago` WRITE;
/*!40000 ALTER TABLE `tipo_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_medida`
--

DROP TABLE IF EXISTS `unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_medida` (
  `id_unidad_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_uni` varchar(30) NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `abreviatura` varchar(10) NOT NULL,
  PRIMARY KEY (`id_unidad_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_medida`
--

LOCK TABLES `unidad_medida` WRITE;
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
INSERT INTO `unidad_medida` VALUES (1,'Metro','metro cuadrado','m^2'),(2,'Unidad','uno','uno');
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  `rol` varchar(15) NOT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'josias','123','Administrador','1'),(2,'polo','123','Secretaria','1');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `comprobante` varchar(20) NOT NULL,
  `serie` varchar(20) DEFAULT NULL,
  `igv` double NOT NULL,
  `descuento` double DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2014-10-12','Boleta','0001',0.18,1,1,1),(2,'2015-10-25','Factura','0002',0,0,2,1),(3,'2015-11-11','Boleta','0003',0,1.5,3,1),(4,'2015-12-02','Boleta','0004',0.18,0,2,1),(18,'2015-12-02','Boleta','001',0,0,1,1),(19,'2015-12-02','Boleta','001',0,0,1,1),(20,'2015-12-02','Boleta','001',0,0,1,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'vidreria'
--

--
-- Dumping routines for database 'vidreria'
--
/*!50003 DROP FUNCTION IF EXISTS `nextval_tabla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval_tabla`(pnombre_tabla varchar(40)) RETURNS int(11)
BEGIN
DECLARE pcontador int(11);
  set pcontador= (select contador+1 from contadores where nombre_tabla=pnombre_tabla);
  update contadores set contador=pcontador where nombre_tabla=pnombre_tabla;
   
   RETURN pcontador;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `registro_compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `registro_compra`(pid_proveedor INT(11), pid_productos INT(11), pcantidad DOUBLE, pprecio_unitario DOUBLE) RETURNS int(11)
BEGIN
DECLARE pid_compra int(11);
set pid_compra= (select nextval_tabla('compra'));

  INSERT INTO compra(id_compra,fecha,comprobante,igv,descuento,id_proveedor,serie) 
   VALUES(pid_compra,sysdate(),'Boleta',0,0,1,'001');

   INSERT INTO detalle_compra (precio_unitario,cantidad,descripcion,importe,id_productos,
							id_compra)
    VALUES (pprecio_unitario,pcantidad,'',10,pid_productos,pid_compra);

    RETURN pid_compra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `registro_venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `registro_venta`(pid_productos INT(11), pcantidad DOUBLE, pprecio_unitario DOUBLE, pid_usuario INT(11)) RETURNS int(11)
BEGIN
DECLARE pid_venta int(11);
set pid_venta= (select nextval_tabla('venta'));

  INSERT INTO venta(id_venta,fecha_venta,comprobante,serie,
   igv,descuento,id_cliente,id_usuario) 
   VALUES(pid_venta,sysdate(),'Boleta','001',0,0,1,pid_usuario);

   INSERT INTO detalle_venta (
     descripcion, cantidad, precio_unitario, importe, id_venta,id_productos)
    VALUES ('',pcantidad,pprecio_unitario,10,pid_venta,pid_productos);

    RETURN pid_venta;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-02 16:44:59
