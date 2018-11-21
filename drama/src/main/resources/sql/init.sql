CREATE TABLE IF NOT EXISTS `drama` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `synopsis` text COMMENT '简介',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;