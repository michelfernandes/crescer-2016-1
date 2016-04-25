import java.util.*;
public class Inventario
{
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
        int qtdItemAtual,maior=0,ind=0;
        for (int i=0;i<lista.size();i++){
            qtdItemAtual=lista.get(i).getQuantidade();
            if(qtdItemAtual>maior){
                maior=qtdItemAtual;
                ind=i;
            }
        }
        return lista.isEmpty() ? null : lista.get(ind);
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
    
    public boolean equals(Object obj){
        Inventario inv = (Inventario)obj;
        if(this.lista.size() != inv.getLista().size())
            return false;
        for (int i=0; i<this.lista.size();i++){
            if(!this.lista.contains(inv.getLista().get(i)))
                return false;
        }
        for (int i=0; i<this.lista.size();i++){
            if(!inv.getLista().contains(this.lista.get(i)))
                return false;
        }
        return true;
    }
}