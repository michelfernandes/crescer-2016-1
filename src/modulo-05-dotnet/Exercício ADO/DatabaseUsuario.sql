CREATE TABLE [Usuarios](
    [id] [int] IDENTITY NOT NULL,
    [nome] [varchar](100) NOT NULL,
    [email] [varchar](250) NOT NULL,
    [senha] [varchar](100) NOT NULL
)

select * from Usuarios

INSERT INTO usuarios ( nome, email, senha)
VALUES ('bob','bob@gmail.com','c0ddbb7ecc4accee6faba29b7629cceb')