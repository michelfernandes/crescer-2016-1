
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome)
    {
        super(nome);
    }
    
    public ElfoNoturno(String nome,int f)
    {
        super(nome);
        flechas=f;
    }
    
    public void atirarFlecha(Dwarf anao)
    {
        // ElfoNoturno nunca morre pois matematicamente o valor nunca chegará a exatamente 0.
        vida -= vida*0.05;
        flechas--;
        experiencia += 3;
        anao.anaoPerdeVida();
    }
}
