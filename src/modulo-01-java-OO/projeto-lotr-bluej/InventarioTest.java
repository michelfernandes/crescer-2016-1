

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void adicionarUmItem(){
        Inventario inv = new Inventario();
        Item i1 = new Item(5,"mandiocas");
        inv.adicionarItem(i1);
        assertEquals(5,i1.getQuantidade());
        assertEquals("mandiocas",i1.getDescricao());
    }
    @Test
    public void removerUmItem(){
        Inventario inv = new Inventario();
        Item i1 = new Item(5,"mandiocas");
        inv.adicionarItem(i1);
        inv.removerItem(i1);
        assertFalse(inv.getLista().contains(i1));
    }
}
