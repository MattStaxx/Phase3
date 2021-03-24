create table if not exists users
	(id int(11) not null auto_increment,
     email varchar(255),
      name varchar(255),
       password varchar(255),
	 primary key (id)
	); 