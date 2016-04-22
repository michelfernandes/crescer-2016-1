select * from associado

--1)
select	a.NomeEmpregado,
		b.NomeDepartamento
from	Empregado a
	inner join Departamento b on a.IDDepartamento = b.IDDepartamento;

--2)
select	a.Nome,
		b.Nome
from	associado a
	left join cidade b on a.IDCidade = b.IDCidade;

--3)
select	a.UF,
		count(1) as Total_Cidades,
		b.Nome,
from cidade a
inner join associado b on a.idcidade = b.idcidade
group by UF,b.nome
	--andamento
