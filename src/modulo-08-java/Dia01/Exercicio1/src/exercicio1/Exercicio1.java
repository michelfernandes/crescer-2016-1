
package exercicio1;

import  java.util.Scanner;
/**
 *
 * @author michel.fernandes
 */
public class Exercicio1 {

    public static void main(String[] args) {
        // TODO code application logic here     
        Scanner teclado = new Scanner(System.in);   
        System.out.println("Digite um numero:");
        int num = teclado.nextInt();
        
        if (num % 2 == 0){
            System.out.println("Par");
        }else{
            System.out.println("Impar");
        }
        
    }
    
}
