
package br.com.crescer.aula1;

public class StringUtils {
    
    public static void main(String[] args){
        
        //final List<Estados> list = Arrays.asList(Estados.values());
        
        StringBuffer buffer = new StringBuffer();
        for (Estados d: Estados.values())
            {              
              buffer.append(d.getNome()+", ");              
            }
        buffer.deleteCharAt(buffer.length()-2);
        buffer.insert(buffer.length()-1,".");
        System.out.println(buffer);
    }       
}
