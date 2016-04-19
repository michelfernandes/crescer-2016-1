
Create table Empregado ( 
IDEmpregado int NOT NULL, 
Nome        varchar(50) NOT NULL, 
Sexo        char(1) NOT NULL, 
constraint PK_Empregado   Primary Key (IDEmpregado), 
constraint CC_Empregado_Sexo Check (Sexo in ('F','M')) 
);

insert into associado
	(IDAssociado,Nome,DataNascimento,Sexo)
	values
	(3,'Maria Joaquina',convert(datetime,'10/03/1983',103),'F');

	select * from cidade

Select * into CidadeAux From Cidade;

Truncate table CidadeAux

Insert into cidadeaux select * From cidade;

create table Produto(
	IDProduto		int IDENTITY,
	Nome			varchar(20)		not null,
	NomeDescritivo	varchar (50)	not null,
	DataCriacao		datetime		not null,
	LocalEstoque	varchar(15)		not null,
	Quantidade		int				not null,
	Preco			decimal(7,2)	not null,
);

alter table Produto add constraint PK_Produto   Primary Key (IDProduto);

Insert into Produto 
	(Nome, NomeDescritivo,DataCriacao,LocalEstoque,Quantidade,Preco)
	Values 
	('Liquidificador',
	 'Liquidificador Eletrolux',
	 convert(datetime,'12/10/2013',103),
	 'pratileira B2',
	 100,
	 99.99
);

Insert into Produto 
	(Nome, NomeDescritivo,DataCriacao,LocalEstoque,Quantidade,Preco)
	Values 
	('Celular',
	 'Celular Motorola Turbo',
	 convert(datetime,'18/05/2009',103),
	 'pratileira B9',
	 150,
	 299.99
);
