package ui;

import model.Aluno;
import model.Professor;
import model.Curso;

public class MainFase1 {
    public static void main(String[] args) {

        System.out.println("\n FASE 1 – Sistema Educacional");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        // Criando o curso antes de usar no aluno
        Curso curso = new Curso("Ciência da Computação", "CC101", 2400);

        // Criando o aluno corretamente
        Aluno aluno = new Aluno(
                "Anderson Willian",
                "MT2025A001",
                curso
        );

        // Criando professor
        Professor professor1 = new Professor(
                "Caio Henrique",
                "PRF-2025-001",
                "Engenharia de Software"
        );

        // Exibindo os dados
        System.out.println(aluno);
        System.out.println(professor1);
        System.out.println(curso);
    }
}
