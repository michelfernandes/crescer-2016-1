
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
        if(status != Status.MORTO)this.vida -= this.vida*0.05;
        if(this.vida==0) status = Status.MORTO;
        flechas--;
        experiencia += 3;
        anao.anaoPerdeVida();
    }
}
