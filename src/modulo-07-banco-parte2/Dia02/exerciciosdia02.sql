-- Exercício 1
DECLARE
vNomeCliente varchar2(50);
vNomeCidade varchar2(50);
vPrimeiraData date;
vUltimaData date;
vValorTotal number(10);
BEGIN
Select  cli.NOME,
        cid.NOME,
        min(ped.DATAPEDIDO),
        max(ped.DATAPEDIDO),
        sum(Ped.Valorpedido)
Into    vNomeCliente,
        vNomeCidade,
        vPrimeiraData,
        vUltimaData,
        vValorTotal
From Cliente cli 
left join Cidade cid on cid.idcidade = cli.idcidade
inner join  Pedido ped on ped.idcliente = cli.idcliente
Where cli.IDCliente = :p_IDCliente
group by cli.nome, cid.nome;

DBMS_OUTPUT.PUT_LINE('Nome: ' || vNomeCliente || ', Cidade: ' || vNomeCIDADE);
DBMS_OUTPUT.PUT_LINE('Primeira compra: ' || vPrimeiraData || ', Ultima compra: ' || vUltimaData);
DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos: ' || vValorTotal);
END;

-- Exercício 2
DECLARE
vNomeCidade CIDADE.NOME%TYPE;
vUfCidade CIDADE.UF%TYPE;
vExiste integer;
BEGIN
vNomeCidade := '&pNOME';
vUfCidade := '&pUF';

select count(1)
into vExiste
From Cidade 
Where upper(NOME) = upper(vNomeCidade) and upper(UF) = upper(vUfCidade) ;

IF (vExiste = 0) THEN
INSERT INTO CIDADE (NOME,UF)
VALUES (vNomeCidade,vUfCidade);
COMMIT;
DBMS_OUTPUT.PUT_LINE('Cidade criada com sucesso!');
ELSE
DBMS_OUTPUT.PUT_LINE('Cidade existente');
END IF;

END;



