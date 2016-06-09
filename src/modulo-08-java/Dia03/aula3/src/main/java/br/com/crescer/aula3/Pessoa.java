package br.com.crescer.aula3;


public class Pessoa {
    
    private long id;
    private String nome;     
    
    public Pessoa(String nome){
        this.nome=nome;
    }
    
    public Pessoa(String nome,long id){
        this.id=id;
        this.nome=nome;
    }
    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
}
