/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FaculdadeModelPU");
        EntityManager em = emf.createEntityManager();
       
        Professor p = new Professor();
        p.setNome("Jorge Luis Boeira Bavaresco");
        p.setEmail("jorgebavaresco@ifsul.edu.br");
        p.setEspecialidade(em.find(Especialidade.class, 1));
        p.setTitulacao("Mestrado");
        p.setTopicosInteresse("Node JS, React, Projetos Maven");
        p.setNascimento(new GregorianCalendar(1986, Calendar.JULY, 14));
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
