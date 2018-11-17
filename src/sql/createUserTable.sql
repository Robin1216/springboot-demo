CREATE DATABASE IF NOT EXISTS robin_test;
USE robin_test;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL COMMENT '用户姓名',
  age int(4) DEFAULT 0 COMMENT '年龄',
  create_time datetime NOT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY(id),
  UNIQUE KEY id_UNIQUE (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO t_user(name,age,create_time) VALUES ('test1',10,NOW()),('test2',20,NOW()) ;