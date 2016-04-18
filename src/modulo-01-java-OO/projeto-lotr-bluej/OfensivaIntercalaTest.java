import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OfensivaIntercalaTest
{
    @After
    public void gc() {
        System.gc();
    }
    @Test
    public void atacarCom2ElfosNoturnosE2ElfosVerdesIntercalando(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoNoturno("E2");
        Elfo e3 = new ElfoVerde("E3");
        Elfo e4 = new ElfoVerde("E4");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        exercito.add(e4);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e3,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(2));
        assertEquals(e4,estrategia.getOrdemDoUltimoAtaque().get(3));
    }
    
    private ArrayList<Dwarf> getExercitoAnao(){
        ArrayList<Dwarf> ex = new ArrayList<Dwarf>();
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        ex.add(d1);
        ex.add(d2);
        return ex;
    }
}
