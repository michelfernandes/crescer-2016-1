package br.com.crescer.exerciciosdia02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MeuFileUtils {
    
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite a instrução:");
        String instrucao = teclado.nextLine();        
                
        switch (instrucao){
            case "mk":
                System.out.print("\nDigite o nome do arquivo:"); 
                String nomeCriar = teclado.nextLine();
                
                File fileCriar = new File(nomeCriar);
                fileCriar.createNewFile();
                System.out.print("Arquivo criado com sucesso!");        
            break;
            case "rm":
                System.out.print("\nDigite o nome do arquivo:"); 
                String nomeDeletar = teclado.nextLine();
                
                File fileDeletar = new File(nomeDeletar);
                fileDeletar.delete();
                System.out.print("Arquivo deletado com sucesso!");        
            break;
            case "ls":
                System.out.print("\nDigite o nome do arquivo:"); 
                String nomePath = teclado.nextLine();    
                
                File fileListar = new File(nomePath);
                if (fileListar.isDirectory()){
                    File[] list = fileListar.listFiles();
                    for(int i=0; i<list.length ; i++){
                        System.out.println(list[i].getName());
                    }
                }else{
                    System.out.println(fileListar.getAbsolutePath());
                }
            break;
            case "mv":
                System.out.print("\nDigite o nome do arquivo:"); 
                String nomeMover = teclado.nextLine();
                System.out.print("\nDigite para onde deseja move-lo:"); 
                String nomeDir = teclado.nextLine();
                
                File fileMover = new File(nomeMover);
                File fileDir = new File(nomeDir);
                if(fileMover.isDirectory()){
                    System.out.print("\nArquivo inválido");
                }else{
                    fileMover.renameTo(new File(fileDir.getAbsolutePath()+"\\" +fileMover.getName()));
                }
            break;
            default:           
                System.out.print("Comando invalido!");
            break;
        }
    }
    
}
