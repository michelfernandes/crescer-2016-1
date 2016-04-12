
public class Elfo extends Personagem
{
    protected int flechas = 42;
    
    public Elfo(String nome)
    {
        super(nome);
        vida=100;
    }
    public Elfo(String nome, int f)
    {
        super(nome);
        flechas = f;
        vida=100;
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
    
}

