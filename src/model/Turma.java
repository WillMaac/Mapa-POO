package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    // --- CONSTRUTOR COMPLETO (obrigatório professor) ---
    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    // --- NOVO CONSTRUTOR (sem professor) ---
    public Turma(String codigo, Curso curso) {
        this.codigo = codigo;
        this.curso = curso;
        this.professor = null; // para preencher depois, se quiser
    }

    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public Curso getCurso() { return curso; }
    public List<Aluno> getListaAlunos() { return new ArrayList<>(listaAlunos); }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean adicionarAluno(Aluno a) {
        if (a == null) return false;
        if (listaAlunos.contains(a)) return false;
        listaAlunos.add(a);
        return true;
    }

    public boolean removerAluno(Aluno a) {
        return listaAlunos.remove(a);
    }

    public String resumo() {
        return String.format(
                "Turma %s | Curso: %s | Professor: %s | Alunos: %d",
                codigo,
                curso != null ? curso.getNome() : "N/A",
                professor != null ? professor.getNome() : "N/A",
                listaAlunos.size()
        );
    }

    @Override
    public String toString() {
        return resumo();
    }
}
