/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author eliel
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome da disciplina não pode ser em branco.")
    @Length(max = 50, message = "O nome da disciplina não pode ter mais que {max} caracteres.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "A carga horária deve ser informada.")
    @Column(name = "carga_horaria", nullable = false)
    private Double cargaHoraria;
    
    @Column(name = "conhecimentos_minimos", columnDefinition = "text")
    private String conhecimentosMinimos;
    
    @NotNull(message = "O curso deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)
    private Curso curso;
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disciplinas_alunos",
            joinColumns = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false))
    private Set<Aluno> alunos = new HashSet<>();
    
    public Disciplina(){
        
    }
    
    public void adicionarNota(Nota obj) {
        obj.setDisciplina(this);
        this.getNotas().add(obj);
    }
    
    public void removerNota(int index){
        this.getNotas().remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
