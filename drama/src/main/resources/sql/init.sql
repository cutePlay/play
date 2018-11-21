CREATE TABLE `drama` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `synopsis` text COMMENT '简介',
  `type` varchar(64) NOT NULL COMMENT '剧本类型',
  `truth` varchar(64) NOT NULL COMMENT '真相',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `drama_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '角色名称',
  `avator` varchar(64) NOT NULL DEFAULT '' COMMENT '角色图像',
  `book` varchar(64) NOT NULL DEFAULT '' COMMENT '角色剧本',
  `drama_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '剧本id',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `drama_role_unique` (`name`,`drama_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;