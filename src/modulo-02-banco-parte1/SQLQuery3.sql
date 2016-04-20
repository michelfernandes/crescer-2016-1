
--1) Faça uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado)
select	LEFT (nome,CHARINDEX (' ',nome))
FROM	Associado;

--2) Faça uma consulta que retorne o nome dos associados e a idade de cada um (em anos, exibir um número inteiro).
select	Nome,
		DATEDIFF(Year,DataNascimento,getdate()) as Idade
from Associado;

--3) Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir também o total de 
--meses de trabalho até a data de 31/12/2000.
select	NomeEmpregado,
		DATEDIFF(month,DataAdmissao,convert(date,'31/12/2000',103)) as MesesDeTrabalho
from	Empregado
where	DataAdmissao between convert(date,'01/05/1980',103) and convert(date,'20/01/1982',103)

--4) Qual o cargo (tabela empregado) possuir mais empregados?
select top 1 Cargo,
	 count(1) as Empregados
from Empregado
group by cargo
order by count(1) desc