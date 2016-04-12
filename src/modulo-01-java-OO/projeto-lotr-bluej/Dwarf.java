
public class Dwarf extends Personagem
{
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    
    public Dwarf(String nome){
        super(nome);
        vida=110;
    }
    public Dwarf(String nome, DataTerceiraEra data){
        super(nome); 
        this.dataNascimento=data;
        vida=110;
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
    
    public int getDia(){
        return dataNascimento.getDia();
    }
    public int getMes(){
        return dataNascimento.getMes();
    }
    public int getAno(){
        return dataNascimento.getAno();
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
                this.inv.getLista().get(i).adiciona1000();
            }
        }
    }
}