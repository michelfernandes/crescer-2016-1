package br.com.cwi.exerciciosdia01;


public class MeuStringUtil {
    
    public boolean stringVazia(String s){
    
        return s == null || s.isEmpty();
        
    }
    
    public int contarVogais(String s){
        int vogaisCont = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
            case 'a':
                vogaisCont++;
                break;
            case 'e':
                vogaisCont++;
                break;
            case 'i':
                vogaisCont++;
                break;
            case 'o':
                vogaisCont++;
                break;
            case 'u':
                vogaisCont++;
                break;
            default:
                // ...
            }
        }
        System.out.print("Número de vogais: "+ vogaisCont);
        return vogaisCont;
    }
    
    public String inverterString(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        
        s = stringBuilder.reverse().toString();
        
        return s;
        
    }
    
    public boolean verificaPalindromo(String s){
    
       String resultado=""; 
        for(int i=s.length()-1 ; i>=0 ; i--){
            resultado += s.charAt(i);
        }
        if(resultado.equals(s)){
            return true;
        }else{
            return false;
        }        
    }
    
    public static void main(String[] args) {
        boolean aux;        
        MeuStringUtil teste = new MeuStringUtil();
        aux = teste.verificaPalindromo("teste");
        System.out.print(aux);
    }
    
}
