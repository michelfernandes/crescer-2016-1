import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HobbitContadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
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
}
