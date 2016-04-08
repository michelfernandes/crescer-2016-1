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
    
    public ArrayList<Item> getLista(){
        return lista;
    }
    
    public String getDescricoesItens(){
        String itens="";
        for(int i=0;i<lista.size();i++){
            if(i==lista.size()-1)itens += lista.get(i).getDescricao();
            else itens += lista.get(i).getDescricao()+",";
        }
        return itens;
    }
}