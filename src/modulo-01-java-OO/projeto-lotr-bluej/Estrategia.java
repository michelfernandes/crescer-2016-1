import java.util.*;
public interface Estrategia
{
    public void atacar(ArrayList<Elfo> exercitoVivo,ArrayList<Dwarf> dwarves);
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();    
}
