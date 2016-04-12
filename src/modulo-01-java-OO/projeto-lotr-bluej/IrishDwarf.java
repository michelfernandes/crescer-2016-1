
public class IrishDwarf extends Dwarf
{
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
