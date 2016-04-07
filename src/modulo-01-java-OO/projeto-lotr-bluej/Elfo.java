
/**
 * Escreva a descrição da classe Elfo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Elfo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int experiencia;
    private int flechas = 42;

    /**
     * COnstrutor para objetos da classe Elfo
     */
    public Elfo(String nome)
    {
        // inicializa variáveis de instância
        //this.nome refere-se a variável
        this.nome = nome;
        //System.out.println(nome);
    }
    public Elfo(String nome, int f)
    {
        // inicializa variáveis de instância
        this.nome = nome;
        flechas = f;
        
    }
  
    public void atirarFlecha(Dwarf anao)
    {
        flechas--;
        experiencia++;
        anao.anaoPerdeVida();
    }
    
    public int getFlecha(){
        return this.flechas;
    }
    
    public int getExp(){
        return this.experiencia;
    }
    
     public String toString() {  
        return (nome + " possui " + flechas + " flechas e " + experiencia + " níveis de experiência");  
    }
}

