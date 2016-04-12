

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
        assertEquals( 85.7375,e1.getVida(),0.001);
    }
    @Test
    public void atirarFlechasAteMorrer(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        for(int i=0;i<90;i++){
            e1.atirarFlecha(d1);
        }
        assertEquals(0,(int)e1.getVida());
        assertEquals(Status.MORTO,e1.getStatus());
    }
    @Test
    public void ganhar3PontosDeExperiencia(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        assertEquals(3,e1.getExperiencia());
    }
    @Test
    public void ganhar9PontosDeExperiencia(){
        ElfoNoturno e1 = new ElfoNoturno("Pelégolas");
        Dwarf d1 = new Dwarf("Sofrencio");
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        e1.atirarFlecha(d1);
        assertEquals(9,e1.getExperiencia());
    }
}
