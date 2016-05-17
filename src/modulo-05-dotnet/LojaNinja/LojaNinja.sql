CREATE TABLE [Usuario](
    [idusuario] [int] IDENTITY NOT NULL,
    [nome] [varchar](100) NOT NULL,
    [email] [varchar](250) NOT NULL,
    [senha] [varchar](100) NOT NULL
	constraint PK_idusuario primary key (idusuario)
)
select * from usuario

Insert into Usuario (nome, email, senha)
   values  ('bob', 'bob@gmail.com', '202cb962ac59075b964b07152d234b70');
Insert into Usuario (nome, email, senha)
   values  ('marley', 'marley@gmail.com', '202cb962ac59075b964b07152d234b70');

CREATE TABLE [UsuarioPermissao](
    [IDUsuarioPermissao] [int] IDENTITY NOT NULL,
	[UsuarioPermissao_Usuario] [int] NOT NULL,
	[UsuarioPermissao_Permissao] [int] NOT NULL
	constraint PK_idusuariopermissao primary key (IDUsuarioPermissao),
	constraint FK_idusuario foreign key (UsuarioPermissao_Usuario) references Usuario (idusuario),
	constraint FK_idpermissao foreign key (UsuarioPermissao_Permissao) references Permissao (idpermissao)
)

CREATE TABLE [Permissao](
    [idpermissao] [int] IDENTITY NOT NULL,
    [nome] [varchar](100) NOT NULL
	constraint PK_idparmissao primary key (idpermissao)
)