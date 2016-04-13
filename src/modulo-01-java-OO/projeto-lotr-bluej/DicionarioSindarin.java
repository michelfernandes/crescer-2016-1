import java.util.*;
public class DicionarioSindarin
{
    public static void main(String[] args){
        //cria um hashmap de strings
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        //adiciona valores e chaves no hashmap
        dicionarioSindarin.put("terra","amar");
        dicionarioSindarin.put("fogo","naur");
        dicionarioSindarin.put("vento","gwaew");
        dicionarioSindarin.put("água","nen");
        dicionarioSindarin.put("coração","gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
        //sobrepoe um valor de mesma chave
        dicionarioSindarin.put("água","nîn");
        //removea chave e o valor
        dicionarioSindarin.remove("água");
        //está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        //tamanho
        int tamanhoDePares = dicionarioSindarin.size();
        //contém chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        //contém valor?
        boolean contemNaur = dicionarioSindarin.containsValue("naur");
        //Mesmo HashCode
        dicionarioSindarin.put("FB","facebook");
        dicionarioSindarin.put("Ea","badoo");
        
        for(Map.Entry<String,String> chaveValor : dicionarioSindarin.entrySet()){
            System.out.println("K: " + chaveValor.getKey() + "_ V: " + chaveValor.getValue());
        }
    }
}
