

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
        assertEquals(95,e1.getVida());
    }
    @Test
    public void atirar2Flechas(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(90,e1.getVida());
    }
    @Test
    public void atirar3Flechas(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(85,e1.getVida());
    }
    @Test
    public void atirarFlechasAteMorrer(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        for(int i=0;i<45;i++){
            e1.atirarFlecha(d1);
        }
        assertEquals(0,e1.getVida());
        assertEquals(Status.MORTO,e1.getStatus());
    }
}
