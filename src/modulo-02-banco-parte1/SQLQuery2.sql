--1) Faça uma consulta (query) que retorne o nome dos empregados exibindo em ordem de admissão.
select	nomeempregado as Nome
from	Empregado 
order by DataAdmissao;

--2) Faça uma consulta que retorne o nome dos empregados e o salário anual, 
--onde o cargo seja Atendente ou que o salário anual seja inferior a R$ 18.500,00.
select	nomeempregado as Nome,
		(salario*12) as SalarioAnual
from	empregado
where	cargo = 'Atendente' or (salario*12) < 18500;

--3) Retornar o ID da cidade de Uberlândia.
select	IDcidade 
from	cidade
where	nome = 'Uberlândia';

--4) Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul.
select	IDCidade as ID,
		Nome
from	Cidade
where	UF = 'RS';