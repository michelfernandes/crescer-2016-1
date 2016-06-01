--1)Liste os clientes e suas respectivas cidades.
SELECT  A.IDCLIENTE, 
        A.NOME ,
        B.NOME AS CIDADE,
        B.UF
FROM CLIENTE A
  INNER JOIN CIDADE B ON A.IDCIDADE = B.IDCIDADE;

--2)Liste o total de pedidos realizados no mês de maio de 2016.    
SELECT COUNT(1) AS TOTALPEDIDOS
FROM PEDIDO
WHERE DATAPEDIDO BETWEEN TO_DATE('01/05/2016','DD/MM/YYYY') AND TO_DATE('01/06/2016','DD/MM/YYYY');

--3)Liste todos os clientes que tenham o LTDA no nome ou razao social.
SELECT  IDCLIENTE,
        NOME,
        RAZAOSOCIAL
FROM    CLIENTE
WHERE   UPPER(NOME) LIKE '%LTDA%' OR UPPER(RAZAOSOCIAL) LIKE '%LTDA%';

--4)Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
--Nome: Galocha Maragato
--Preço de custo: 35.67
--Preço de venda: 77.95
--Situação: A
SELECT MAX(IDPRODUTO) FROM PRODUTO;
CREATE SEQUENCE SQIDPRODUTO START WITH 8001;
COMMIT;

INSERT INTO PRODUTO(IDPRODUTO,NOME,PRECOCUSTO,PRECOVENDA,SITUACAO)
VALUES (SQIDPRODUTO.NEXTVAL,'Galocha Maragato',35.67,77.95,'A');
COMMIT;

--5)Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados,
--pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
SELECT *
FROM PRODUTO 
WHERE NOT EXISTS(SELECT 1
                  FROM PEDIDOITEM
                  WHERE PEDIDOITEM.IDPRODUTO = PRODUTO.IDPRODUTO);

--6)Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta será informado
--o IDCliente como parâmetro. Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total.
SELECT  A.DATAPEDIDO,
        C.NOME,
        D.QUANTIDADE,
        D.PRECOUNITARIO,
        A.VALORPEDIDO
FROM  PEDIDO A
  INNER JOIN PEDIDOITEM D ON A.IDPEDIDO = D.IDPEDIDO
  INNER JOIN PRODUTO C ON D.IDPRODUTO = C.IDPRODUTO
WHERE A.IDCLIENTE = :pIDCLIENTE;

--7)Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem
--com este IDProduto foram vendidos no último ano (desde janeiro/2016).
SELECT A.QUANTIDADE , C.DATAENTREGA
FROM PEDIDOITEM A
INNER JOIN PEDIDO C ON A.IDPEDIDO = C.IDPEDIDO
WHERE (C.DATAENTREGA BETWEEN TO_DATE('01/01/2016','DD/MM/YYYY') AND TO_DATE('01/01/2017','DD/MM/YYYY')) 
AND C.IDPEDIDO = :pIDPEDIDO;

--8)Utilizando de funções de agrupamento (aggregation function), faça uma consulta que liste agrupando por ano e mês
--a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos,
--o menor valor de um pedido, o maior valor de um pedido e valor médio de um pedido.
SELECT TO_CHAR( ped.DATAPEDIDO, 'mm/yyyy') as ANO_MES,
      COUNT(DISTINCT item.IDPRODUTO)as PRODUTOS_DISTINTOS,
      SUM(ped.VALORPEDIDO) as VALOR_PEDIDOS,
      MIN(ped.VALORPEDIDO) as MENOR_PEDIDO,
      MAX(ped.VALORPEDIDO) as MAIOR_PEDIDO,
      round(AVG(ped.VALORPEDIDO),2) as MEDIA_PEDIDOS,
      COUNT(DISTINCT ped.IDPEDIDO) as TOTAL_PEDIDOS
FROM PEDIDO ped
  INNER JOIN PEDIDOITEM item ON item.IDPEDIDO = ped.IDPEDIDO
  GROUP BY TO_CHAR(ped.DATAPEDIDO,'mm/yyyy');
