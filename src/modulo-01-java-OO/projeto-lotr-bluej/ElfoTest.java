import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
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
}