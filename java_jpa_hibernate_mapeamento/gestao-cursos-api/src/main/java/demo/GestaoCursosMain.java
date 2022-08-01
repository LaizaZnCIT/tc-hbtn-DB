package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Telefone telefone = new Telefone();
        telefone.setDDD("00");
        telefone.setNumero("999988888");
        HashSet<Telefone> telefones = new HashSet<>();
        telefones.add(telefone);
        em.persist(telefone);

        Endereco endereco = new Endereco();
        endereco.setBairro("Bairro Legal");
        endereco.setLogradouro("Rua Bacana");
        endereco.setNumero("305");
        endereco.setCidade("CoolCity");
        endereco.setEstado("NiceState");
        endereco.setCep(10101003);
        endereco.setEndereco("Rua Bacana 305 Bairro Legal CoolCity NS");
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        em.persist(endereco);

        Aluno aluno = new Aluno();

        aluno.setEmail("laiza@email.com");
        aluno.setNomeCompleto("Lala Land");
        aluno.setMatricula("30303030");
        aluno.setNascimento(new Date(30, 04,1999));
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        Professor professor = new Professor();
        professor.setEmail("professor@email.com");
        professor.setMatricula("404044040");
        professor.setNomeCompleto("Silva da Silva");
        em.persist(professor);

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("www.youtube.com/curso-bom-de-programacao");
        em.persist(materialCurso);

        Curso curso = new Curso();
        curso.setSigla("INF");
        curso.setNome("Informática");
        HashSet<Curso> cursos = new HashSet<>();
        cursos.add(curso);


        alunoModel.create(aluno);
        cursoModel.create(curso);

        List<Aluno> alunosList = alunoModel.findAll();
        System.out.println("Alunos encontrados: " + alunosList.size());

        List<Curso> cursosList = cursoModel.findAll();
        System.out.println("Cursos encontrados: " + cursosList.size());


    }
}
