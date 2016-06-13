/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.exerciciosdia04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class ManagerUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");    
 
     public static final EntityManager em = emf.createEntityManager();    
     
     public static final Session session = em.unwrap(Session.class);
}
