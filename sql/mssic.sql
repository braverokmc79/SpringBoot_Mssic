
create user `mssic`@`localhost` identified by 'mssic';
create user `mssic`@`%` identified by 'mssic';

create database mssic character set=utf8;

grant all privileges on mssic.* to `mssic`@`localhost` ;
grant all privileges on mssic.* to `mssic`@`%` ;


create table tbl_user(
  id int auto_increment primary key,
  userID varchar(50) not null,
  nickname varchar(50) NOT NULL,
  pw varchar(100) NOT NULL,
  ip varchar(50) not null,
  regdate timestamp default now()
  
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


insert into tbl_user  ( userID ,nickname ,pw ,ip ) VALUES ( 'macaronics','토끼' ,'1111' ,'212.132.22.1'  );
