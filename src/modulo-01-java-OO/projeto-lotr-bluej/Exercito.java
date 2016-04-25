import java.util.*;
public class Exercito
{
    
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus = new HashMap<>();
    private Estrategia estrategia = new OfensivaPoupaNoturno();
    public void alistar( Elfo elfo) throws NaoPodeAlistarException{
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde){
            exercito.put(elfo.getNome(),elfo);
        }else {
            throw new NaoPodeAlistarException();
        }
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
    
    public void atacar(ArrayList<Dwarf> dwarves) {
        estrategia.atacar(new ArrayList<Elfo>(exercito.values()),dwarves);
    }
    
    public void mudarEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
         return this.estrategia.getOrdemDoUltimoAtaque();
     }
}
