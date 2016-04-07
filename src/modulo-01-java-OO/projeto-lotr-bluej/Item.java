
public class Item
{
    // instance variables - replace the example below with your own
    private int quantidade;
    private String descricao;

    public Item(int quantidade, String descricao)
    {
        this.quantidade=quantidade;
        this.descricao=descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

}
