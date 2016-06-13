package br.com.crescer.aula05;


public class Pessoa {
    
    private int Idade;
    private String Nome;
    private String Sexo;
    
    public Pessoa(String nome,String sexo,int idade){
        this.Nome=nome;
        this.Sexo=sexo;
        this.Idade=idade;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }   
    
}
