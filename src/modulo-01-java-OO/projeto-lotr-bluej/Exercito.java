import java.util.*;
public class Exercito
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public void alistar( Elfo elfo){
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde)
        exercito.put(elfo.getNome(),elfo);
    }
    
    public Elfo buscaNome(String nome){
        for(Map.Entry<String,Elfo> chaveValor : exercito.entrySet()){
            if(chaveValor.getKey().equals(nome)){
                return chaveValor.getValue();
            }
        }
        return null;
    }
    
    public HashMap<String,Elfo> getExercito(){
        return this.exercito;
    }
}
