
/**
 * Escreva a descrição da classe CestoDeLembas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CestoDeLembas
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * COnstrutor para objetos da classe CestoDeLembas
     */
    public CestoDeLembas(int x)
    {
        // inicializa variáveis de instância
        this.x = x;
    }
    
    public boolean podeDividirEmPares(){
        if(x%2==0 && x>2 && x<=100){
            return true;
        }
        return false;        
    }
   
}
    