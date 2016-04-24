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
    
    @Test
    public void atacarComUmElfoNoturnoDepoisUmElfoVerde(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        exercito.add(e1);
        exercito.add(e2);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(1));
    }
    
    @Test
    public void atacarComUmElfoVerdeDepoisUmElfoNoturno(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoVerde("E1");
        Elfo e2 = new ElfoNoturno("E2");
        exercito.add(e1);
        exercito.add(e2);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(1));
    }
    
    @Test
    public void atacarCom2ElfosNoturnosApenas(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoNoturno("E2");
        exercito.add(e1);
        exercito.add(e2);
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarCom2ElfosVerdesApenas(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoVerde("E1");
        Elfo e2 = new ElfoVerde("E2");
        exercito.add(e1);
        exercito.add(e2);
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarSemAlistarNenhumElfo(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarCom1ElfosNoturnoE2ElfosVerdesIntercalando(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        Elfo e3 = new ElfoVerde("E3");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarCom3ElfosNoturnoE2ElfosVerdesIntercalando(){
        Estrategia estrategia = new OfensivaIntercala();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoNoturno("E2");
        Elfo e3 = new ElfoNoturno("E3");
        Elfo e4 = new ElfoVerde("E4");
        Elfo e5 = new ElfoVerde("E5");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        exercito.add(e4);
        exercito.add(e5);
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
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
