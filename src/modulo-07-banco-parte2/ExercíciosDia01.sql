--1)
SELECT  A.IDCLIENTE, 
        A.NOME ,
        B.NOME AS CIDADE,
        B.UF
FROM CLIENTE A
  INNER JOIN CIDADE B ON A.IDCIDADE = B.IDCIDADE;

--2)    
SELECT COUNT(1) AS TOTALPEDIDOS
FROM PEDIDO
WHERE DATAPEDIDO BETWEEN TO_DATE('01/05/2016','DD/MM/YYYY') AND TO_DATE('01/06/2016','DD/MM/YYYY');

--3)
SELECT  IDCLIENTE,
        NOME,
        RAZAOSOCIAL
FROM    CLIENTE
WHERE   UPPER(NOME) LIKE '%LTDA%' OR UPPER(RAZAOSOCIAL) LIKE '%LTDA%';

--4)
SELECT MAX(IDPRODUTO) FROM PRODUTO;
CREATE SEQUENCE SQIDPRODUTO START WITH 8001;
COMMIT;

INSERT INTO PRODUTO(IDPRODUTO,NOME,PRECOCUSTO,PRECOVENDA,SITUACAO)
VALUES (SQIDPRODUTO.NEXTVAL,'Galocha Maragato',35.67,77.95,'A');
COMMIT;

--5)
SELECT A.*
FROM PRODUTO A
LEFT JOIN PEDIDOITEM B ON A.IDPRODUTO = B.IDPRODUTO
WHERE B.IDPEDIDOITEM IS NULL;

--6)
SELECT  A.DATAPEDIDO,
        C.NOME,
        D.QUANTIDADE,
        D.PRECOUNITARIO,
        A.VALORPEDIDO
FROM  PEDIDO A
  INNER JOIN PEDIDOITEM D ON A.IDPEDIDO = D.IDPEDIDO
  INNER JOIN PRODUTO C ON D.IDPRODUTO = C.IDPRODUTO
WHERE A.IDCLIENTE = :pIDCLIENTE;

--7)
SELECT A.QUANTIDADE , C.DATAENTREGA
FROM PEDIDOITEM A
INNER JOIN PEDIDO C ON A.IDPEDIDO = C.IDPEDIDO
WHERE (C.DATAENTREGA BETWEEN TO_DATE('01/01/2016','DD/MM/YYYY') AND TO_DATE('01/01/2017','DD/MM/YYYY')) 
AND C.IDPEDIDO = :pIDPEDIDO;

--8)
