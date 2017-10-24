/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.0.41-community-nt : Database - t_book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`t_book` /*!40100 DEFAULT CHARACTER SET gbk COLLATE gbk_bin */;

USE `t_book`;

/*Table structure for table `t_books` */

DROP TABLE IF EXISTS `t_books`;

CREATE TABLE `t_books` (
  `id` int(11) NOT NULL auto_increment,
  `bookName` varchar(20) character set gbk collate gbk_bin NOT NULL,
  `author` varchar(20) character set gbk collate gbk_bin default NULL,
  `sex` varchar(10) character set gbk collate gbk_bin default NULL,
  `price` float default NULL,
  `bookDesc` varchar(2000) character set gbk collate gbk_bin default NULL,
  `bookTypeId` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_t_books` (`bookTypeId`),
  CONSTRAINT `FK_t_books` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_books` */

insert  into `t_books`(`id`,`bookName`,`author`,`sex`,`price`,`bookDesc`,`bookTypeId`) values (2,'sadfsadf ava','是的是','女',10,'撒旦飞洒的',3),(4,'高性能java','小鹿','女',10,'我会倚天屠龙',3),(5,'打发士大夫','撒打发士大夫','男',102,'士大夫撒旦发生 ',1),(6,'倚天屠龙记','赵敏','女',100,'杀杀 杀',2);

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL auto_increment,
  `bookTypeName` varchar(20) collate gbk_bin NOT NULL,
  `bookDesc` varchar(20) collate gbk_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookDesc`) values (1,'计算机类','科学'),(2,'建筑类','买房子啊'),(3,'生物类','遗传基因');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(20) character set latin1 NOT NULL,
  `password` varchar(20) character set latin1 NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`) values (1,'liupengfei','323323'),(2,'java','323323');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
