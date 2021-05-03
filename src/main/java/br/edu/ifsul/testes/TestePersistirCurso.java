/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FaculdadeModelPU");
        EntityManager em = emf.createEntityManager();
        
        Curso c = new Curso();
        c.setAtivo(Boolean.TRUE);
        c.setDescricao("Curso de Ciência da Computação do IFSUL");
        c.setInicioAtividades(Calendar.getInstance());
        c.setInstituicao(em.find(Instituicao.class, 3));
        c.setNome("Ciência da Computação");
        c.setSigla("CC");
        c.setUsuario(em.find(Usuario.class, "eliel.a"));
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
