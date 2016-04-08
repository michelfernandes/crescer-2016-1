
/**
 * Write a description of class DataTerceiraEra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataTerceiraEra
{
    // instance variables - replace the example below with your own
    private int dia,mes,ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){
         this.dia=dia;
         this.mes=mes;
         this.ano=ano;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
    }
    public boolean ehBissexto(){
        return this.ano%400 == 0 || this.ano%4 == 0 && this.ano%100 !=0 ;
    }
}
