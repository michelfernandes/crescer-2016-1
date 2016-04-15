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
        int max = (int)(intencaoPermitida / dwarves.size());
        int cont=0;
        for (int i=0;i<exercitoVivo.size();i++){
            if(exercitoVivo.get(i) instanceof ElfoNoturno)cont++;
            
            if (exercitoVivo.get(i) instanceof ElfoNoturno && cont > max){
                //não faz nada
            }else{
                for (int j=0; j<dwarves.size();j++){
                        exercitoVivo.get(i).atirarFlecha(dwarves.get(j));
                }
                ordemDoUltimoAtaque.add(exercitoVivo.get(i));
            }
        }
    }
}
