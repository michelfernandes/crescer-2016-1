import java.util.*;
/**
 * Write a description of class HobbitContador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HobbitContador
{
    // instance variables - replace the example below with your own
    //private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        int a,b,resto,mmc;
        int soma=0,produto=0;
        for(int j=0;j<arrayDePares.size();j++){
            produto = arrayDePares.get(j).get(0) * arrayDePares.get(j).get(1);
            a = arrayDePares.get(j).get(0);
            b = arrayDePares.get(j).get(1);
            do{
                resto= a%b;
                a=b;
                b=resto;
            }while(resto!=0);
            mmc=(arrayDePares.get(j).get(0) * arrayDePares.get(j).get(1)) / a;
            soma = soma + (produto - mmc); 
        }
        return soma;
    }

}
