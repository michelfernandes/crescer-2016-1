
public class Personagem
{
    // instance variables - replace the example below with your own
    protected String nome;
    protected int experiencia;
    protected Inventario inv = new Inventario();
    
    public Personagem (String nome){
        this.nome=nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Inventario getInventario (){
        return this.inv;
    }
    
    public void perderItem(Item item) {
        this.inv.removerItem(item);
    }
    
    public void adicionarItem(Item item) {
        this.inv.adicionarItem(item);
    }
    
    public String getNome(){
        return this.nome;
    }
}