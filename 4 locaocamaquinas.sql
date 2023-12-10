create database locacaomaquinas;

drop database locacaomaquinas;

use locacaomaquinas;

Create table usuariopessoafisica (
codigo int primary key auto_increment,
nome varchar(50),
email varchar(50) unique,
endereco varchar(200),
historico varchar (200),
cpf varchar(16),
idade int
);

create table usuariopessoajuridica(
codigo int primary key auto_increment,
nome varchar(50),
email varchar(50) unique,
endereco varchar(200),
historico varchar (200),
cnpj varchar(50),
responsavel varchar (50)
);

create table maquina(
 codigo int primary key auto_increment, 
 nome varchar(50), 
 categoria varchar(50), 
 avaliacoes varchar(50), 
 imagens varchar(50), 
 valorLocacao double
 );

CREATE TABLE locacao (
    numeroTransacao INT PRIMARY KEY AUTO_INCREMENT,
    maquina VARCHAR(50),
    usuariopessoafisica VARCHAR(50),
    usuariopessoajuridica VARCHAR(50),
    dataretirada date,
    datadevolucao date,
    valor DOUBLE
);

CREATE TABLE  feedback (
    numeroAvaliacao INT PRIMARY KEY AUTO_INCREMENT,
    maquina VARCHAR(50),
    usuariopessoafisica VARCHAR(50),
    usuariopessoajuridica VARCHAR(50),
    comentario varchar(150)
);
cREATE TABLE  suporte (
    numeroChamado INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(50),
    usuariopessoafisica VARCHAR(50),
    usuariopessoajuridica VARCHAR(50),
    historico varchar(150)
);


select*from usuarioPessoaFisica;
select*from usuarioPessoaJuridica;
select*from maquina;
select*from locacao;
select*from feedback;
select*from suporte;