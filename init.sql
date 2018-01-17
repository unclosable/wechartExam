CREATE TABLE `B_blog` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(225) DEFAULT NULL COMMENT '标题',
  `file_path` varchar(225) DEFAULT NULL COMMENT '路径',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `B_offer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `alipay` varchar(225) DEFAULT NULL COMMENT '阿里交易号',
  `compment` varchar(225) DEFAULT NULL COMMENT '公司名称',
  `contact` varchar(225) DEFAULT NULL COMMENT '联系方式',
  `message` text COMMENT '消息',
  `month_pay` int(11) DEFAULT NULL COMMENT '月薪',
  `position` varchar(225) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;