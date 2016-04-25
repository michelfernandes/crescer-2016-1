import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OfensivaNoturnoPorUltimoTest
{
    @After
    public void gc() {
        System.gc();
    }
    @Test
    public void atacarComUmNoturnoEUmVerde(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        exercito.add(e1);
        exercito.add(e2);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(1));
    }
    
    @Test
    public void atacarComDoisNoturnosEDoisVerdes(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        Elfo e3 = new ElfoNoturno("E1");
        Elfo e4 = new ElfoVerde("E2");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        exercito.add(e4);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e4,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(2));
        assertEquals(e3,estrategia.getOrdemDoUltimoAtaque().get(3));
    }
    
    @Test
    public void atacarComElfosNoturnosApenas(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoNoturno("E2");
        Elfo e3 = new ElfoNoturno("E3");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e3,estrategia.getOrdemDoUltimoAtaque().get(2));
    }
    
    @Test
    public void atacarComElfosVerdesApenas(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoVerde("E1");
        Elfo e2 = new ElfoVerde("E2");
        Elfo e3 = new ElfoVerde("E3");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e3,estrategia.getOrdemDoUltimoAtaque().get(2));
    }
    
    @Test
    public void atacarSemElfosAlistados(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        estrategia.atacar(exercito,exercitoAnao);
        assertTrue(estrategia.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarMatandoUmElfoNoturno(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        for (int i = 0; i < 90; i++) e1.atirarFlecha(new Dwarf("D1"));
        Elfo e2 = new ElfoVerde("E2");
        Elfo e3 = new ElfoNoturno("E3");
        Elfo e4 = new ElfoVerde("E4");
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        exercito.add(e4);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e4,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e3,estrategia.getOrdemDoUltimoAtaque().get(2));
    }
    
    @Test
    public void atacarMatando2ElfosNoturnos(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        Elfo e2 = new ElfoVerde("E2");
        Elfo e3 = new ElfoNoturno("E3");
        Elfo e4 = new ElfoVerde("E4");
        Elfo e5 = new ElfoNoturno ("E5");
        for (int i = 0; i < 90; i++) {
            e1.atirarFlecha(new Dwarf("D1"));
            e3.atirarFlecha(new Dwarf("D2"));
        }
        exercito.add(e1);
        exercito.add(e2);
        exercito.add(e3);
        exercito.add(e4);
        exercito.add(e5);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e2,estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(e4,estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(e5,estrategia.getOrdemDoUltimoAtaque().get(2));
    }
    
    @Test
    public void atacarComUmNoturnoApenas(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoNoturno("E1");
        exercito.add(e1);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
    }
    
    @Test
    public void atacarComUmVerdeApenas(){
        Estrategia estrategia = new OfensivaNoturnoPorUltimo();
        ArrayList<Elfo> exercito = new ArrayList<>();
        ArrayList<Dwarf> exercitoAnao = getExercitoAnao();
        Elfo e1 = new ElfoVerde("E1");
        exercito.add(e1);
        estrategia.atacar(exercito,exercitoAnao);
        assertEquals(e1,estrategia.getOrdemDoUltimoAtaque().get(0));
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