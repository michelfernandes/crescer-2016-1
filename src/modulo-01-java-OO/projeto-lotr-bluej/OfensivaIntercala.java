import java.util.*;

public class OfensivaIntercala implements Estrategia
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> ordenado = ordenaOfensiva(exercitoVivo);
        for(int i=0;i<ordenado.size();i++){
            for (int j=0; i<dwarves.size();j++){
                ordenado.get(i).atirarFlecha(dwarves.get(j));
            }
            ordemDoUltimoAtaque.add(exercitoVivo.get(i));
        }
        
    }
    
    private ArrayList<Elfo> ordenaOfensiva(ArrayList<Elfo> elfos){
        ArrayList<Elfo> ordenado = new ArrayList<>();
        boolean alterna;
        /////////////////////////////////////////////////////
        /////////// EM ANDAMENTO/////////////////////////////
        /////////////////////////////////////////////////////
        return ordenado;
    }
}
