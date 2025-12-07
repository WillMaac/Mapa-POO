package ui;

import model.Aluno;
import model.Avaliacao;
import model.Curso;

public class MainFase3 {
    public static void main(String[] args) {

        System.out.println(" FASE 3 – CONTROLE DE AVALIAÇÕES ");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        // Criando curso
        Curso curso = new Curso(
                "Ciência da Computação",
                "CC101",
                2400
        );

        // Criando aluno (AGORA CORRETO!)
        Aluno aluno = new Aluno(
                "Anderson Willian",
                "MT2025A001",
                curso
        );

        // Criando avaliações
        Avaliacao atividade1 = new Avaliacao("Prova 1 de Programação");
        Avaliacao atividade2 = new Avaliacao("Trabalho Final");

        // Atribuindo notas
        atividade1.atribuirNota(8.5);
        atividade2.atribuirNota(9.2);

        // Associando ao aluno
        aluno.adicionarAvaliacao(atividade1);
        aluno.adicionarAvaliacao(atividade2);

        // Mostrando informações
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Avaliações cadastradas:");
        for (Avaliacao av : aluno.getAvaliacoes()) {
            System.out.println("  - " + av);
        }
    }
}
