import java.util.*;

public class OfensivaPoupaNoturno implements Estrategia
{   
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        int intencaoTotal = exercitoVivo.size() * dwarves.size();
        int intencaoPermitida = (int)(intencaoTotal * 0.3);
        int cont=0;
        for (int i=0;i<exercitoVivo.size();i++){
            if(exercitoVivo.get(i).getStatus() != Status.VIVO) continue;
            for (int j=0; j<dwarves.size();j++){
                if(exercitoVivo.get(i) instanceof ElfoNoturno){
                    if(cont < intencaoPermitida){
                        exercitoVivo.get(i).atirarFlecha(dwarves.get(j));
                        cont++;
                        ordemDoUltimoAtaque.add(exercitoVivo.get(i)); 
                    }
                }else{
                    exercitoVivo.get(i).atirarFlecha(dwarves.get(j));
                    ordemDoUltimoAtaque.add(exercitoVivo.get(i)); 
                }
            }  
        }
    }
}
