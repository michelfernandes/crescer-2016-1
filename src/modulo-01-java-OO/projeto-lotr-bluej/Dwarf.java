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
    
    public Dwarf(){
    }
    public Dwarf(String nome){
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
}