
--1) Faça uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado)
select	LEFT (nome,CHARINDEX (' ',nome)) as PrimeiroNome
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

--6) Faça uma consulta que retorne o nome do associado e a data de quando cada completará (ou completou) 50 anos,
-- liste também o dia da semana.
select	Nome,
		DATEADD (YEAR, 50, DataNascimento) as Data,
		DATENAME (WEEKDAY,DATEADD (YEAR, 50, DataNascimento)) AS DiaDaSemana
from	associado

--7) Liste a quantidade de cidades agrupando por UF –quantas cidades cada estado possuí ?
select UF,
	 count(1) as Estados
from Cidade
group by UF

--8)Liste as cidades que possuem o mesmo nome e UF –cidades duplicadas.
select	Nome,
		UF, 
		count(1)
from	Cidade
group by Nome, UF
having	count(1) > 1

--9)Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado (maior + 1).
select	top 1 IdAssociado +1 as ProximoID, 
		IdAssociado as UltimoID,
		Nome
from associado
order by IDassociado desc

--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF’s distintos,
-- considere somente o menor código ID das cidades duplicadas.
truncate table cidadeaux
Insert into cidadeaux (IDCidade,Nome,UF)
select	distinct min(IDCidade),
		Nome, 
		UF 
from Cidade 
group by Nome,UF

--11) Altere todas cidades duplicadas (nome e uf iguais), acrescente no ínicio do nome um asterisco (*).
begin transaction
go
Update cidade
	set nome = REPLACE(Nome, Nome, '*'+Nome)
where Nome in (
	Select Nome
	From Cidade
	group by nome, uf
	having count(1) > 1
);
commit

--12) Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, informando: Masculino ou Feminino.
select	Nome,
		Case 
		when sexo = 'F' then 'Feminino'
		when sexo = 'M' then 'Masculino'
		End Gênero
from associado

--13) Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda.
select	NomeEmpregado,
		Salario,
		case
		when salario between 0 and 1164 then '0%'
		when salario between 1165 and 2326 then '15%'
		when salario > 2326 then '27%'
		end ImpostoDeRenda
from	empregado

--14) Elimine as cidades duplicadas (mantendo 1 registro para cada –com menor IDCidade).
/*begin transaction
go
////////////////////////////
////EM ANDAMENTO///////////
///////////////////////
delete 
from cidade
where Nome in (
	Select Nome
	From Cidade
	group by nome, uf
	having count(1) > 1
	) and 
	nome not in ()

rollback*/

--15) Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.
begin transaction
go
alter table cidade
add constraint UK_nomeUF unique(nome,uf)
commit