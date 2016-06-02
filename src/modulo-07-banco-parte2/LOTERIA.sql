
CREATE OR REPLACE FUNCTION Verifica (pNumero in Number,pAposta in Number) RETURN integer AS
 vExiste integer;
 BEGIN
Select count(1)
into vExiste
from Arquivo_Aposta_A 
where (pNumero = N1 OR
      pNumero = N2 OR
      pNumero = N3 OR
      pNumero = N4 OR
      pNumero = N5 OR
      pNumero = N6 OR
      pNumero = N7 OR
      pNumero = N8 OR
      pNumero = N9 OR
      pNumero = N10 OR
      pNumero = N11 OR
      pNumero = N12 OR
      pNumero = N13 OR
      pNumero = N14 OR
      pNumero = N15) AND
      pAposta = Aposta;
RETURN vExiste;
END;

DECLARE
vGanhadores  integer;
BEGIN

SELECT COUNT(1)
INTO vGanhadores
FROM Arquivo_Aposta_A
WHERE Verifica(5,APOSTA)>0 AND
      Verifica(10,APOSTA)>0 AND
      Verifica(12,APOSTA)>0 AND
      Verifica(22,APOSTA)>0 AND
      Verifica(28,APOSTA)>0 AND
      Verifica(48,APOSTA)>0 ;
      
DBMS_OUTPUT.PUT_LINE('Ganhadores da sena: ' || vGanhadores);
END;

