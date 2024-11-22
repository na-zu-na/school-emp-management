alter table dept default character set utf8;
show create table dept;
alter table dept change name name varchar(50) character set utf8;

create table dept(
                     id int unsigned primary key auto_increment comment '主键ID',
                     name varchar(10) not null unique comment '学院名称',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '修改时间'
) comment '部门表';
-- 部门表测试数据
insert into dept (id, name, create_time, update_time) values(1,'流浪者',now(),now()),(2,'街头小子',now(),now()),(3,'公司员工',now(),now()),
                                                            (4,'军用科技',now(),now()),(5,'NCPD',now(),now());

create table emp (
                     id int unsigned primary key auto_increment comment 'ID',
                     username varchar(20) not null unique comment '用户名',
                     password varchar(32) default '123456' comment '密码',
                     name varchar(10) not null comment '姓名',
                     gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                     image varchar(300) comment '图像',
                     job tinyint unsigned comment '职位',
                     entrydate date comment '入职时间',
                     dept_id int unsigned comment '部门ID',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '修改时间'
) comment '员工表';

alter table emp default character set utf8;
alter table emp change name name varchar(50) character set utf8;
show create table emp;
alter table emp change username username varchar(50) character set utf8;
alter table emp change password password varchar(50) character set utf8;

INSERT INTO emp
(id, username, password, name, gender, image, job,
 entrydate,dept_id, create_time, update_time) VALUES
                  (1,'vincent','123456','文森特',1,'1.jpg',4,'2000-01-01',2,now(),now()),
                  (2,'silver','123456','银手',1,'2.jpg',2,'2015-01-01',2,now(),now()),
                  (3,'smash','123456','重锤',1,'3.jpg',2,'2008-05-01',2,now(),now()),
                  (4,'jack','123456','杰克',1,'4.jpg',2,'2007-01-01',2,now(),now()),
                  (5,'hacker','123456','骇客',1,'5.jpg',2,'2012-12-05',2,now(),now()),
                  (6,'victor','123456','维克多',2,'6.jpg',3,'2013-09-05',1,now(),now()),
                  (7,'dest','123456','德斯特',2,'7.jpg',1,'2005-08-01',1,now(),now()),
                  (8,'wilson','123456','威尔森',2,'8.jpg',1,'2014-11-09',1,now(),now()),
                  (9,'judy','123456','朱迪',2,'9.jpg',1,'2011-03-11',1,now(),now()),
                  (10,'panam','123456','帕南',2,'10.jpg',1,'2013-09-05',1,now(),now()),
                  (11,'rogue','123456','罗格',1,'11.jpg',5,'2007-02-01',3,now(),now()),
                  (12,'kerry','123456','克里',1,'12.jpg',5,'2008-08-18',3,now(),now()),
                  (13,'river','123456','瑞弗',1,'13.jpg',5,'2012-11-01',3,now(),now()),
                  (14,'alt','123456','奥特',1,'14.jpg',2,'2002-08-01',2,now(),now()),
                  (15,'misty','米丝蒂','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now())