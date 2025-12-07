package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Relatorio {

    private String nome;
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String matricula, Curso curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void adicionarAvaliacao(Avaliacao av) {
        avaliacoes.add(av);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public String gerarRelatorio() {
        return "\n RELATÓRIO DO ALUNO \n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Curso: " + (curso != null ? curso.getNome() : "Não informado") + "\n" +
                "Total de Avaliações: " + avaliacoes.size() + "\n";
    }

    @Override
    public String toString() {
        return "Aluno: " + nome +
                " | Matrícula: " + matricula +
                " | Curso: " + (curso != null ? curso.getNome() : "Não informado");
    }
}
