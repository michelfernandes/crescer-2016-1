

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest
{
    @Test
    public void testar4000SeEhBissexto(){
        DataTerceiraEra ano = new DataTerceiraEra(12,12,4000);
        assertEquals(true,ano.ehBissexto());
    }
    @Test
    public void testar2016SeEhBissexto(){
        DataTerceiraEra ano = new DataTerceiraEra(12,12,2016);
        assertEquals(true,ano.ehBissexto());
    }
    @Test
    public void testar2001SeEhBissexto(){
        DataTerceiraEra ano = new DataTerceiraEra(12,12,2001);
        assertEquals(false,ano.ehBissexto());
    }
    @Test
    public void testar3015SeEhBissexto(){
        DataTerceiraEra ano = new DataTerceiraEra(12,12,3015);
        assertEquals(false,ano.ehBissexto());
    }
}
