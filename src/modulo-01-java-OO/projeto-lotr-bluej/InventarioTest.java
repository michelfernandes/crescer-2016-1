

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
    }@Test
    public void pegarDescricaoSemItem(){
        Inventario inv = new Inventario();
        assertEquals("",inv.getDescricoesItens());
    }
    @Test
    public void pegarDescricao2Item(){
        Inventario inv = new Inventario();
        Item i1 = new Item(5,"mandioca");
        Item i2 = new Item(5,"flecha");
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        assertEquals("mandioca,flecha",inv.getDescricoesItens());
    }
    @Test
    public void pegarDescricao4Item(){
        Inventario inv = new Inventario();
        Item i1 = new Item(5,"mandioca");
        Item i2 = new Item(5,"flecha");
        Item i3 = new Item(5,"marmita");
        Item i4 = new Item(5,"gelo");
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        inv.adicionarItem(i4);
        assertEquals("mandioca,flecha,marmita,gelo",inv.getDescricoesItens());
    }
    @Test
    public void pegarItemPopular(){
        Inventario inv = new Inventario();
        Item i1 = new Item(2,"mandioca");
        Item i2 = new Item(7,"flecha");
        Item i3 = new Item(5,"faca");
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        assertEquals(i2,inv.getItemPopular());
    }
    @Test
    public void pegarItemPopularComApenasUmItem(){
        Inventario inv = new Inventario();
        Item i1 = new Item(2,"mandioca");
        inv.adicionarItem(i1);
        assertEquals(i1,inv.getItemPopular());
    }
}
