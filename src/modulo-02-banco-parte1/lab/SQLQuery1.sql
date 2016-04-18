DROP TABLE Cidade;
DROP TABLE Cliente;

create table Cidade (
	IDCidade	int			NOT NULL,
	Nome		varchar(30)	NOT NULL,
	UF			varchar(2)	NOT NULL
		CONSTRAINT PK_Cidade PRIMARY KEY (IDCidade),
		CONSTRAINT UK_Cidade_Name Unique (Nome)
);
insert into Cidade
	(IDCidade,Nome,UF)
	values
	(2,'São Leopoldo','RS');

ALTER TABLE Cidade ADD 
	CONSTRAINT PK_Cidade PRIMARY KEY (IDCidade)

DELETE FROM Cidade

SELECT * FROM Cidade

INSERT INTO Cidade
	(IDCidade, Nome, UF)
 VALUES 
	(1, 'São Leopoldo', 'RS');

Create table Cliente 
( IDCliente  int IDENTITY  NOT NULL, 
Nome       varchar(30) NOT NULL,
 Endereco   varchar(35), 
 Bairro   varchar(35), 
   IDCidade   int 
   );

INSERT INTO Cliente
	(Nome)
	VALUES
	('Maria');

	DELETE FROM Cliente

Select * From Cliente

Create table Empregado (
 IDEmpregado int NOT NULL,
  Nome        varchar(50) NOT NULL,
   Sexo        char(1) NOT NULL, 
   IDCidade int NOT NULL, 
   constraint PK_Empregado  Primary Key (IDEmpregado), 
   constraint CC_Empregado_Sexo   Check (Sexo in ('F','M')),
    constraint FK_Empregado_Cidade Foreign Key (IDCidade) 
			References Cidade (IDCidade)
	 );

INSERT INTO Empregado
	(IDEmpregado,Nome,Sexo,IDCidade)
	VALUES
	(1,'Maria','F',1);

	valor Decimal(7,2)
		99999,99

exec SP_HELP 'empregado'