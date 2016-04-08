

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void inicioVida(){
        Dwarf anao = new Dwarf("Ma");
        assertEquals(110,anao.getVida());
    }
    
    @Test
    public void perderVida(){
        Dwarf anao = new Dwarf("s");
        anao.anaoPerdeVida();
        assertEquals(100,anao.getVida());
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf d1 = new Dwarf("s");
        assertEquals(Status.VIVO,d1.getStatus());
    }
    
    @Test
    public void dwarfMorre(){
        Dwarf d1 = new Dwarf("d");
        for(int i=0;i<12;i++){
            d1.anaoPerdeVida ();
        }
        assertEquals(Status.MORTO,d1.getStatus());
    }
    @Test
    public void dwarfMorreENaoFicaComVidaNegativa(){
        Dwarf d1 = new Dwarf("s");
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
    @Test
    public void numeroDaSorteEmAnoBissextoEVida90(){
        DataTerceiraEra data = new DataTerceiraEra(2,12,2015);
        Dwarf d1 = new Dwarf("Pedro Pipoca",data);
        double esperado=(101.0);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        assertEquals(101.0,d1.getNumeroSorte(),0.001);
    }
    @Test
    public void numeroDaSorteSemAnoBissextoESemSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(2,12,2016);
        Dwarf d1 = new Dwarf("Pedro Pipoca",data);
        double esperado=(-33*101.0);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        assertEquals(esperado,d1.getNumeroSorte(),0.001);
    }
    @Test
    public void anaoPerdeVidaComAnoBissextoE90DeVida(){
        DataTerceiraEra data = new DataTerceiraEra(2,12,2016);
        Dwarf d1 = new Dwarf("Pedro Pipoca",data);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        assertEquals(2,d1.getExperiencia());
        assertEquals(90,d1.getVida());
    }
    public void anaoPerdeVidaSemAnoBissextoENomeSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(2,12,2015);
        Dwarf d1 = new Dwarf("Seixas",data);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        assertEquals(0,d1.getExperiencia());
        assertEquals(110,d1.getVida());
    }
    @Test
    public void adicionarItemNoAnao() {
        Dwarf d1 = new Dwarf("Bon jovi");
        Item i1 = new Item(1, "marmita");
        d1.adicionarItem(i1);
        assertEquals(i1, d1.getInventario().getLista().get(0));
    }@Test
    public void anaoEstaComSorte() {
        DataTerceiraEra data = new DataTerceiraEra(2,12,2016);
        Dwarf d1 = new Dwarf("Bon jovi",data);
        Item i1 = new Item(5, "balde");
        d1.adicionarItem(i1);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.tentarSorte();
        assertEquals(1005,d1.getInventario().getLista().get(0).getQuantidade());
    }
    @Test
    public void anaoEstaComMaisSorte() {
        DataTerceiraEra data = new DataTerceiraEra(2,12,2016);
        Dwarf d1 = new Dwarf("Bon jovi",data);
        Item i1 = new Item(5, "balde");
        Item i2 = new Item(7, "bergamota");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.anaoPerdeVida();
        d1.tentarSorte();
        assertEquals(1005,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(1007,d1.getInventario().getLista().get(1).getQuantidade());
    }
    @Test
    public void anaoNaoEstaComSorte() {
        DataTerceiraEra data = new DataTerceiraEra(2,12,2015);
        Dwarf d1 = new Dwarf("Bon jovi",data);
        Item i1 = new Item(5, "balde");
        d1.adicionarItem(i1);
        d1.anaoPerdeVida();
        d1.tentarSorte();
        assertEquals(5,d1.getInventario().getLista().get(0).getQuantidade());
    }
}
