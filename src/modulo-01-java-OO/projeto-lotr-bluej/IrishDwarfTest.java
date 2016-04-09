

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IrishDwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IrishDwarfTest
{
    @Test
    public void tentarSorteComUmItem(){
        DataTerceiraEra data = new DataTerceiraEra(2,2,2016);
        IrishDwarf d1 = new IrishDwarf("Leprechaum", data);
        Item i1 = new Item(2,"alicate de corte");
        d1.adicionarItem(i1);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.tentarSorte();
        assertEquals(3002,d1.getInventario().getLista().get(0).getQuantidade());
    }
    @Test
    public void tentarSorteCom3Itens(){
        DataTerceiraEra data = new DataTerceiraEra(2,2,2016);
        IrishDwarf d1 = new IrishDwarf("Leprechaum", data);
        Item i1 = new Item(4,"alicate de corte");
        Item i2 = new Item(3,"martelinho");
        Item i3 = new Item(1,"autógrafo de Gandalf");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.adicionarItem(i3);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.tentarSorte();
        assertEquals(10004,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(6003,d1.getInventario().getLista().get(1).getQuantidade());
        assertEquals(1001,d1.getInventario().getLista().get(2).getQuantidade());
    }
}
