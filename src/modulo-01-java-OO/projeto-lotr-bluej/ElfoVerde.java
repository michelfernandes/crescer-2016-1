
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome)
    {
        super(nome);
    }
    
    public ElfoVerde(String nome,int f)
    {
        super(nome);
        flechas=f;
    }
    
    public void atirarFlecha(Dwarf anao)
    {
        super.atirarFlecha(anao);
        experiencia++;
    }
    
    public void adicionarItem(Item item) {
        if(item.getDescricao()=="Espada de aço valiriano" || item.getDescricao()=="Arco e Flecha de Vidro")
        this.inv.adicionarItem(item);
    }
}
