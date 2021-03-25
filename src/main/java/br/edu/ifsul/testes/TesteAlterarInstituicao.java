/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Instituicao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TesteAlterarInstituicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FaculdadeModelPU");
        EntityManager em = emf.createEntityManager();
        
        Instituicao i = em.find(Instituicao.class, 1);
        i.setNome("Instituto Federal Sul-rio-grandense");
                
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
