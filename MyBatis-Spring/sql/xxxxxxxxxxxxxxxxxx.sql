/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.17 : Database - xxxxxxxxxxxxxxxxxx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xxxxxxxxxxxxxxxxxx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xxxxxxxxxxxxxxxxxx`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `card_num` varchar(255) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `card` */

insert  into `card`(`cid`,`card_num`) values (1,'342501199410010001'),(2,'342501199511272001'),(3,'325011996112998801');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `oid` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `time` varchar(255) DEFAULT NULL COMMENT '订单时间',
  `uid_fk` int(10) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`oid`),
  KEY `uid_fk` (`uid_fk`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`uid_fk`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`oid`,`time`,`uid_fk`) values (1,'2015-11-12',1),(2,'2015-12-1',1),(3,'2016-11-11',1),(4,'2017-6-18',2),(5,'2017-6-20',2),(6,'2017',NULL);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int(10) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  `t_age` int(10) DEFAULT NULL,
  `t_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`t_name`,`t_age`,`t_address`) values (1,'随风飘扬的笑',24,'安徽'),(2,'root',25,'芜湖'),(3,'fgq',25,'阜阳'),(4,'baby',18,'China');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`address`) values (1,'fgq','root',NULL),(2,'FGQ','FGQ',NULL),(3,'FGQ','FGQ',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
