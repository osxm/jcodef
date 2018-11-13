
DROP DATABASE IF EXISTS dashx;
CREATE DATABASE IF NOT EXISTS dashx DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE dashx;
SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `base_chart`;
CREATE TABLE `base_chart` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) DEFAULT NULL COMMENT '图表名称',
  `description` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图表';

insert into `dashx`.`base_chart`(`name`,`description`) values('Hello World Chart','This is First Dashx Chart');