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
    
    public Item getItemPopular(){
        int x,maior=0,ind=0;
        for (int i=0;i<lista.size();i++){
            x=lista.get(i).getQuantidade();
            if(x>maior){
                maior=x;
                ind=i;
            }
        }
        return lista.get(ind);
    }
    
    public void ordenarItens(){
        Item aux;
        for(int j=0;j<lista.size()-1;j++){
            for (int i=0;i<lista.size()-1;i++){
                if(lista.get(i).getQuantidade() > lista.get(i+1).getQuantidade()){
                    aux=lista.get(i);
                    lista.set(i,lista.get(i+1));
                    lista.set(i+1,aux);
                }            
            }
        }
    }
}