create table eventos(

  id integer not null auto_increment,
  titulo varchar(255) not null,
  data_inicial timestamp not null,
  data_final timestamp not null,
  idade_min integer,
  pagamento varchar(255),
  descricao varchar(255),
  `status` varchar(255),
  logradouro varchar(255) not null,
  numero varchar(255) not null,
  descricao varchar(255) not null,
  bairro varchar(255) not null,
  cidade varchar(255) not null,
  estado varchar(255) not null,
  cep varchar(9) not null,
  categoria varchar(255),
  id_user integer,

  primary key (id)
);