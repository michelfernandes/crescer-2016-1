--1) Fa�a uma consulta (query) que retorne o nome dos empregados exibindo em ordem de admiss�o.
select	nomeempregado as Nome
from	Empregado 
order by DataAdmissao;

--2) Fa�a uma consulta que retorne o nome dos empregados e o sal�rio anual, 
--onde o cargo seja Atendente ou que o sal�rio anual seja inferior a R$ 18.500,00.
select	nomeempregado as Nome,
		(salario*12) as SalarioAnual
from	empregado
where	cargo = 'Atendente' or (salario*12) < 18500;

--3) Retornar o ID da cidade de Uberl�ndia.
select	IDcidade 
from	cidade
where	nome = 'Uberl�ndia';

--4) Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul.
select	IDCidade as ID,
		Nome
from	Cidade
where	UF = 'RS';