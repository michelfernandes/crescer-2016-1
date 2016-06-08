package br.com.cwi.exerciciosdia01;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class MeuCalendarioUtil {
    
    public String diaDaSemanda(Date d){
        Calendar c = Calendar.getInstance();
        String diaDaSemana = "";
        int diaNumero;
        c.setTime(d);
        diaNumero = c.get(Calendar.DAY_OF_WEEK);
        
        switch(diaNumero){
            case 1:
                diaDaSemana = "Domingo";
                break;
            case 2:
                diaDaSemana = "Segunda";
                break;
            case 3:
                diaDaSemana = "Terça";
                break;
            case 4:
                diaDaSemana = "Quarta";
                break;
            case 5:
                diaDaSemana = "Quinta";
                break;
            case 6:
                diaDaSemana = "Sexta";
                break;
            case 7:
                diaDaSemana = "Sábado";
                break;    
        }
        return diaDaSemana;
    }
    
    public String tempoDecorrido(Date d){        
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dia, mes, ano;
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH);
        ano = c.get(Calendar.YEAR);
        c.setTime(data);
        int diaAtual, mesAtual, anoAtual;
        diaAtual = c.get(Calendar.DATE);
        mesAtual = c.get(Calendar.MONTH);
        anoAtual = c.get(Calendar.YEAR);
        //////////////////////
        /// EM ANDAMENTO//////
        //////////////////////
        int diaDif, mesDif, anoDif;
        
        anoDif = (anoAtual - ano);
        
        mesDif = (mesAtual - mes);
        
        diaDif = (diaAtual - dia);
        
        return new String(anoDif+" anos, "+mesDif+" meses, "+diaDif+" dias.");
    }
    
    public static void main(String[] args) {
        String aux;
        MeuCalendarioUtil teste = new MeuCalendarioUtil();  
        Date data = new Date("06/10/2016");
        aux = teste.diaDaSemanda(data);
        System.out.print(aux);
    }
}
