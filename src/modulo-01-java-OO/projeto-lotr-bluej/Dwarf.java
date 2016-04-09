/**
 * Escreva a descrição da classe Dwarf aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Dwarf
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int vida=110,experiencia=0;
    private Status status = Status.VIVO;
    private Inventario inv = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    
    
    public Dwarf(String nome){
        this.nome=nome;     
    }
    public Dwarf(String nome, DataTerceiraEra data){
        this(nome); 
        this.dataNascimento=data;    
    }
    
    public void anaoPerdeVida (){
        double a = getNumeroSorte();
        if(a<0){
            this.experiencia += 2;
        }else if(a<=100){
            //não faz nada
        }else{   
            if(status != Status.MORTO)this.vida = this.vida-10;
            if(this.vida==0) status = Status.MORTO;
        }
    }
    
    public void setNome(String novoNome){
        this.nome=novoNome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return status;        
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getDia(){
        return dataNascimento.getDia();
    }
    public int getMes(){
        return dataNascimento.getMes();
    }
    public int getAno(){
        return dataNascimento.getAno();
    }
    
    public Inventario getInventario(){
        return this.inv;
    }
    
    public void adicionarItem(Item item) {
        this.inv.adicionarItem(item);
    }

    public void perderItem(Item item) {
        this.inv.removerItem(item);
    }
    
    public double getNumeroSorte(){
        if(dataNascimento.ehBissexto()==true && this.vida>=80 && this.vida<=90){
            return (-33*101.0);        
        }
        if(dataNascimento.ehBissexto()==false && this.nome != null &&
        (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            return (101*33)%100;        
        }
        return 101.0;
    }
    
    public void tentarSorte(){
        if(-3333.0 == getNumeroSorte()){
            for(int i=0;i<inv.getLista().size();i++){
                int q = inv.getLista().get(i).getQuantidade();
                this.inv.getLista().get(i).setQuantidade(q);
            }
        }
    }
}