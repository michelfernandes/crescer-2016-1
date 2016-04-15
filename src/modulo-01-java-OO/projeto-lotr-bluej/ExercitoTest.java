import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoTest
{
    @After
    public void gc() {
        System.gc();
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void alistaUmElfoNoturno() throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        assertEquals(e1,ex.getExercito().get("jorge"));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void alistaUmElfoNoturnoEUmElfoVerde()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1 ,ex.getExercito().get("jorge"));
        assertEquals(e2 ,ex.getExercito().get("alberto"));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void alistaUmElfoNoturnoEUmElfoNormal()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new Elfo("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1,ex.getExercito().get("jorge"));
        assertFalse(ex.getExercito().containsKey("alberto"));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void naoAlistaNenhumElfo()throws NaoPodeAlistarException{
        Exercito  ex = new Exercito();
        assertTrue(ex.getExercito().isEmpty());
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void buscaNomeDeElfoNoturno()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        assertEquals(e1,ex.buscaNome("jorge"));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void buscaNomeDeElfoNoturnoEElfoVerde()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1 ,ex.buscaNome("jorge"));
        assertEquals(e2 ,ex.buscaNome("alberto"));
    } 
    @Test (expected = NaoPodeAlistarException.class)
    public void ordenaUmElfoMortoEUmVivo()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        for(int i=0;i<90;i++){
            e1.atirarFlecha(new Dwarf("sofrencio"));
        }
        ex.alistar(e1);
        ex.alistar(e2);
        ex.agruparPorStatus();
        assertEquals(e1 ,ex.getExercitoPorStatus().get(Status.MORTO).get(0));
        assertEquals(e2 ,ex.getExercitoPorStatus().get(Status.VIVO).get(0));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void ordenaDoisElfosMortosEDoisVivos()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoNoturno("alberto");
        Elfo e3 = new ElfoVerde ("mario");
        Elfo e4 = new ElfoVerde ("luigi");
        Exercito  ex = new Exercito();
        for(int i=0;i<90;i++){
            e1.atirarFlecha(new Dwarf("sofrencio"));
            e2.atirarFlecha(new Dwarf("sofrencio"));
        }
        ex.alistar(e1);
        ex.alistar(e2);
        ex.alistar(e3);
        ex.alistar(e4);
        ex.agruparPorStatus();
        assertEquals(e1 ,ex.getExercitoPorStatus().get(Status.MORTO).get(0));
        assertEquals(e2 ,ex.getExercitoPorStatus().get(Status.MORTO).get(1));
        assertEquals(e3 ,ex.getExercitoPorStatus().get(Status.VIVO).get(0));
        assertEquals(e4 ,ex.getExercitoPorStatus().get(Status.VIVO).get(1));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void ordenaDoisElfosVivos()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        ex.agruparPorStatus();
        assertEquals(e1 ,ex.getExercitoPorStatus().get(Status.VIVO).get(0));
        assertEquals(e2 ,ex.getExercitoPorStatus().get(Status.VIVO).get(1));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void buscaDoisElfosVivos()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        ex.agruparPorStatus();
        assertEquals(e1,ex.buscar(Status.VIVO).get(0));
        assertEquals(e2,ex.buscar(Status.VIVO).get(1));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void buscaDoisElfosMortos()throws NaoPodeAlistarException{
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoNoturno("alberto");
        Exercito  ex = new Exercito();
        for(int i=0;i<90;i++){
            e1.atirarFlecha(new Dwarf("sofrencio"));
            e2.atirarFlecha(new Dwarf("sofrencio"));
        }
        ex.alistar(e1);
        ex.alistar(e2);
        ex.agruparPorStatus();
        assertEquals(e1,ex.buscar(Status.MORTO).get(0));
        assertEquals(e2,ex.buscar(Status.MORTO).get(1));
    }
    @Test (expected = NaoPodeAlistarException.class)
    public void agrupaPorStatusDuasVezes()throws NaoPodeAlistarException{
        Exercito exercito = new Exercito();
        Elfo e1 = new ElfoNoturno("Ranger",120);
        Elfo e2 = new ElfoNoturno("Nopturne",120);
        Elfo e3 = new ElfoNoturno("Legolas",120);
        Elfo e4 = new ElfoNoturno("Night One",120);
        exercito.alistar(e1);
        exercito.alistar(e2);
        exercito.alistar(e3);
        exercito.alistar(e4);
        for(int i=0; i<90; i++){
            e4.atirarFlecha(new Dwarf("DeadBorn"));
        }
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoPorStatus().get(Status.MORTO).contains(e4));
        assertTrue(exercito.getExercitoPorStatus().get(Status.VIVO).contains(e2));
        for(int i=0; i<90; i++){
            e1.atirarFlecha(new Dwarf("DeadBorn"));
            e2.atirarFlecha(new Dwarf("DeadBorn"));
        }
        exercito.agruparPorStatus();
        assertFalse(exercito.getExercitoPorStatus().get(Status.VIVO).contains(e1));
        assertFalse(exercito.getExercitoPorStatus().get(Status.VIVO).contains(e2));
        assertFalse(exercito.getExercitoPorStatus().get(Status.MORTO).contains(e3));
    }
}
