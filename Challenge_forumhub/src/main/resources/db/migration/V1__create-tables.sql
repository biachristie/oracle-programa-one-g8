create table categorias(
    id bigint not null auto_increment,
    nome varchar(100) not null unique,

    primary key (id)
);

create table perfis(
    id bigint not null auto_increment,
    nome varchar(100) not null unique,

    primary key (id)
);

create table usuarios(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null unique,
    login varchar(255) not null,
    senha varchar(255) not null,

    primary key (id)
);

create table cursos(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    categoria_id bigint not null,

    primary key (id),
    foreign key (categoria_id) references categorias(id)
);

create table topicos(
    id bigint not null auto_increment,
    titulo varchar(255) not null unique,
    mensagem text not null,
    data_criacao datetime not null,
    data_atualizacao datetime null,
    status varchar(50) not null,
    usuario_id bigint not null,
    curso_id bigint not null,

    primary key (id),
    foreign key (usuario_id) references usuarios(id),
    foreign key (curso_id) references cursos(id)
);

create table usuarios_perfis(
    usuario_id bigint not null,
    perfil_id bigint not null,

    primary key (usuario_id, perfil_id),
    foreign key (usuario_id) references usuarios(id),
    foreign key (perfil_id) references perfis(id)
);

create table respostas(
    id bigint not null auto_increment,
    mensagem text not null,
    data_criacao datetime not null,
    solucao boolean default false,
    topico_id bigint not null,
    usuario_id bigint not null,

    primary key (id),
    foreign key (topico_id) references topicos(id),
    foreign key (usuario_id) references usuarios(id)
);