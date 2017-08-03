-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.28-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 ssm-maven 的数据库结构
CREATE DATABASE IF NOT EXISTS `ssm-maven` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssm-maven`;


-- 导出  表 ssm-maven.menus 结构
CREATE TABLE IF NOT EXISTS `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名字',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- 正在导出表  ssm-maven.menus 的数据：~6 rows (大约)
DELETE FROM `menus`;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` (`id`, `name`, `parentId`) VALUES
	(1, '系统管理', NULL),
	(2, '用户管理', 1),
	(3, '角色管理', 1),
	(4, '菜单管理', 1),
	(5, '系统通告', NULL),
	(8, '节假日通知', 5);
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;


-- 导出  表 ssm-maven.roles 结构
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '角色的名字',
  `descr` varchar(50) DEFAULT NULL COMMENT '角色的描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  ssm-maven.roles 的数据：~2 rows (大约)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`, `descr`) VALUES
	(1, 'superAdmin', '超级管理员，所有功能'),
	(2, 'admin', '系统管理员，系统信息'),
	(3, 'guest', '访客');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- 导出  表 ssm-maven.role_menu 结构
CREATE TABLE IF NOT EXISTS `role_menu` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- 正在导出表  ssm-maven.role_menu 的数据：~0 rows (大约)
DELETE FROM `role_menu`;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` (`roleId`, `menuId`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 8),
	(1, 5),
	(2, 1),
	(2, 2),
	(3, 5),
	(3, 8),
	(2, 5),
	(2, 8);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;


-- 导出  表 ssm-maven.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表\r\n';

-- 正在导出表  ssm-maven.user 的数据：~3 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`name`, `password`, `id`) VALUES
	('superAdmin', '1234', 1),
	('admin', '1234', 2),
	('guest', '1234', 3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 ssm-maven.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- 正在导出表  ssm-maven.user_role 的数据：~2 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`userId`, `roleId`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
