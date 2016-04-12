import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
    @Test
    public void hobbitContadorRetornaComUmaArray(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        HobbitContador contador = new HobbitContador();
        assertEquals(180,contador.calcularDiferenca(arrayDePares));
    }
    @Test
    public void hobbitContadorRetornaCom3Arrays(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        HobbitContador contador = new HobbitContador();
        assertEquals(840,contador.calcularDiferenca(arrayDePares));
    }
    @Test
    public void hobbitContadorRetornaCom2Arrays(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 4)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 5)));
        HobbitContador contador = new HobbitContador();
        assertEquals(4,contador.calcularDiferenca(arrayDePares));
    }
    @Test
    public void retornarMaiorMultiploDe3Ate10(){
        HobbitContador contador = new HobbitContador();
        assertEquals(9,contador.obterMaiorMultiploDeTresAte(10));
    }
    @Test
    public void retornarMaiorMultiploDe3Ate1(){
        HobbitContador contador = new HobbitContador();
        assertEquals(0,contador.obterMaiorMultiploDeTresAte(1));
    }
    @Test
    public void retornarMaiorMultiploDe3Ate53(){
        HobbitContador contador = new HobbitContador();
        assertEquals(51,contador.obterMaiorMultiploDeTresAte(53));
    }
    @Test
    public void obtemMultiplosDeTresAte10(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> multiplos = contador.obterMultiplosDeTresAte(10);
        assertEquals(0,multiplos.get(0).intValue());
        assertEquals(3,multiplos.get(1).intValue());
        assertEquals(6,multiplos.get(2).intValue());
        assertEquals(9,multiplos.get(3).intValue());
    }
    @Test
    public void obtemMultiplosDeTresAte1(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> multiplos = contador.obterMultiplosDeTresAte(1);
        assertEquals(0,multiplos.get(0).intValue());
    }
    @Test
    public void obtemMultiplosDeTresAte15(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> multiplos = contador.obterMultiplosDeTresAte(15);
        assertEquals(0,multiplos.get(0).intValue());
        assertEquals(3,multiplos.get(1).intValue());
        assertEquals(6,multiplos.get(2).intValue());
        assertEquals(9,multiplos.get(3).intValue());
        assertEquals(12,multiplos.get(4).intValue());
        assertEquals(15,multiplos.get(5).intValue());
    }
}
