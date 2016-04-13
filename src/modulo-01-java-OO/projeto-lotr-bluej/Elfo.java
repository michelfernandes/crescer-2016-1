
public class Elfo extends Personagem
{
    protected int flechas = 42;
    private static int contadorElfo=0;
    
    public Elfo(String nome)
    {
        super(nome);
        vida=100;
        contadorElfo++;
    }
    public Elfo(String nome, int f)
    {
        this(nome);
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
    
    protected void finalize() throws Throwable {
        Elfo.contadorElfo--;
        super.finalize();
    }
    
    public static int getContadorElfo(){
        return contadorElfo;
    }
}

