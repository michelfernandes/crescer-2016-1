

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void inicioVida(){
        Dwarf anao = new Dwarf();
        assertEquals(110,anao.getVida());
    }
    
    @Test
    public void perderVida(){
        Dwarf anao = new Dwarf();
        anao.anaoPerdeVida();
        assertEquals(100,anao.getVida());
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf d1 = new Dwarf();
        assertEquals(Status.VIVO,d1.getStatus());
    }
    
    @Test
    public void dwarfMorre(){
        Dwarf d1 = new Dwarf();
        for(int i=0;i<12;i++){
            d1.anaoPerdeVida ();
        }
        assertEquals(Status.MORTO,d1.getStatus());
    }
    @Test
    public void dwarfMorreENaoFicaComVidaNegativa(){
        Dwarf d1 = new Dwarf();
        for(int i=0;i<14;i++){
            d1.anaoPerdeVida ();
        }
        assertEquals(0,d1.getVida());
    }
    @Test
    public void nasceComDataTerceiEraPadrao(){
        Dwarf d1 = new Dwarf("Pedro Pipoca");
        assertEquals(1,d1.getDia());
        assertEquals(1,d1.getMes());
        assertEquals(1,d1.getAno());
    }
    @Test
    public void nasceComDataTerceiEraAtribuida(){
        DataTerceiraEra data = new DataTerceiraEra(2,12,2013);
        Dwarf d1 = new Dwarf("Pedro Pipoca",data);
        assertEquals(2,d1.getDia());
        assertEquals(12,d1.getMes());
        assertEquals(2013,d1.getAno());
    }
}
