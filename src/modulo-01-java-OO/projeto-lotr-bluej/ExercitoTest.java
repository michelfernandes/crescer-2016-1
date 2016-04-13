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
    @Test
    public void alistaUmElfoNoturno(){
        Elfo e1 = new ElfoNoturno("jorge");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        assertEquals(e1,ex.getExercito().get("jorge"));
    }
    @Test
    public void alistaUmElfoNoturnoEUmElfoVerde(){
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1 ,ex.getExercito().get("jorge"));
        assertEquals(e2 ,ex.getExercito().get("alberto"));
    }
    @Test
    public void alistaUmElfoNoturnoEUmElfoNormal(){
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new Elfo("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1,ex.getExercito().get("jorge"));
        assertFalse(ex.getExercito().containsKey("alberto"));
    }
    @Test
    public void naoAlistaNenhumElfo(){
        Exercito  ex = new Exercito();
        assertTrue(ex.getExercito().isEmpty());
    }
    @Test
    public void buscaNomeDeElfoNoturno(){
        Elfo e1 = new ElfoNoturno("jorge");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        assertEquals(e1,ex.buscaNome("jorge"));
    }
    @Test
    public void buscaNomeDeElfoNoturnoEElfoVerde(){
        Elfo e1 = new ElfoNoturno("jorge");
        Elfo e2 = new ElfoVerde("alberto");
        Exercito  ex = new Exercito();
        ex.alistar(e1);
        ex.alistar(e2);
        assertEquals(e1 ,ex.buscaNome("jorge"));
        assertEquals(e2 ,ex.buscaNome("alberto"));
    }
}
