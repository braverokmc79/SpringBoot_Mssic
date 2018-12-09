
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


create table tbl_board(	
	bno int not null auto_increment,
	title varchar(200) not null,
	content TEXT null,
  	userID varchar(50) ,
  	bnickname varchar(20) not null,
	pw varchar(50)  null,
	ip varchar(50)  null,
	regdate timestamp not null default now(),
	viewcnt int default 0,
	imgcnt int default 0,
	primary key (bno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table tbl_like(	
	lno int not null auto_increment,
	bno int null,
	lip varchar(50)  null,
	lregdate timestamp not null default now(),
	primary key (lno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table tbl_reply(
  rno  int not null auto_increment primary KEY,
  bno int not null,	
  content varchar(1000),
  userID varchar(50) ,
  rnickname varchar(20) not null,
  r_pw varchar(50)  null,
  r_ip varchar(50)  null,
  rply_regdate timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



	

insert into tbl_like (bno,lip ) 
(select bno, lip+lno  from tbl_like );

