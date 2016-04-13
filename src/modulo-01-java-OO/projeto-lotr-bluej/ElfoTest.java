import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @After
    public void gc() {
        System.gc();
    }
    @Test
    public void inicioFlecha(){
        Elfo e1 = new Elfo("elfo");
        assertEquals(42,e1.getFlecha());
    }
    @Test
    public void inicioVida(){
        Elfo e1 = new Elfo("elfo");
        assertEquals(100,e1.getVida(),0.001);
    }
    @Test
    public void testaFlechaEmAtirarFlecha(){
        Elfo e1 = new Elfo("elfo");
        Dwarf d1 = new Dwarf("jao");
        e1.atirarFlecha(d1);
        assertEquals(41,e1.getFlecha());
    }
    @Test
    public void testaExpEmAtirarFlecha(){
        Elfo e1 = new Elfo("elfo");
        Dwarf d1 = new Dwarf("jao");
        e1.atirarFlecha(d1);
        assertEquals(1,e1.getExperiencia());
    }
    @Test
    public void testaToString()
    {
        Elfo e1 = new Elfo("legolas");
        String esperado = ("legolas possui 42 flechas e 0 níveis de experiência");
        assertEquals(esperado,e1.toString());   
    }
    @Test
    public void testaToStringCom2Flechas()
    {
        Elfo e1 = new Elfo("jao",2);
        String esperado = ("jao possui 2 flechas e 0 níveis de experiência");
        assertEquals(esperado,e1.toString());   
    }
    @Test
    public void conta3Elfos(){
        Elfo e1 = new Elfo("jao");
        Elfo e2 = new Elfo("jorge");
        Elfo e3 = new Elfo("joe");
        assertEquals(3,Elfo.getContadorElfo());
    }
    @Test
    public void conta5Elfos(){
        Elfo e1 = new Elfo("jao");
        Elfo e2 = new Elfo("jorge");
        Elfo e3 = new Elfo("joe");
        Elfo e4 = new Elfo("jair");
        Elfo e5 = new Elfo("joao");
        assertEquals(5,Elfo.getContadorElfo());
    }
    @Test
    public void contaUmElfoNoturnosEUmElfoVerde(){
        Elfo e1 = new ElfoNoturno("jao");
        Elfo e2 = new ElfoVerde("gil");
        assertEquals(2,Elfo.getContadorElfo());
    }
    @Test
    public void conta0Elfos(){
        assertEquals(0,Elfo.getContadorElfo());
    }    
    }