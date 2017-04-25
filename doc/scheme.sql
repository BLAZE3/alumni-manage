DROP TABLE IF EXISTS `TB_LOG`;
CREATE TABLE `TB_LOG` (
    `id` varchar(64) NOT NULL  COMMENT 'id',
    `actorid` varchar(64) NOT NULL DEFAULT '' COMMENT '操作者id',
    `actinfo` varchar(256) NOT NULL COMMENT '操作内容',
    `inserttime` DATETIME NOT NULL COMMENT '插入时间',
    PRIMARY KEY (`id`),
    KEY `idx_log_actorid` (`actorid`,`inserttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志'; /*50W*/
/**
dml:
select id, actorid, actinfo, inserttime
    from TB_LOG
    where actorid = #{actorid} and inserttime>#{time} and inserttime<#{time}
*/

DROP TABLE IF EXISTS `TB_NEWS`;
CREATE TABLE `TB_NEWS` (
    `id` varchar(64) NOT NULL  COMMENT 'id',
    `title` varchar(128) NOT NULL DEFAULT '' COMMENT '题目',
    `content` text NOT NULL COMMENT '内容',
    `author` varchar(32) NOT NULL COMMENT '作者',
    `publisher` varchar(32) NOT NULL COMMENT '发布者',
    `position` varchar(32) NOT NULL COMMENT '新闻位置',
    `starttime` DATETIME NOT NULL COMMENT '生效时间',
    `endtime` DATETIME NOT NULL COMMENT '结束时间',
    `inserttime` DATETIME NOT NULL COMMENT '插入时间',
    `isvalid` char(2) NOT NULL COMMENT '是否存在，Y在N不在',
    PRIMARY KEY (`id`),
    KEY `idx_news_actorid` (`isvalid`,`starttime`,`endtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志'; /*1W*/
/**
dml:
select id, title, content, author, publisher, position, starttime, endtime, inserttime
from TB_NEWS
where isvalid = #{isvalid} and #{time}>endtime and starttime<#{time}
*/