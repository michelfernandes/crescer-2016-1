import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OfensivaNoturnoPorUltimoTest
{
    @Test
    public void atacarComUmNoturnoEUmVerde(){
        Estrategia estrategia = new OfensivaPoupaNoturno();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        exercito.add(e1);
        exercito.add(e2);
        /////////////////////////////////////////////////////
        /////////// EM ANDAMENTO/////////////////////////////
        /////////////////////////////////////////////////////
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(1));
    }
    
    private ArrayList<Dwarf> getExercitoAnao(){
        ArrayList<Dwarf> ex = new ArrayList<Dwarf>();
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        ex.add(d1);
        ex.add(d2);
        ex.add(d3);
        return ex;
    }
}