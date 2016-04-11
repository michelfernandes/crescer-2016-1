
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        flechas--;
        experiencia += 2;
        anao.anaoPerdeVida();
    }
    
    public void adicionarItem(Item item) {
        if(item.getDescricao()=="Espada de aço valiriano" || item.getDescricao()=="Arco e Flecha de Vidro")
        this.inv.adicionarItem(item);
    }
}
