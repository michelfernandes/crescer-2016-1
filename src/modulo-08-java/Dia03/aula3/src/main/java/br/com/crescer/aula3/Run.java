package br.com.crescer.aula3;

import java.util.ArrayList;
import java.util.List;

public class Run {
    
    
    public static void main(String[] args) {
        
        List<Pessoa> listaTeste = new ArrayList<Pessoa>();
        
        Pessoa ALTAIR = new Pessoa("jorge",3);
        
        IPessoa teste = new PessoaDAO();
        
        listaTeste = teste.findNome("mic");
        
        for(Pessoa pessoa : listaTeste) {
            System.out.println("ID:"+ pessoa.getId()+" Nome:"+pessoa.getNome());
        }
        
    }
    
    
}
