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
    private int vida=110;
    private Status status = Status.VIVO;
    private Inventario inv = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    
    public Dwarf(){
    }
    public Dwarf(String nome){
        this.nome=nome;     
    }
    public Dwarf(String nome, DataTerceiraEra data){
        this.dataNascimento=data;
        this.nome=nome;     
    }
    
    public void anaoPerdeVida (){
        if(status != Status.MORTO)this.vida = this.vida-10;
        if(this.vida==0) status = Status.MORTO;
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
    
    public int getDia(){
        return dataNascimento.getDia();
    }
    public int getMes(){
        return dataNascimento.getMes();
    }
    public int getAno(){
        return dataNascimento.getAno();
    }
    
    //public double getNumeroSorte
    
}