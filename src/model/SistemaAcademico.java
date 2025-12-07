package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {

    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    // ---------------- CADASTROS ----------------

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public void adicionarProfessor(Professor p) {
        professores.add(p);
    }

    public void adicionarCurso(Curso c) {
        cursos.add(c);
    }

    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    public void adicionarAvaliacao(Avaliacao a) {
        avaliacoes.add(a);
    }

    // ---------------- BUSCAS ----------------

    public Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                return a;
            }
        }
        return null;
    }

    public Professor buscarProfessor(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equalsIgnoreCase(registro)) {
                return p;
            }
        }
        return null;
    }

    public Turma buscarTurma(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                return t;
            }
        }
        return null;
    }

    // ---------------- RELATÓRIOS ----------------

    public void relatorioAlunos() {
        System.out.println("\n RELATÓRIO DE ALUNOS");
        if (alunos.isEmpty()) System.out.println("Nenhum aluno cadastrado.");
        for (Aluno a : alunos) System.out.println(a);
    }

    public void relatorioProfessores() {
        System.out.println("\n RELATÓRIO DE PROFESSORES");
        if (professores.isEmpty()) System.out.println("Nenhum professor cadastrado.");
        for (Professor p : professores) System.out.println(p);
    }

    public void relatorioCursos() {
        System.out.println("\n RELATÓRIO DE CURSOS");
        if (cursos.isEmpty()) System.out.println("Nenhum curso cadastrado.");
        for (Curso c : cursos) System.out.println(c);
    }

    public void relatorioTurmas() {
        System.out.println("\n RELATÓRIO DE TURMAS");
        if (turmas.isEmpty()) System.out.println("Nenhuma turma cadastrada.");
        for (Turma t : turmas) System.out.println(t);
    }

    public void demonstrarSistema() {
        System.out.println("\n RELATÓRIO GERAL DO SISTEMA");
        relatorioCursos();
        relatorioProfessores();
        relatorioAlunos();
        relatorioTurmas();
        System.out.println("\nAvaliações registradas: " + avaliacoes.size());
    }
}
