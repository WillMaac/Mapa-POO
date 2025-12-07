package ui;

import model.Aluno;
import model.Professor;
import model.Curso;
import java.util.Scanner;

public class MainFase6 {
    public static void main(String[] args) {

        System.out.println("=== FASE 6 – Relatórios | Desenvolvido por Anderson Willian Jacinto de Jesus ===\n");

        Scanner sc = new Scanner(System.in);

        // Criando curso REAL para ser usado no aluno
        Curso cursoAluno = new Curso(
                "Tecnologia da Informação",
                "TI2025",
                1600
        );

        // Criando objetos para demonstrar relatórios (CORRIGIDO)
        Aluno a1 = new Aluno(
                "Lucas Pereira",
                "MT-2025-001",
                cursoAluno
        );

        Professor p1 = new Professor(
                "Caio Henrique",
                "PRF-12345",
                "Desenvolvimento Back-End em Java"
        );

        Curso c1 = new Curso(
                "Programação Orientada a Objetos",
                "POO101",
                60
        );

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n MENU DE RELATÓRIOS ");
            System.out.println("1 - Relatório do Aluno");
            System.out.println("2 - Relatório do Professor");
            System.out.println("3 - Relatório do Curso");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n" + a1.gerarRelatorio());
                    break;
                case 2:
                    System.out.println("\n" + p1.gerarRelatorio());
                    break;
                case 3:
                    System.out.println("\n" + c1.gerarRelatorio());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
