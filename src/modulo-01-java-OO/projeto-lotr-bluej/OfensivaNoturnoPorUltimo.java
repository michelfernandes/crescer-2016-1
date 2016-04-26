import java.util.*;

public class OfensivaNoturnoPorUltimo implements Estrategia
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        ordenaOfensiva(exercitoVivo);
        for(int i=0;i<exercitoVivo.size();i++){
            if(exercitoVivo.get(i).getStatus() != Status.VIVO) continue;
            for (int j=0; j<dwarves.size();j++){
                exercitoVivo.get(i).atirarFlecha(dwarves.get(j));
            }
            ordemDoUltimoAtaque.add(exercitoVivo.get(i));
        }
        
    }
    
    private void ordenaOfensiva(ArrayList<Elfo> elfos){
        //Comparator<Elfo> nomeComparador = new Comparator<Elfo>(); 
        Collections.sort(elfos, new Comparator<Elfo>(){
                public int compare(Elfo elfoAtual, Elfo proximoElfo) {
                    boolean mesmoTipo = elfoAtual.getClass() == proximoElfo.getClass();

                    if (mesmoTipo) return 0;
                        
                    return elfoAtual instanceof ElfoVerde && proximoElfo instanceof ElfoNoturno ? -1 : 1;
                }
            });
    }
}
