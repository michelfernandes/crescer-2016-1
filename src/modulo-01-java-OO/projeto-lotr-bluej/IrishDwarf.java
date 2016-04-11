
/**
 * Escreva a descrição da classe Dwarf aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class IrishDwarf extends Dwarf
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    
    public IrishDwarf(String nome){
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra data){
        super(nome, data);   
    }
    
    public void tentarSorte(){
        if(-3333.0 == getNumeroSorte()){
            for(int i=0;i<inv.getLista().size();i++){
                this.inv.getLista().get(i).irishSorte();
            }
        }
    }
}
