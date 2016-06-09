package br.com.crescer.exerciciosdia02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MeuWriterUtils {
    
    public static BufferedWriter getWriter(String fila) throws IOException {
       return new BufferedWriter(new FileWriter(fila,true));
   }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo:");
        String nome = teclado.nextLine();
        
        if(nome.contains(".txt")){            
            System.out.print("Digite o que deseja inserir:");
            String linha = teclado.nextLine();
            BufferedWriter bufferWriter = null;
            try {            
            bufferWriter = MeuWriterUtils.getWriter(nome);
            bufferWriter.newLine();            
            bufferWriter.write(linha);
            bufferWriter.flush();
                        
            } catch (Exception e) {
                System.out.println("Arquivo não encontrado");
            } finally{
                try {
                    if(bufferWriter != null){
                        bufferWriter.close();
                    }
                } catch (IOException ex) {
                    
                }
            }
        }else{
            System.out.println("Arquivo deve ser um .txt");
        }
    }
    
}
