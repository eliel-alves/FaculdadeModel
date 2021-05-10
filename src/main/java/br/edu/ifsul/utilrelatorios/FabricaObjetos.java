/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author eliel
 */
public class FabricaObjetos {
    public static List<Professor> carregaProfessores() {
        List<Professor> lista = new ArrayList<>();
        
        Professor p = new Professor();
        
        p.setNome("Eliel Alves");
        p.setId(1);
        p.setNascimento(Calendar.getInstance());
        p.setEmail("elielalves.cc@gmail.com");
        Especialidade e = new Especialidade();
        e.setNome("Ser preguiçoso");
        p.setEspecialidade(e);
        p.setTitulacao("Doutorado");
        p.setTopicosInteresse("<h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br><h1>AQUI VAI UM TOPICO DE <strong>INTERESSE</strong></h1><br>");
        
        lista.add(p);
        return lista;
    }
    
    public static List<Aluno> carregaAlunos() {
        List<Aluno> listaAlunos = new ArrayList<>();
        
        Aluno a = new Aluno();
        a.setNome("Elielzin Gameplays");
        a.setId(1);
        a.setNascimento(Calendar.getInstance());
        a.setEmail("elielalves.cc@gmail.com");
        
        listaAlunos.add(a);
        
        return listaAlunos;
    }
}
