
public abstract class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Inventario inv = new Inventario();
    protected Status status = Status.VIVO;
    protected double vida;
    
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
    
    public Status getStatus(){
        return this.status;        
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public boolean equals(Object obj){
        Personagem personagem = (Personagem)obj;
        if( vida != personagem.getVida() || experiencia != personagem.getExperiencia() ||
        !inv.equals(personagem.getInventario()) || !nome.equals(personagem.getNome())|| 
        !status.equals(personagem.getStatus())){
            return false;
        }
        return true;
    }
    
    public abstract void tentarSorte();
}
