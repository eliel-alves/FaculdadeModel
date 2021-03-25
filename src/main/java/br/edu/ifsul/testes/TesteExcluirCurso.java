/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TesteExcluirCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FaculdadeModelPU");
        EntityManager em = emf.createEntityManager();
        
        Curso c = em.find(Curso.class, 1);
        em.getTransaction().begin();
        em.remove(c);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
