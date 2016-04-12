

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void sorteIrlandesaCom3Unidades(){
        Item i1 = new Item(3,"chapeis");
        i1.irishSorte();
        assertEquals(6003,i1.getQuantidade());
    }
    @Test
    public void sorteIrlandesaComUmaUnidade(){
        Item i1 = new Item(1,"chapeu");
        i1.irishSorte();
        assertEquals(1001,i1.getQuantidade());
    }
    @Test
    public void sorteIrlandesaCom7unidades(){
        Item i1 = new Item(7,"chapeis");
        i1.irishSorte();
        assertEquals(28007,i1.getQuantidade());
    }
    @Test
    public void umItemIgualAoOutro(){
        Item i1 = new Item(1,"melao");
        Item i2 = new Item(1,"melao");
        assertEquals(i1,i2);
    }
    @Test
    public void umItemDiferenteDoOutro(){
        Item i1 = new Item(1,"melao");
        Item i2 = new Item(1,"pato");
        assertFalse(i1.equals(i2));
    }
}
