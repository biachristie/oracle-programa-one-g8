create table livros (
    id bigint not null auto_increment,
    gutendex_id bigint unique,
    titulo varchar(255) not null,
    downloads int,

    primary key(id)
);

create table autores (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    ano_nascimento int,
    ano_falecimento int,

    primary key(id)
);

create table livro_autor (
    livro_id bigint not null
    autor_id bigint not null

    primary key(livro_id, autor_id),
    foreign key(livro_id) references livros(id),
    foreign key(autor_id) references autores(id)
);

create table livro_idioma (
    livro_id bigint not null,
    idioma varchar(255),

    primary key(livro_id, idioma),
    foreign key(livro_id) references livros(id)
);