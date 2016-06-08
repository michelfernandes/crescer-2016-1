
package br.com.cwi.exerciciosdia01;

import java.util.Calendar;
import java.util.Date;

public class Parcelator {
    
    public void parcelar(double valor, double j,int parcelas,Date data){
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        double juros = valor * (j/100);
        double valorParcela = valor / parcelas;
        double resultado = juros + valorParcela;
        for (int i=0;i<parcelas;i++){
        c.add(Calendar.MONTH, 1);
        System.out.println(i+" - "+c.getTime()+" Valor:"+resultado);
        }
        
    }
    
    public static void main(String[] args) {
        Parcelator parcelator = new Parcelator();
        
        parcelator.parcelar(1000,10,3,new Date());
        
    }
}
