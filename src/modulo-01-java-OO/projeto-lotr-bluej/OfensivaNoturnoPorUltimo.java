import java.util.*;

public class OfensivaNoturnoPorUltimo implements Estrategia
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> ordenado = ordenaOfensiva(exercitoVivo);
        for(int i=0;i<ordenado.size();i++){
            for (int j=0; j<dwarves.size();j++){
                ordenado.get(i).atirarFlecha(dwarves.get(j));
            }
            ordemDoUltimoAtaque.add(ordenado.get(i));
        }
        
    }
    
    private ArrayList<Elfo> ordenaOfensiva(ArrayList<Elfo> elfos){
        ArrayList<Elfo> ordenado = new ArrayList<>();
        for(int i=0;i<elfos.size();i++){
            if(elfos.get(i) instanceof ElfoVerde)
            ordenado.add(elfos.get(i));
        }
        for(int i=0;i<elfos.size();i++){
            if(elfos.get(i) instanceof ElfoNoturno)
            ordenado.add(elfos.get(i));
        }
        return ordenado;
    }
}
