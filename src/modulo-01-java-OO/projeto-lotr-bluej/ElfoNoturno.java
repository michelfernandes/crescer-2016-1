
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
        super.atirarFlecha(anao);
        this.experiencia += 2;
        if(status != Status.MORTO)this.vida -= this.vida*0.05;
        if(this.vida<1) status = Status.MORTO;
    }
}
