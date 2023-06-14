create table topicos(
    id integer not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_de_creacion varchar(100) not null,
    estatus_del_topico varchar(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    primary key(id)
);