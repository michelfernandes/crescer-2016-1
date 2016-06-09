package br.com.crescer.exerciciosdia02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MeuReaderUtils {
    
    public static BufferedReader getReader(String fila) throws FileNotFoundException{
        return new BufferedReader(new FileReader(fila));
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo:");
        String nome = teclado.nextLine();   
        
        if(nome.contains(".txt")){
            BufferedReader bufferReader = null;
            try {            
            bufferReader = MeuReaderUtils.getReader(nome);
            String linha;
            
            while(true){
                linha = bufferReader.readLine();
                if(linha != null){
                System.out.println(linha);
                }else{
                break;
                }                
            }
            
            } catch (Exception e) {
                System.out.println("Arquivo não encontrado");
            } finally{
                try {
                    if(bufferReader != null){
                        bufferReader.close();
                    }
                } catch (IOException ex) {
                    
                }
            }
        }else{
            System.out.println("Arquivo deve ser um .txt");
        }
        
    }
    
}
