
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void atirarUmaFlecha(){
        ElfoVerde e1 = new ElfoVerde("Jorge");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        assertEquals(2,e1.getExperiencia());
        assertEquals(41,e1.getFlecha());
    }
    @Test
    public void atirar5Flechas(){
        ElfoVerde e1 = new ElfoVerde("Jorge");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(10,e1.getExperiencia());
        assertEquals(37,e1.getFlecha());
    }
    @Test
    public void atirarUmaFlechaComQuantidadeDefinida(){
        ElfoVerde e1 = new ElfoVerde("Jorge",7);
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        assertEquals(2,e1.getExperiencia());
        assertEquals(6,e1.getFlecha());
    }
}
