import java.util.*;

public class OfensivaIntercala implements Estrategia
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        if(verificaMeioAMeio(exercitoVivo)){
            ArrayList<Elfo> ordenado = ordenaOfensivaIntercalada(exercitoVivo);
            for(int i=0;i<ordenado.size();i++){
                for (int j=0; j<dwarves.size();j++){
                    ordenado.get(i).atirarFlecha(dwarves.get(j));
                }
                ordemDoUltimoAtaque.add(exercitoVivo.get(i));
            }
        }
    }
    
    private ArrayList<Elfo> ordenaOfensivaIntercalada(ArrayList<Elfo> elfos){
        ArrayList<Elfo> intercala = new ArrayList<>();
        int index0=0;
        int index1=1;
        //////////////////////////////////////////////////////////////////
        //////////////////EM ANDAMENTO///////////////////////////////////
        //////////////////////////////////////////////////////////////////        
        for(int i=0;i<elfos.size();i++){
            if(elfos.get(i) instanceof ElfoVerde){
                intercala.add(index0,elfos.get(i));
                index0+=2;
            }else{
                intercala.add(index1,elfos.get(i));
                index1+=2;
            }
        }
        return intercala;
    }
    
    private boolean verificaMeioAMeio(ArrayList<Elfo> elfos){
        int contVerde=0;
        int contNoturno=0;
        for(int i=0;i<elfos.size();i++){
            if(elfos.get(i) instanceof ElfoVerde){
                contVerde++;
            }else{
                contNoturno++;
            }
        }
        
        if (contNoturno != contVerde)return false;
        else return true;
    }
}
