CREATE TABLE pagamentos (

    id integer(20) NOT NULL AUTO_INCREMENT,
    valor real(19,2) NOT NULL,
    nome varchar(100) DEFAULT NULL,
    numero varchar(19) DEFAULT NULL,
    expiracao varchar(7) DEFAULT NULL,
    codigo varchar(3) DEFAULT NULL,
    'status' varchar(255) NOT NULL,
    evento_id integer(20) NOT NULL,

    PRIMARY KEY (id)
);