create database study;
use study;
drop table class,units,words;
create table class(id int auto_increment primary key,class_name varchar(20));
create table units(id int auto_increment primary key, cid int,name varchar(20),
key conf_unit_class_idx(cid), constraint conf_unit_class_idx foreign key(cid) references class(id));
drop table words;
create table words(id bigint auto_increment primary key, uid int, 
KEY conf_cid_words_class_idx(uid),
CONSTRAINT conf_cid_words_class FOREIGN KEY (uid) REFERENCES units (id),
word varchar(20),
UNIQUE INDEX `uni_ind_name` (`word` ASC),
bushou varchar(20),
bihua int,
order_pic MEDIUMBLOB,
read_mp3 MEDIUMBLOB);
insert into class(id,class_name) values(2,'一年级下');
insert into units(id,cid,name) values(14,2,'要下雨了');
insert into words(id,uid,word) values(1,14,'直');
insert into words(id,uid,word) values(2,14,'边');
insert into words(id,uid,word) values(3,14,'吗');
insert into words(id,uid,word) values(4,14,'加');
insert into words(id,uid,word) values(5,14,'呀');
insert into words(id,uid,word) values(6,14,'呢');
insert into words(id,uid,word) values(7,14,'吧');
select* from units;
select *from words;
delete from words where uid=14;
create table wordstone();
insert into words(uid,word,bushou,bihua,order_pic,read_mp3) values(?,?,?,?,?,?);