import java.util.*;
public class DicionarioSindarin
{
    public static void main(String[] args){
        try{
            int resultado = 13/0;
        }catch (ArithmeticException ae){
            System.out.println("Tipo ArithmeticException");
            throw ae;
        }catch (Exception e){
            System.out.println("Tipo Exception");
        }
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\nEscolha a linguagem: ");
        System.out.println("[P]ortuguês [I]nglês");
        String idioma = scanner.nextLine();
        TradutorSindarin tradutor = criarTradutor(idioma);
        String palavra = scanner.nextLine();
        System.out.println(palavra + " significa " + tradutor.traduzir(palavra));*/
        // rodarExemplosHashMap();
    }
    
    private static TradutorSindarin criarTradutor(String idioma){
        TradutorSindarin tradutor = null;
        switch (idioma.toLowerCase()){
            case "i":
                tradutor = new SindarinParaIngles();
            break;
            default:
                tradutor = new SindarinParaPortugues();
            break;
        }
        return tradutor; 
    }
    
    private static void rodarExemplosHashMap(){
        //cria um hashmap de strings
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        //adiciona valores e chaves no hashmap
        dicionarioSindarin.put("terra","amar");
        dicionarioSindarin.put("fogo","naur");
        dicionarioSindarin.put("fire","naur");
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
