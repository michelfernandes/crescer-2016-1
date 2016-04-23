select * from departamento

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
		count(1) as Total_Cidades
from cidade a
where not exists (	select 1
					from associado b
					where a.idcidade = b.idcidade
				 )
group by UF

--4)
select	a.Nome,
		b.UF,
		case 
		when b.uf in ('RS','SC','PR') THEN '***' 
		end RegiaoSul
from associado a
	left join cidade b on a.idcidade=b.idcidade;

--5)
select	a.NomeEmpregado as NomeEmpregado,
		b.NomeEmpregado as NomeGerente,
		c.nomedepartamento as DepartamentoEmpregado,
		d.nomedepartamento as DepartamentoGerente
from empregado a
	left join empregado b on a.idgerente = b.idempregado
	left join departamento c on a.iddepartamento = c.iddepartamento
	left join departamento d on b.iddepartamento = d.iddepartamento

--6)
begin transaction
go
Select * Into EmpregadoAux From Empregado
update EmpregadoAux 
	set salario += salario * 0.145
where idempregado in (
	select a.idempregado
	from empregadoaux a
	join departamento b on a.iddepartamento = b.iddepartamento
	where b.localizacao in ('sao paulo') 
)
commit
