drop table if exists users159;
create table if not exists users159
	(id int not null auto_increment,
     email varchar(255),
      name varchar(255),
       password varchar(255),
       unique(name),
	 primary key (id)
	); 