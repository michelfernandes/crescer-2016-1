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
        exercitoPorStatus.clear();
        for(Map.Entry<String,Elfo> chaveValor : exercito.entrySet()){
            Elfo elfo = chaveValor.getValue();
            Status status = chaveValor.getValue().getStatus();
            ArrayList<Elfo> statusNoAgrupamento = exercitoPorStatus.get(status);
            boolean precisaCriarStatus = statusNoAgrupamento == null;

            if (precisaCriarStatus) {
                statusNoAgrupamento = new ArrayList<Elfo>();
                exercitoPorStatus.put(status, statusNoAgrupamento);
            }
            statusNoAgrupamento.add(elfo);
        }
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
