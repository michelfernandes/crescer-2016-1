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
    
    public int obterMaiorMultiploDeTresAte(int numero) {
      // Não é necessário o uso de array apenas INT
      int maior = 0;
      int limite = numero; // Declarar variavel limite
      for (int i = 0; i <= limite; i++) { //Deve começar do 0
          if (i % 3 == 0) {
              maior = i;
          }
      }
      return maior; // Deve retornar um inteiro e não um Array
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
      ArrayList<Integer> multiplos = new ArrayList<>();
      int limite = numero; // Declarar variavel limite
      for (int i = 0; i <= limite; i++) { //Deve começar do 0
          if (i % 3 == 0){ //break sem necessidade
              multiplos.add(i);
          }
      }
      return multiplos;
    }
}
