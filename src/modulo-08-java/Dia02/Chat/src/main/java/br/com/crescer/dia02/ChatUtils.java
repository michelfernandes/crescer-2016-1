package br.com.crescer.dia02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ChatUtils {
    
    public static BufferedReader getReader(String fila) throws FileNotFoundException {
       return new BufferedReader(new FileReader(fila));
   }
   
   public static BufferedWriter getWriter(String fila) throws IOException {
       return new BufferedWriter(new FileWriter(fila,true));
   }
    
    public static void main(String[] args) {
        System.out.println("Informe seu nome de usuario: "); 
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        new Thread(new Runnable(){
            @Override
            public void run(){
                BufferedReader bufferReader = null;
                try{
                    bufferReader = ChatUtils.getReader("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                    while(true){
                        String readLine = bufferReader.readLine();
                        if(readLine != null &&  !readLine.isEmpty()){
                            System.out.println(readLine);
                        }
                        Thread.sleep(100l);
                    }
                } catch(Exception e){
                
                }finally{
                    try{
                        if(bufferReader != null){
                            bufferReader.close();
                        }
                    }catch(IOException ex){
                    
                    }
                }
            }
        }).start();
        
        while(true){
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Digite uma mensagem: ");
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            if(":q!".equals(nextLine)){
                break;
            }
            BufferedWriter bufferedWriter = null;
            try{
                bufferedWriter = getWriter("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                bufferedWriter.write(formato.format(new Date())+ " "+ user +": " + nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }catch(Exception e){
                //...
            }finally{
                try{
                    if(bufferedWriter != null){
                        bufferedWriter.close();
                    }
                }catch(Exception e){
                }
            }
        }
        
    }
}
