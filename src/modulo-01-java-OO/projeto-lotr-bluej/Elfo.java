
/**
 * Escreva a descrição da classe Elfo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Elfo extends Personagem
{
    protected int flechas = 42;
    protected double vida=100;
    
    public Elfo(String nome)
    {
        super(nome);
    }
    
    public Elfo(String nome, int f)
    {
        super(nome);
        flechas = f;
    }
  
    public void atirarFlecha(Dwarf anao)
    {
        flechas--;
        experiencia++;
        anao.anaoPerdeVida();
    }
    
    public int getFlecha(){
        return this.flechas;
    }
    
     public String toString() {  
        return String.format("%s possui %d flechas e %d níveis de experiência" ,this.nome,this.flechas,this.experiencia);  
    }
    
    public double getVida(){
        return this.vida;
    }
    
}

