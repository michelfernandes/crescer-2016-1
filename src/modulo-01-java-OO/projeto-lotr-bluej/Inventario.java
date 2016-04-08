import java.util.*;
public class Inventario
{
    // instance variables - replace the example below with your own
    private  ArrayList<Item> lista = new ArrayList<>();

    public void adicionarItem(Item item){
        lista.add(item);
    }
    
    public void removerItem(Item item){
        lista.remove(item);
    }
    
    public ArrayList getLista(){
        return lista;
    }
}
