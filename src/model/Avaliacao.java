package model;

public class Avaliacao {

    private String titulo;
    private double nota;
    private Aluno aluno;

    //  Construtor da Fase 3 (sem nota e sem aluno)
    public Avaliacao(String titulo) {
        this.titulo = titulo;
        this.nota = 0.0;
    }

    //  Construtor da Fase 5 (com aluno e nota inicial)
    public Avaliacao(String titulo, Aluno aluno, double nota) {
        this.titulo = titulo;
        this.aluno = aluno;
        atribuirNota(nota); // já valida aqui!
    }

    //  Método solicitado na Fase 3
    public void atribuirNota(double valor) {
        if (valor < 0 || valor > 10) {
            System.out.println("Nota inválida! A nota deve estar entre 0 e 10.");
            return;
        }
        this.nota = valor;
    }

    public double getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public String toString() {
        return "Avaliação: " + titulo + " | Nota: " + nota +
                (aluno != null ? " | Aluno: " + aluno.getNome() : "");
    }
}
