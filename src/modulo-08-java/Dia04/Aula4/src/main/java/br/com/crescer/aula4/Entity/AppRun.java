package br.com.crescer.aula4.Entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AppRun {
    // Criando um EntityManager
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) {
        
        
        /*        
        Query query = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = query.getResultList();
        
        for(Pessoa p : pessoas){
            System.out.println(p.getNmPessoa());
        }*/
        
        /*Pessoa pessoa = new Pessoa();      
        pessoa.setNmPessoa("MICHEL");
        
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();*/
                        
        /*System.out.println(em.isOpen());        
        Pessoa pessoa = em.find(Pessoa.class, 1l);        
        System.out.println(pessoa.getNmPessoa());*/
        
        
        em.close();
        emf.close();
    }
}
