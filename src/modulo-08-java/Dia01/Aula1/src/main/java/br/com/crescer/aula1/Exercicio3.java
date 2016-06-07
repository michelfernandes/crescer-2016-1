/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author michel.fernandes
 */
public class Exercicio3 {
       
    
    public static void main(String[] args) {     
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Data e horario atual: " + dateFormat.format(date));
        
        
        try (final Scanner scanner = new Scanner(System.in)) {
            Calendar c = Calendar.getInstance();
            String formato = "dd/MM/yyyy";
            String a;
            Date data = new Date();
            System.out.println("Informe uma data: ");
            a = scanner.nextLine(); 
            data= new SimpleDateFormat(formato).parse(a);
            c.setTime(data);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            System.out.println(dayOfWeek);
            
        } catch (Exception e) {           
            System.out.println("Data Inválida");
        }        
    }    
}
