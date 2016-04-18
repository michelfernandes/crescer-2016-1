import java.util.*;

public class OfensivaIntercala implements Estrategia
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves){
        if(verificaMeioAMeio(exercitoVivo)){
            ordenaOfensivaIntercalada(exercitoVivo);
            for(int i=0;i<exercitoVivo.size();i++){
                for (int j=0; j<dwarves.size();j++){
                    ordemDoUltimoAtaque.get(i).atirarFlecha(dwarves.get(j));
                }
            }
        }
    }
    
    private void ordenaOfensivaIntercalada(ArrayList<Elfo> elfos){
        
        Elfo primeiro = elfos.get(0);
        ordemDoUltimoAtaque.add(primeiro);
        Class classeDoUltimoAdicionado = primeiro.getClass();
        elfos.remove(primeiro);

        while (elfos.size() > 0) {
            for (int j = 0; j < elfos.size(); j++) {
                Elfo atual = elfos.get(j);
                boolean estaIntercalado = atual.getClass() != classeDoUltimoAdicionado;

                if (estaIntercalado) {
                    ordemDoUltimoAtaque.add(atual);
                    classeDoUltimoAdicionado = atual.getClass();
                }
                if (estaIntercalado || atual.getStatus() == Status.MORTO) {
                    elfos.remove(atual);
                }
            }
        }
    
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
