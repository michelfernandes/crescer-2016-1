import java.util.*;
public class Exercito
{
    
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus = new HashMap<>();
    
    public void alistar( Elfo elfo){
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde)
        exercito.put(elfo.getNome(),elfo);
    }
    
    public Elfo buscaNome(String nome){
        return exercito.get(nome);
    }
    
    public HashMap<String,Elfo> getExercito(){
        return this.exercito;
    }
    
    void agruparPorStatus(){
        ArrayList<Elfo> elfosVivos = new ArrayList<>();
        ArrayList<Elfo> elfosMortos = new ArrayList<>();
        ArrayList<Elfo> elfosInconscientes = new ArrayList<>();
        for(Map.Entry<String,Elfo> chaveValor : exercito.entrySet()){
            if(chaveValor.getValue().getStatus()==Status.VIVO){
                elfosVivos.add(chaveValor.getValue());
            }else if(chaveValor.getValue().getStatus()==Status.MORTO){
                elfosMortos.add(chaveValor.getValue());
            }else{
                elfosInconscientes.add(chaveValor.getValue());
            }
        }
        exercitoPorStatus.put(Status.VIVO,elfosVivos);
        exercitoPorStatus.put(Status.MORTO,elfosMortos);
        exercitoPorStatus.put(Status.INCONSCIENTE,elfosInconscientes);
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus(){
        return this.exercitoPorStatus;
    }
    
    public ArrayList<Elfo> buscar(Status status){
        return exercitoPorStatus.get(status);
    }
}
