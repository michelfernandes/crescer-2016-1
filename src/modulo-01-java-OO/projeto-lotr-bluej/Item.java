
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
    
    public void adiciona1000(){
        this.quantidade = this.quantidade + 1000;
    }
    
    public void irishSorte(){
        int soma = 0;
        for(int i=1;i<=this.quantidade;i++){
            soma += i;
        }
        this.quantidade = this.quantidade + soma*1000;
    }
}
