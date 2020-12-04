/*
SQLyog Ultimate
MySQL - 5.7.31-0ubuntu0.18.04.1 : Database - nqs-base
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_p_probe` */

DROP TABLE IF EXISTS `t_p_probe`;

CREATE TABLE `t_p_probe` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `probe_name` varchar(128) DEFAULT NULL COMMENT '探针名称(探针上报)',
  `probe_alias` varchar(200) DEFAULT NULL COMMENT '探针别名（页面展示所用）',
  `type` smallint(6) DEFAULT NULL COMMENT '探针类型（10-硬探针，11-软探针，20-win探针，12-便携探针，30-安卓探针，31-苹果探针，40-插件探针）',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP（插件）',
  `internet_ip` varchar(50) DEFAULT NULL COMMENT '网关通信接口携带ip（webs中获取的）',
  `status` smallint(6) DEFAULT '10' COMMENT '探针状态（10-在线，20-离线）',
  `operator` smallint(6) DEFAULT '10' COMMENT '运营商编码（10-联通，20-移动，30-电信）（插件）',
  `soft_ver` varchar(64) DEFAULT NULL COMMENT '软件版本（插件）',
  `hb_interval` int(11) DEFAULT '120' COMMENT '心跳间隔（秒）（插件）',
  `log_interval` int(11) DEFAULT '600' COMMENT '日志上报间隔（秒）',
  `data_interval` int(11) DEFAULT '600' COMMENT '数据上报间隔（秒）',
  `flow_interval` int(11) DEFAULT '600' COMMENT '流量采集间隔（秒）',
  `info_interval` int(11) DEFAULT '600' COMMENT '设备信息上报间隔（秒）',
  `last_regist_time` bigint(20) DEFAULT NULL COMMENT '最后注册时间（秒）（插件）',
  `last_heartbeat_time` bigint(20) DEFAULT NULL COMMENT '最后心跳时间（秒）',
  `mq_url` varchar(60) DEFAULT NULL COMMENT 'mq地址',
  `communicate_url` varchar(500) DEFAULT NULL COMMENT '通信地址',
  `flash_server_url` varchar(500) DEFAULT NULL COMMENT 'flash代理地址',
  `auth_url` varchar(500) DEFAULT NULL COMMENT '认证地址',
  `memo` varchar(500) DEFAULT NULL COMMENT '描述（插件）',
  `task_num` int(11) DEFAULT '0' COMMENT '探针上的任务数（插件），平台计算的',
  `loid` varchar(32) DEFAULT NULL COMMENT '设备认证号（固件）',
  `vendor` varchar(100) DEFAULT NULL COMMENT '厂商（固件）',
  `sn` varchar(32) DEFAULT NULL COMMENT '序列号（固件）',
  `pc` varchar(64) DEFAULT NULL COMMENT '设备型号（固件）',
  `ram_size` float DEFAULT NULL COMMENT '内存大小，单位（Mbytes）（固件）',
  `flash_size` float DEFAULT NULL COMMENT 'Flash 大小，单位（Mbytes）（固件）',
  `mac` varchar(64) DEFAULT NULL COMMENT '获取设备MAC（可作为设备标识）（固件）',
  `firm_ver` varchar(64) DEFAULT NULL COMMENT '光猫软件版本（固件）',
  `hard_ver` varchar(64) DEFAULT NULL COMMENT '光猫硬件版本（固件）',
  `cpu` varchar(64) DEFAULT NULL COMMENT 'cpu厂商和型号（固件）',
  `province_code` bigint(20) DEFAULT NULL COMMENT '省编码',
  `province_name` varchar(50) DEFAULT NULL COMMENT '省名称',
  `city_code` bigint(20) DEFAULT NULL COMMENT '市编码',
  `city_name` varchar(50) DEFAULT NULL COMMENT '市名称',
  `district_code` bigint(20) DEFAULT NULL COMMENT '区县编码',
  `district_name` varchar(50) DEFAULT NULL COMMENT '区县名称',
  `town_code` bigint(20) DEFAULT NULL COMMENT '乡镇编码',
  `town_name` varchar(50) DEFAULT NULL COMMENT '乡镇名称',
  `region_path` varchar(200) DEFAULT NULL COMMENT '地域path路径',
  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `lat` float DEFAULT NULL COMMENT '精度',
  `lng` float DEFAULT NULL COMMENT '维度',
  `bras_ip` varchar(100) DEFAULT NULL,
  `cr_ip` varchar(100) DEFAULT NULL,
  `nat_ip` varchar(100) DEFAULT NULL COMMENT '网关NAT的IP地址',
  `olt_ip` varchar(100) DEFAULT NULL COMMENT '网关OLT的IP地址',
  `so_ver` varchar(50) DEFAULT NULL COMMENT '网关插件so版本',
  `task_queue_size` int(11) DEFAULT NULL COMMENT '当前网关插件待执行的任务数量',
  `task_size` int(11) DEFAULT NULL COMMENT '当前网关插件所有任务数，探针上报的',
  `cpu_rate` float(5,2) DEFAULT '0.00' COMMENT 'cpu使用率',
  `ram_rate` float(5,2) DEFAULT '0.00' COMMENT '内存利用率',
  `pppoe_username` varchar(200) DEFAULT NULL COMMENT '拨号用户帐号',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户名',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改用户名',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间（Unix时间戳）',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间（Unix时间戳）',
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `probe_alias` (`probe_alias`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_p_probe_upgrade_package` */

DROP TABLE IF EXISTS `t_p_probe_upgrade_package`;

CREATE TABLE `t_p_probe_upgrade_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '升级包id',
  `name` varchar(64) DEFAULT NULL COMMENT '升级包名称',
  `url` varchar(500) DEFAULT NULL COMMENT '升级包文件url',
  `file_size` bigint(20) DEFAULT '0' COMMENT '文件大小（byte）',
  `file_md5` varchar(32) DEFAULT NULL COMMENT '升级包文件md5值',
  `file_name` varchar(128) DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(2000) DEFAULT NULL COMMENT '存放当前路径',
  `protocol` varchar(32) DEFAULT NULL COMMENT '探针获取协议',
  `host` varchar(32) DEFAULT NULL COMMENT '主机ip或者域名',
  `port` varchar(32) DEFAULT NULL COMMENT '端口',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户名',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改用户名',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间（Unix时间戳）',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间（Unix时间戳）',
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='升级包列表';

/*Table structure for table `t_pdc_log` */

DROP TABLE IF EXISTS `t_pdc_log`;

CREATE TABLE `t_pdc_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `log_desc` varchar(4000) NOT NULL DEFAULT '' COMMENT '操作描述',
  `log_modul` varchar(200) DEFAULT NULL COMMENT '操作来源（URL地址）',
  `ips` varchar(32) NOT NULL COMMENT '用户ip',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '结果 0为失败 1为成功',
  `create_user` varchar(64) DEFAULT NULL COMMENT '创建用户',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `delete_flag` tinyint(2) DEFAULT '0' COMMENT '删除标示 1=删除 0=未删除',
  `log_type` varchar(50) DEFAULT NULL,
  `method_name` varchar(200) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9002 DEFAULT CHARSET=utf8 COMMENT='日志表';

/*Table structure for table `t_pdc_region` */

DROP TABLE IF EXISTS `t_pdc_region`;

CREATE TABLE `t_pdc_region` (
  `r_code` bigint(20) NOT NULL DEFAULT '0' COMMENT '行政区划代码',
  `r_name` varchar(50) DEFAULT NULL COMMENT '行政区划名称',
  `r_level` smallint(6) DEFAULT NULL COMMENT '行政区划等级',
  `r_parent_code` bigint(20) DEFAULT NULL COMMENT '上级行政区划',
  `r_tag` varchar(50) DEFAULT NULL COMMENT '地域标记',
  `region_path` varchar(200) DEFAULT NULL COMMENT 'code的path路径',
  `region_name_path` varchar(200) DEFAULT NULL COMMENT 'name的path路径',
  PRIMARY KEY (`r_code`),
  KEY `r_parent_code` (`r_parent_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='行政区划';

/*Table structure for table `t_pdc_resource` */

DROP TABLE IF EXISTS `t_pdc_resource`;

CREATE TABLE `t_pdc_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_id` varchar(32) NOT NULL COMMENT '表ID',
  `res_name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `res_url` varchar(200) DEFAULT '#' COMMENT '资源URL地址',
  `res_order` smallint(6) DEFAULT NULL COMMENT '资源排序',
  `res_pid` varchar(32) DEFAULT NULL COMMENT '资源父ID',
  `res_icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `res_path` varchar(2000) NOT NULL DEFAULT '' COMMENT '资源层级',
  `res_target` smallint(6) DEFAULT '10' COMMENT '页面打开方式，10-当前页面，20-新窗口',
  `status` smallint(6) DEFAULT NULL COMMENT '状态（10-显示，20-隐藏）',
  `res_remark` varchar(32) DEFAULT NULL COMMENT '资源标识',
  `menu_remark` varchar(32) DEFAULT NULL COMMENT '菜单标识（默认情况下等于res_remark）',
  `auth_signs` varchar(500) DEFAULT NULL COMMENT '权限关键字（以逗号隔开）',
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Table structure for table `t_pdc_role` */

DROP TABLE IF EXISTS `t_pdc_role`;

CREATE TABLE `t_pdc_role` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '表ID',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(64) DEFAULT NULL COMMENT '角色描述',
  `role_pid` bigint(32) DEFAULT NULL COMMENT '角色父ID（继承哪个角色）',
  `role_flag` smallint(6) DEFAULT '20' COMMENT '角色标识（1-超级管理员，10-管理，20-普通）',
  `status` smallint(6) DEFAULT '10' COMMENT '角色状态（10-启用，20-停用）',
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Table structure for table `t_pdc_role_resource` */

DROP TABLE IF EXISTS `t_pdc_role_resource`;

CREATE TABLE `t_pdc_role_resource` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '表ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `resource_id` varchar(32) DEFAULT NULL COMMENT '资源ID',
  `auth_signs` varchar(500) DEFAULT NULL COMMENT '权限关键字（以逗号隔开）',
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*Table structure for table `t_pdc_tree` */

DROP TABLE IF EXISTS `t_pdc_tree`;

CREATE TABLE `t_pdc_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tree_name` varchar(32) DEFAULT NULL,
  `tree_desc` varchar(200) DEFAULT NULL,
  `tree_pid` bigint(20) DEFAULT NULL,
  `tree_path` varchar(200) DEFAULT NULL,
  `tree_order` smallint(6) DEFAULT NULL,
  `tree_type` varchar(32) DEFAULT NULL COMMENT '树类型',
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`),
  KEY `tree_type` (`tree_type`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_pdc_user` */

DROP TABLE IF EXISTS `t_pdc_user`;

CREATE TABLE `t_pdc_user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `user_pass` varchar(256) DEFAULT NULL COMMENT '用户密码',
  `user_salt` varchar(32) DEFAULT NULL COMMENT '用户盐',
  `sex` smallint(6) DEFAULT '1' COMMENT '性别（1-男，2-女）',
  `user_email` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(32) DEFAULT NULL COMMENT '用户手机',
  `user_address` varchar(200) DEFAULT NULL COMMENT '用户住址',
  `region_code` bigint(20) DEFAULT NULL COMMENT '用户region',
  `user_brief` varchar(200) DEFAULT NULL COMMENT '用户简介',
  `status` smallint(6) DEFAULT '10' COMMENT '用户状态（10-正常，20-锁定）',
  `role_id` bigint(32) DEFAULT NULL COMMENT '角色ID',
  `org_id` varchar(32) DEFAULT NULL COMMENT '机构ID',
  `reset_pass` smallint(6) DEFAULT '1' COMMENT '用户首次登陆是否需要重置密码 0-否，1-是',
  `is_super` smallint(6) DEFAULT '0' COMMENT '是否是超级用户1-是，0-否',
  `pass_valid_term` bigint(20) DEFAULT '0' COMMENT '密码有效期，单位是天，0-永久有效',
  `pass_invalid_time` bigint(20) DEFAULT NULL COMMENT '密码过期时间',
  `last_pass_time` bigint(20) DEFAULT NULL COMMENT '上次修改密码时间',
  `last_login_time` bigint(20) DEFAULT NULL COMMENT '最后登录时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改用户',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='注册用户';

/*Table structure for table `t_t_task_param` */

DROP TABLE IF EXISTS `t_t_task_param`;

CREATE TABLE `t_t_task_param` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '测试任务id',
  `task_param_name` varchar(200) DEFAULT NULL COMMENT '测试任务名字',
  `task_param_type` smallint(6) DEFAULT '20' COMMENT '参数类型（10-系统自动生成，20-用户自定义）',
  `task_type_name` varchar(200) DEFAULT NULL COMMENT '任务类型名称',
  `task_from` smallint(6) DEFAULT '10' COMMENT '任务来源标识（10-自有平台，20-拨测）',
  `param_json` mediumtext COMMENT '测试任务参数配置json',
  `template_id` varchar(32) DEFAULT NULL COMMENT '计算出参数是md5，供任务下发时判断是否同一个任务，在参数修改后计算templdate_id',
  `template_json` mediumtext COMMENT '该模板对应的json数据',
  `run_status` smallint(6) DEFAULT '10' COMMENT '参数状态（10-下发中，20-启动，30-下发失败，40-暂停，50-过期）',
  `modify_type` varchar(32) DEFAULT '000' COMMENT '修改类型（000-无变化，010-参数不变源变化目的不变）',
  `test_date` smallint(6) DEFAULT '0' COMMENT '测试有效期，具体看字典，0-长期有效',
  `start_date` varchar(32) DEFAULT NULL COMMENT '开始时间，格式：yyyy-MM-dd',
  `end_date` varchar(32) DEFAULT NULL COMMENT '结束时间，格式：yyyy-MM-dd',
  `test_time` smallint(6) DEFAULT '0' COMMENT '0-自定义，10-闲时，20-忙时',
  `start_time` varchar(32) DEFAULT NULL COMMENT '格式：hh:mm',
  `end_time` varchar(32) DEFAULT NULL COMMENT '格式：hh:mm',
  `interval` smallint(6) DEFAULT '600' COMMENT '时间间隔（单位秒）',
  `priority` smallint(6) DEFAULT NULL COMMENT '任务优先级',
  `exec_times` smallint(6) DEFAULT NULL COMMENT '测试次数(与调度时间互斥）',
  `region_for` smallint(6) DEFAULT '20' COMMENT '10-区域随机（针对当前系统中有的探针不包括后注册探针），20-区域全量（包含后注册探针），30-全部探针（包含后注册探针）,40-最优分配',
  `region_num` int(11) DEFAULT NULL COMMENT '区域随机个数',
  `user_region` bigint(20) DEFAULT NULL COMMENT '用户region',
  `region_path` varchar(200) DEFAULT '' COMMENT '用户所在的区域路径',
  `task_num` bigint(20) DEFAULT '0' COMMENT '分配任务数',
  `is_alarm` smallint(6) DEFAULT '0' COMMENT '是否设置告警',
  `alarm_template_id` varchar(32) DEFAULT NULL COMMENT '告警模板ID',
  `topo_json` longtext COMMENT '拓扑结构json',
  `memo` varchar(1000) DEFAULT NULL COMMENT '任务描述',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建用户名',
  `update_user` varchar(32) DEFAULT NULL COMMENT '修改用户名',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间（Unix时间戳）',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间（Unix时间戳）',
  `delete_flag` smallint(6) DEFAULT '0' COMMENT '是否删除（1-是，0-否）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `task_param_name` (`task_param_name`),
  KEY `run_status` (`run_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务参数表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
