
CREATE OR REPLACE PROCEDURE IMPRIME_NUMEROS_APOSTA(pIDConcurso in integer) AS

  CURSOR c_aposta(pConcurso in integer) IS
    SELECT IDAposta
    FROM APOSTA
    WHERE IDCONCURSO = pConcurso;
    
  CURSOR c_numeros(pIDAposta in integer) is
    SELECT NUMERO
    FROM NUMERO_APOSTA
    WHERE IDAPOSTA = pIDAposta;
    
    type num_table_type is table of number
       index by binary_integer;
    vNumerosVencedores num_table_type;
    
    vAcertos integer;
    vQuadra integer := 0;
    vQuina integer := 0;
    vSena integer := 0;
BEGIN 
  
  SELECT PRIMEIRA_DEZENA, SEGUNDA_DEZENA, TERCEIRA_DEZENA, QUARTA_DEZENA, QUINTA_DEZENA, SEXTA_DEZENA
  INTO vNumerosVencedores(1),vNumerosVencedores(2),vNumerosVencedores(3),vNumerosVencedores(4),vNumerosVencedores(5),vNumerosVencedores(6)
  FROM CONCURSO
  WHERE IDCONCURSO = pIDConcurso;
  
  FOR i IN c_aposta(pIDConcurso) LOOP
    vAcertos := 0;
    FOR j in c_numeros(i.IDAposta) LOOP
    
      IF (j.numero = vNumerosVencedores(1) or j.numero = vNumerosVencedores(2) or j.numero = vNumerosVencedores(3) or 
      j.numero = vNumerosVencedores(4) or j.numero = vNumerosVencedores(5) or j.numero = vNumerosVencedores(6)) THEN
      vAcertos := vAcertos + 1;
      END IF;
      
    END LOOP;
      IF (vAcertos = 4) THEN vQuadra := vQuadra + 1; 
      ELSIF (vAcertos = 5) THEN vQuina := vQuina + 1;
      ELSIF (vAcertos = 6) THEN vSena := vSena + 1; END IF;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('Vencedores da Sena: '|| vSena);
  DBMS_OUTPUT.PUT_LINE('Vencedores da Quina: '|| vQuina);
  DBMS_OUTPUT.PUT_LINE('Vencedores da Quadra: '|| vQuadra);  
END;

BEGIN
IMPRIME_NUMEROS_APOSTA(1816);
END;


