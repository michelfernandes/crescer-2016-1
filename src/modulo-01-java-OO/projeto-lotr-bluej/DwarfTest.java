

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
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        assertEquals(Status.MORTO,d1.getStatus());
    }
    @Test
    public void dwarfMorreENaoFicaComVidaNegativa(){
        Dwarf d1 = new Dwarf();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        d1.anaoPerdeVida ();
        assertEquals(0,d1.getVida());
    }
}
