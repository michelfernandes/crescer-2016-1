

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
}
