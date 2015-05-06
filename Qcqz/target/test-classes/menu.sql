CREATE DATABASE  IF NOT EXISTS `jcjy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jcjy`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: jcjy
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `tauth`
--

DROP TABLE IF EXISTS `tauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tauth` (
  `CID` varchar(36) NOT NULL,
  `CPID` varchar(36) DEFAULT NULL,
  `CDESC` varchar(200) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  `CURL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK690841C9D157CC0` (`CPID`),
  CONSTRAINT `FK690841C9D157CC0` FOREIGN KEY (`CPID`) REFERENCES `tauth` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tauth`
--

LOCK TABLES `tauth` WRITE;
/*!40000 ALTER TABLE `tauth` DISABLE KEYS */;
INSERT INTO `tauth` VALUES ('0',NULL,'','首页',1,''),('bmadd','bmgl','','部门菜单添加',4,'dept/add'),('bmaddym','bmgl','','添加部门页面',3,'dept/deptAdd'),('bmcx','bmgl','','部门查询',2,'dept/query'),('bmdelete','bmgl','','部门删除',7,'dept/delete'),('bmedit','bmgl','','部门编辑',6,'dept/edit'),('bmeditym','bmgl','','编辑部门页面',5,'dept/deptEdit'),('bmgl','xtgl','','部门管理',5,''),('bmglym','bmgl','','部门管理页面',1,'dept/deptManager'),('cdadd','cdgl','','菜单添加',4,'menu/add'),('cdaddym','cdgl','','添加菜单页面',3,'menu/menuAdd'),('cdcx','cdgl','','菜单查询',2,'menu/query'),('cddelete','cdgl','','菜单删除',7,'menu/delete'),('cdedit','cdgl','','菜单编辑',6,'menu/edit'),('cdeditym','cdgl','','编辑菜单页面',5,'menu/menuEdit'),('cdgl','xtgl','','菜单管理',4,''),('cdglym','cdgl','','菜单管理页面',1,'menu/menuManager'),('jsadd','jsgl','','角色添加',4,'role/add'),('jsaddym','jsgl','','添加角色页面',3,'role/roleAdd'),('jscx','jsgl','','角色查询',2,'role/query'),('jsdelete','jsgl','','角色删除',7,'role/delete'),('jsedit','jsgl','','角色编辑',6,'role/edit'),('jseditym','jsgl','','编辑角色页面',5,'role/roleEdit'),('jsgl','xtgl','','角色管理',2,''),('jsglym','jsgl','','角色管理页面',1,'role/roleManager'),('qxadd','qxgl','','权限添加',4,'auth/add'),('qxaddym','qxgl','','添加权限页面',3,'auth/authAdd'),('qxcx','qxgl','','权限查询',2,'auth/query'),('qxdelete','qxgl','','权限删除',7,'auth/delete'),('qxedit','qxgl','','权限编辑',6,'auth/edit'),('qxeditym','qxgl','','编辑权限页面',5,'auth/authEdit'),('qxgl','xtgl','','权限管理',3,''),('qxglym','qxgl','','权限管理页面',1,'auth/authmanager'),('xtgl','0','','系统管理',2,''),('yhadd','yhgl','','用户添加',4,'user/add'),('yhaddym','yhgl','','添加用户页面',3,'user/addUser'),('yhcx','yhgl','','用户查询',2,'user/query'),('yhedit','yhgl','','用户修改',6,'user/editUser'),('yheditym','yhgl','','修改用户页面',5,'user/editUser'),('yhgl','xtgl','','用户管理',1,''),('yhglym','yhgl','','用户管理页面',1,'user/'),('yhsc','yhgl','','用户删除',7,'user/deleteUser'),('yhxgjs','yhgl','批量修改用户角色','修改角色',9,'user/roleEdit'),('yhxgjsym','yhgl','批量修改用户角色','修改角色页面',8,'user/userRoleEdit');
/*!40000 ALTER TABLE `tauth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tcategories`
--

DROP TABLE IF EXISTS `tcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tcategories` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcategories`
--

LOCK TABLES `tcategories` WRITE;
/*!40000 ALTER TABLE `tcategories` DISABLE KEYS */;
INSERT INTO `tcategories` VALUES ('55561b85-9bb6-42bd-b6a6-76a3dd14ec88',NULL,NULL,'水果',NULL),('f7c279d4-614a-4a69-8290-1132317e515b',NULL,NULL,'蔬菜',NULL);
/*!40000 ALTER TABLE `tcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tclass`
--

DROP TABLE IF EXISTS `tclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tclass` (
  `CID` varchar(36) NOT NULL,
  `CPID` varchar(36) DEFAULT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKCB97D1843908F0` (`CPID`),
  CONSTRAINT `FKCB97D1843908F0` FOREIGN KEY (`CPID`) REFERENCES `tclass` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tclass`
--

LOCK TABLES `tclass` WRITE;
/*!40000 ALTER TABLE `tclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `tclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdept`
--

DROP TABLE IF EXISTS `tdept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdept` (
  `CID` varchar(36) NOT NULL,
  `CPID` varchar(36) DEFAULT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK691A4B99D169D5D` (`CPID`),
  CONSTRAINT `FK691A4B99D169D5D` FOREIGN KEY (`CPID`) REFERENCES `tdept` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdept`
--

LOCK TABLES `tdept` WRITE;
/*!40000 ALTER TABLE `tdept` DISABLE KEYS */;
INSERT INTO `tdept` VALUES ('0',NULL,'所有部门的父级部门',NULL,'总部',0);
/*!40000 ALTER TABLE `tdept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tgroup`
--

DROP TABLE IF EXISTS `tgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tgroup` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CCATEGORYID` varchar(36) DEFAULT NULL,
  `CPROPERTYID` varchar(36) DEFAULT NULL,
  `CCATEGORIESID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKCBD31E8BABE2CCF8` (`CPROPERTYID`),
  KEY `FKCBD31E8BEE91706` (`CCATEGORIESID`),
  KEY `FKCBD31E8B9B67FA28` (`CCATEGORYID`),
  CONSTRAINT `FKCBD31E8B9B67FA28` FOREIGN KEY (`CCATEGORYID`) REFERENCES `tcategories` (`CID`),
  CONSTRAINT `FKCBD31E8BABE2CCF8` FOREIGN KEY (`CPROPERTYID`) REFERENCES `tproperty` (`CID`),
  CONSTRAINT `FKCBD31E8BEE91706` FOREIGN KEY (`CCATEGORIESID`) REFERENCES `tcategories` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tgroup`
--

LOCK TABLES `tgroup` WRITE;
/*!40000 ALTER TABLE `tgroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `tgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tgroupletters`
--

DROP TABLE IF EXISTS `tgroupletters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tgroupletters` (
  `CID` varchar(36) NOT NULL,
  `CGROUPID` varchar(36) DEFAULT NULL,
  `CLETTERID` varchar(36) DEFAULT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK9F65E022E511CA1A` (`CLETTERID`),
  KEY `FK9F65E0223DD75DC6` (`CGROUPID`),
  CONSTRAINT `FK9F65E0223DD75DC6` FOREIGN KEY (`CGROUPID`) REFERENCES `tgroup` (`CID`),
  CONSTRAINT `FK9F65E022E511CA1A` FOREIGN KEY (`CLETTERID`) REFERENCES `tletter` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tgroupletters`
--

LOCK TABLES `tgroupletters` WRITE;
/*!40000 ALTER TABLE `tgroupletters` DISABLE KEYS */;
/*!40000 ALTER TABLE `tgroupletters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tletter`
--

DROP TABLE IF EXISTS `tletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tletter` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CPATH` varchar(100) DEFAULT NULL,
  `PIC_NO` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `WCNUMBER` varchar(100) NOT NULL,
  `PINYIN` varchar(100) NOT NULL,
  `CTERM` varchar(100) DEFAULT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tletter`
--

LOCK TABLES `tletter` WRITE;
/*!40000 ALTER TABLE `tletter` DISABLE KEYS */;
/*!40000 ALTER TABLE `tletter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmenu`
--

DROP TABLE IF EXISTS `tmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmenu` (
  `CID` varchar(36) NOT NULL,
  `CPID` varchar(36) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  `CURL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK695BBD39D1AB477` (`CPID`),
  CONSTRAINT `FK695BBD39D1AB477` FOREIGN KEY (`CPID`) REFERENCES `tmenu` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmenu`
--

LOCK TABLES `tmenu` WRITE;
/*!40000 ALTER TABLE `tmenu` DISABLE KEYS */;
INSERT INTO `tmenu` VALUES ('bjgl','wdgn','icon-group','班级管理',4,'dataEnter/classData.jsp'),('bmgl','xtgl','icon-group','部门管理',2,'admin/dept.jsp'),('cdgl','xtgl','icon-menu','菜单管理',5,'admin/menu.jsp'),('cp','jwgl','icon-role','测评',1,'jwgl/ceping.jsp'),('jsgl','xtgl','icon-role','角色管理',3,'admin/role.jsp'),('jwgl',NULL,'icon-orange','教务管理',3,''),('lbdy','wdgn','icon-group','类别定义',2,'dataEnter/categoriesData.jsp'),('qxgl','xtgl','icon-auth','权限管理',4,'admin/auth.jsp'),('sjlr','wdgn','icon-group','数据录入',3,'dataEnter/enterData.jsp'),('sxdy','wdgn','icon-user','属性定义',1,'dataEnter/propertyData.jsp'),('wdgl','wdgn','icon-role','课程列表',6,'dataEnter/courselist.jsp'),('wdgn',NULL,'icon-orange','文档功能',2,''),('xsgl','wdgn','icon-group','学生管理',5,'dataEnter/studentData.jsp'),('xtgl',NULL,'icon-orange','系统管理',1,''),('yhgl','xtgl','icon-user','用户管理',1,'userControl.jsp'),('zdgl','wdgn','icon-group','字典管理',4,'dataEnter/letterData.jsp');
/*!40000 ALTER TABLE `tmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpic`
--

DROP TABLE IF EXISTS `tpic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpic` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CPATH` varchar(100) DEFAULT NULL,
  `PNO` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `TWORDSID` varchar(36) DEFAULT NULL,
  `TLETTERID` varchar(36) DEFAULT NULL,
  `CTPICID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `TWORDSID` (`TWORDSID`),
  UNIQUE KEY `TLETTERID` (`TLETTERID`),
  KEY `FK366C96BD9D292B` (`TLETTERID`),
  KEY `FK366C9633140741` (`CTPICID`),
  KEY `FK366C966E133E69` (`TWORDSID`),
  CONSTRAINT `FK366C966E133E69` FOREIGN KEY (`TWORDSID`) REFERENCES `twords` (`CID`),
  CONSTRAINT `FK366C9633140741` FOREIGN KEY (`CTPICID`) REFERENCES `tstudentclass` (`CID`),
  CONSTRAINT `FK366C96BD9D292B` FOREIGN KEY (`TLETTERID`) REFERENCES `tletter` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpic`
--

LOCK TABLES `tpic` WRITE;
/*!40000 ALTER TABLE `tpic` DISABLE KEYS */;
/*!40000 ALTER TABLE `tpic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tproperty`
--

DROP TABLE IF EXISTS `tproperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tproperty` (
  `CID` varchar(36) NOT NULL,
  `CPID` varchar(36) DEFAULT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CICONCLS` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKF3D02A494ED294ED` (`CPID`),
  CONSTRAINT `FKF3D02A494ED294ED` FOREIGN KEY (`CPID`) REFERENCES `tproperty` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tproperty`
--

LOCK TABLES `tproperty` WRITE;
/*!40000 ALTER TABLE `tproperty` DISABLE KEYS */;
INSERT INTO `tproperty` VALUES ('594705ef-96f1-4bd5-a2ee-ea5ddc37de59','a62030fe-3174-4072-986b-f2dd8d2b8aa8','','','一期',10),('7cdc6240-706d-43ac-8254-0a96248fe36d','594705ef-96f1-4bd5-a2ee-ea5ddc37de59','','','A级',10),('a62030fe-3174-4072-986b-f2dd8d2b8aa8',NULL,'','','课程列表',10),('fe819010-c679-4ab5-a4f2-ae0459f016ad','7cdc6240-706d-43ac-8254-0a96248fe36d','','','第一节',1);
/*!40000 ALTER TABLE `tproperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trole`
--

DROP TABLE IF EXISTS `trole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trole` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(200) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trole`
--

LOCK TABLES `trole` WRITE;
/*!40000 ALTER TABLE `trole` DISABLE KEYS */;
INSERT INTO `trole` VALUES ('0','系统所有权限','超级管理员'),('1','','Teacher');
/*!40000 ALTER TABLE `trole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `troletauth`
--

DROP TABLE IF EXISTS `troletauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `troletauth` (
  `CID` varchar(36) NOT NULL,
  `CAUTHID` varchar(36) DEFAULT NULL,
  `CROLEID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKC66E1F72BE1CD55E` (`CAUTHID`),
  KEY `FKC66E1F72DACE9F7A` (`CROLEID`),
  CONSTRAINT `FKC66E1F72DACE9F7A` FOREIGN KEY (`CROLEID`) REFERENCES `trole` (`CID`),
  CONSTRAINT `FKC66E1F72BE1CD55E` FOREIGN KEY (`CAUTHID`) REFERENCES `tauth` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `troletauth`
--

LOCK TABLES `troletauth` WRITE;
/*!40000 ALTER TABLE `troletauth` DISABLE KEYS */;
INSERT INTO `troletauth` VALUES ('02b85751-5fba-47fb-aec0-61567b14004e','qxadd','0'),('03ce5756-4dd3-4404-bd96-da8bd3e74c42','jsaddym','0'),('0a217276-bfdf-4889-9f38-f7d2df853f36','yhsc','0'),('0b536073-9744-4d86-88e6-8cdb5c36031a','cdadd','0'),('0cc987db-5276-4153-a4ad-3a585140149e','bmeditym','0'),('1a6a4666-a7bd-4e34-b927-ac92e80cdfa7','yhadd','0'),('24a2b443-2433-4bdd-9bbc-51e2f920fa32','yhglym','0'),('25b00017-1267-4c41-ac0c-39e88461c1d8','bmgl','0'),('260d726d-8c7d-4fef-aff2-382693237f0e','yhedit','0'),('30fb9a80-520f-4ffa-b7d9-37dfa1728187','cdeditym','0'),('35d7ad69-e22c-460e-9b2d-07f1e0afd8ee','cdaddym','0'),('41047d07-f684-4340-9103-19d58d2c1f53','yhaddym','0'),('61665632-ff19-4fea-a56d-c877c2bb1825','cddelete','0'),('62e2576f-9727-4d96-80e6-d0e299d4fa4c','jsgl','0'),('6673452b-8d27-4550-9900-37530a4154eb','qxcx','0'),('691914f3-87ac-4f58-83e7-6b37c82b5410','xtgl','0'),('6e218a6a-1f82-4c0c-b936-ebcf9eda80fe','yhxgjsym','0'),('720e4440-3ce6-44ba-adfe-96fc4e9689f4','jsedit','0'),('790202f4-f3eb-49cc-b340-0fac61feca60','bmcx','0'),('805a0060-ba66-41ab-9329-865babe9a515','qxeditym','0'),('80a2b89d-7ea6-4a47-bd57-9013f659c114','cdedit','0'),('8ea63ba7-7d8d-402b-ba70-a1ab2e371f9f','yhcx','0'),('9866f96b-ece1-4eb3-8f6b-81425343107c','bmedit','0'),('a46ba574-0b6a-4896-85ac-0461ad679406','cdcx','0'),('a8bc25d1-f49e-4476-acab-dcec896bfa79','qxgl','0'),('abae6329-5213-41e4-bfa4-5a2e1cef3c44','jsdelete','0'),('af69e987-1aba-49ac-b251-0a2ebbfb48a0','bmaddym','0'),('b03d5a44-6376-433a-a741-80a5bbe8e75d','0','0'),('bfd8920d-b1ab-4c94-a808-2ded4653cd25','yhgl','0'),('c146a0bc-1262-4662-8286-cf9e23e1e3c2','jsadd','0'),('cd5fc9ed-34ae-4564-89e7-2d79ea353fae','bmglym','0'),('cd82e31f-a763-45f1-9b0a-781ee30bb720','bmadd','0'),('dd8f7494-62e9-42ff-9333-528474c9cdc6','yhxgjs','0'),('df52f5c0-b776-4fa8-b89b-881c97fe2a51','qxedit','0'),('e34d0b92-4ff7-43e3-92fe-eedd5df1b438','jsglym','0'),('e47fbb8c-a223-4825-9f6b-a21e072faf5e','yheditym','0'),('e4fc51f1-45a9-4030-9777-7f2a951d64ce','qxglym','0'),('e6bd6200-d0a0-4180-9a19-c33e3919c714','bmdelete','0'),('ea571d6d-dd8e-4437-801c-09b86764dbca','jseditym','0'),('f034eb3e-4631-4844-a32d-b6a62fb03aa0','qxaddym','0'),('f6e526ac-8b50-40bf-82f3-4f5b3975912e','cdgl','0'),('f857b4af-b38e-46f5-be20-dcc3688a0184','qxdelete','0'),('ff6c0a3e-fd20-47a5-bde7-88dcd5e774fa','jscx','0'),('ff8c0f5b-ffd1-4de1-a514-f61237dd2873','cdglym','0');
/*!40000 ALTER TABLE `troletauth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tstudent`
--

DROP TABLE IF EXISTS `tstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstudent` (
  `CID` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `py` varchar(45) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `used_name` varchar(45) DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `father_mobile` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `mother_mobile` varchar(45) DEFAULT NULL,
  `other_connect` varchar(45) DEFAULT NULL,
  `other_connect_mobile` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `school` varchar(200) DEFAULT NULL,
  `teacher_id` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `picture_id` int(11) DEFAULT NULL,
  `CLASSID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKA206D74732EB8F3B` (`CLASSID`),
  CONSTRAINT `FKA206D74732EB8F3B` FOREIGN KEY (`CLASSID`) REFERENCES `tclass` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tstudent`
--

LOCK TABLES `tstudent` WRITE;
/*!40000 ALTER TABLE `tstudent` DISABLE KEYS */;
/*!40000 ALTER TABLE `tstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tstudentclass`
--

DROP TABLE IF EXISTS `tstudentclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tstudentclass` (
  `CID` varchar(36) NOT NULL,
  `MAINPICTURE` varchar(100) DEFAULT NULL,
  `ASSESSMENT` varchar(200) DEFAULT NULL,
  `CLASSINFO` varchar(100) NOT NULL,
  `CSEQ` datetime DEFAULT NULL,
  `CGROUPID` varchar(36) DEFAULT NULL,
  `CSTUDENTID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK127546913DD75DC6` (`CGROUPID`),
  KEY `FK1275469186BA4EFE` (`CSTUDENTID`),
  CONSTRAINT `FK1275469186BA4EFE` FOREIGN KEY (`CSTUDENTID`) REFERENCES `tstudent` (`CID`),
  CONSTRAINT `FK127546913DD75DC6` FOREIGN KEY (`CGROUPID`) REFERENCES `tgroup` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tstudentclass`
--

LOCK TABLES `tstudentclass` WRITE;
/*!40000 ALTER TABLE `tstudentclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `tstudentclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuser`
--

DROP TABLE IF EXISTS `tuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuser` (
  `CID` varchar(36) NOT NULL,
  `CDEPTID` varchar(36) DEFAULT NULL,
  `CCREATEDATETIME` datetime DEFAULT NULL,
  `CEMAIL` varchar(50) DEFAULT NULL,
  `CMODIFYDATETIME` datetime DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `CPWD` varchar(100) NOT NULL,
  `CREALNAME` varchar(200) NOT NULL,
  `CSN` varchar(36) DEFAULT NULL,
  `CSTATUS` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `CNAME` (`CNAME`),
  UNIQUE KEY `CEMAIL` (`CEMAIL`),
  KEY `FK699923FC2596358` (`CDEPTID`),
  CONSTRAINT `FK699923FC2596358` FOREIGN KEY (`CDEPTID`) REFERENCES `tdept` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuser`
--

LOCK TABLES `tuser` WRITE;
/*!40000 ALTER TABLE `tuser` DISABLE KEYS */;
INSERT INTO `tuser` VALUES ('0','0','2015-02-10 14:29:32','admin@admin.com','2015-02-10 14:29:32','admin','21232f297a57a5a743894a0e4a801fc3','超级管理员',NULL,'0');
/*!40000 ALTER TABLE `tuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tusertrole`
--

DROP TABLE IF EXISTS `tusertrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tusertrole` (
  `CID` varchar(36) NOT NULL,
  `CROLEID` varchar(36) DEFAULT NULL,
  `CUSERID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKC6AB240BE023F4E4` (`CUSERID`),
  KEY `FKC6AB240BDACE9F7A` (`CROLEID`),
  CONSTRAINT `FKC6AB240BDACE9F7A` FOREIGN KEY (`CROLEID`) REFERENCES `trole` (`CID`),
  CONSTRAINT `FKC6AB240BE023F4E4` FOREIGN KEY (`CUSERID`) REFERENCES `tuser` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tusertrole`
--

LOCK TABLES `tusertrole` WRITE;
/*!40000 ALTER TABLE `tusertrole` DISABLE KEYS */;
INSERT INTO `tusertrole` VALUES ('7ebd669d-4ca9-4367-9fca-7892d2a8fac8','0','0');
/*!40000 ALTER TABLE `tusertrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twordletters`
--

DROP TABLE IF EXISTS `twordletters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twordletters` (
  `CID` varchar(36) NOT NULL,
  `CWORDID` varchar(36) DEFAULT NULL,
  `CLETTERID` varchar(36) DEFAULT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FK3D2869CFE511CA1A` (`CLETTERID`),
  KEY `FK3D2869CF4790EBA1` (`CWORDID`),
  CONSTRAINT `FK3D2869CF4790EBA1` FOREIGN KEY (`CWORDID`) REFERENCES `twords` (`CID`),
  CONSTRAINT `FK3D2869CFE511CA1A` FOREIGN KEY (`CLETTERID`) REFERENCES `tletter` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twordletters`
--

LOCK TABLES `twordletters` WRITE;
/*!40000 ALTER TABLE `twordletters` DISABLE KEYS */;
/*!40000 ALTER TABLE `twordletters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twords`
--

DROP TABLE IF EXISTS `twords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twords` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) DEFAULT NULL,
  `CPATH` varchar(100) DEFAULT NULL,
  `PIC_NO` varchar(100) DEFAULT NULL,
  `CNAME` varchar(100) NOT NULL,
  `WCNUMBER` varchar(100) NOT NULL,
  `PINYIN` varchar(100) DEFAULT NULL,
  `CTERM` varchar(100) DEFAULT NULL,
  `CSEQ` decimal(22,0) DEFAULT NULL,
  `CGROUPID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `FKCCB342B53DD75DC6` (`CGROUPID`),
  CONSTRAINT `FKCCB342B53DD75DC6` FOREIGN KEY (`CGROUPID`) REFERENCES `tgroup` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twords`
--

LOCK TABLES `twords` WRITE;
/*!40000 ALTER TABLE `twords` DISABLE KEYS */;
/*!40000 ALTER TABLE `twords` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-10 16:52:48
