

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void atirarUmaFlecha(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        assertEquals(95,e1.getVida(),0.001);
    }
    @Test
    public void atirar2Flechas(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(90.25,e1.getVida(),0.001);
    }
    @Test
    public void atirar3Flechas(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(85.7375,e1.getVida(),0.001);
    }
}
