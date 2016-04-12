
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    @Test
    public void adicionarEspadaValiriana(){
        ElfoVerde e1 = new ElfoVerde("Jorge",7);
        Item i1 = new Item(1,"Espada de aço valiriano");
        e1.adicionarItem(i1);
        assertEquals(i1,e1.getInventario().getLista().get(0));
    }
    @Test
    public void adicionarArcoDeVidro(){
        ElfoVerde e1 = new ElfoVerde("Jorge",7);
        Item i1 = new Item(1,"Arco e Flecha de Vidro");
        e1.adicionarItem(i1);
        assertEquals(i1,e1.getInventario().getLista().get(0));
    }
    @Test
    public void adicionarOutrosItens(){
        ElfoVerde e1 = new ElfoVerde("Jorge",7);
        Item i1 = new Item(1,"Arco e Flecha de Vidro");
        Item i2 = new Item(1,"Alfajor");
        Item i3 = new Item(1,"Espada de aço valiriano");
        e1.adicionarItem(i1);
        e1.adicionarItem(i2);
        e1.adicionarItem(i3);
        assertEquals(i1,e1.getInventario().getLista().get(0));
        assertEquals(i3,e1.getInventario().getLista().get(1));
    }
    
}
