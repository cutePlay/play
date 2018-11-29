CREATE TABLE IF NOT EXISTS `drama` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `synopsis` text COMMENT '简介',
  `type` varchar(64) NOT NULL COMMENT '剧本类型',
  `truth` varchar(64) NOT NULL COMMENT '真相',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `drama_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '角色名称',
  `avator` varchar(64) NOT NULL DEFAULT '' COMMENT '角色图像',
  `book` varchar(64) NOT NULL DEFAULT '' COMMENT '角色剧本',
  `drama_id` bigint(20) unsigned NOT NULL DEFAULT 0 COMMENT '剧本id',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `drama_role_unique` (`name`,`drama_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `drama_scene` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '场景名称',
  `sort` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '流程顺序标识',
  `drama_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '剧本id',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `drama_scene_unique` (`sort`,`drama_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `drama_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '信息名称',
  `source` varchar(64) NOT NULL DEFAULT '' COMMENT '信息内容链接',
  `level` varchar(16) NOT NULL DEFAULT '' COMMENT '公开级别',
  `drama_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '剧本id',
  `scene_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '信息公开的场景id',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '信息关联人物id',
  `creator` varchar(64) DEFAULT '' COMMENT '创建人',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(64) DEFAULT '' COMMENT '修改人',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;