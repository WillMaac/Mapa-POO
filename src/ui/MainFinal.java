package ui;

import model.*;
import java.util.Scanner;

public class MainFinal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaAcademico sistema = new SistemaAcademico();

        int opcao = -1;

        System.out.println("\n FASE FINAL – Sistema Educacional Consolidado ");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        while (opcao != 0) {

            System.out.println("\n MENU PRINCIPAL");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Curso");
            System.out.println("4 - Criar Turma");
            System.out.println("5 - Adicionar Aluno na Turma");
            System.out.println("6 - Associar Professor à Turma");
            System.out.println("7 - Registrar Avaliação");
            System.out.println("8 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1: // CADASTRO DE ALUNO
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Curso (código): ");
                    String codigoCurso = sc.nextLine();

                    Curso c = sistema.buscarCurso(codigoCurso);
                    if (c == null) {
                        System.out.println("Curso não encontrado!");
                    } else {
                        Aluno a = new Aluno(nomeAluno, matricula, c);
                        sistema.adicionarAluno(a);
                        System.out.println("Aluno cadastrado com sucesso!");
                    }
                    break;

                case 2: // CADASTRO DE PROFESSOR
                    System.out.print("Nome do professor: ");
                    String nomeProf = sc.nextLine();
                    System.out.print("Especialidade: ");
                    String esp = sc.nextLine();
                    System.out.print("Registro profissional: ");
                    String reg = sc.nextLine();

                    Professor p = new Professor(nomeProf, esp, reg);
                    sistema.adicionarProfessor(p);

                    System.out.println("Professor cadastrado!");
                    break;

                case 3: // CADASTRO DE CURSO
                    System.out.print("Nome do curso: ");
                    String nomeCurso = sc.nextLine();
                    System.out.print("Código do curso: ");
                    String codCurso = sc.nextLine();
                    System.out.print("Carga horária: ");
                    int ch = sc.nextInt(); sc.nextLine();

                    Curso novoCurso = new Curso(nomeCurso, codCurso, ch);
                    sistema.adicionarCurso(novoCurso);

                    System.out.println("Curso cadastrado!");
                    break;

                case 4: // CRIAR TURMA
                    System.out.print("Código da turma: ");
                    String codTurma = sc.nextLine();
                    System.out.print("Curso da turma (código): ");
                    String codC = sc.nextLine();

                    Curso cursoTurma = sistema.buscarCurso(codC);

                    if (cursoTurma == null) {
                        System.out.println("Curso não encontrado.");
                    } else {
                        Turma t = new Turma(codTurma, cursoTurma);
                        sistema.adicionarTurma(t);
                        System.out.println("Turma criada!");
                    }
                    break;

                case 5: // ADICIONAR ALUNO À TURMA
                    System.out.print("Código da turma: ");
                    String turmaCode = sc.nextLine();
                    System.out.print("Matrícula do aluno: ");
                    String matAluno = sc.nextLine();

                    Turma turma = sistema.buscarTurma(turmaCode);
                    Aluno aluno = sistema.buscarAluno(matAluno);

                    if (turma == null || aluno == null) {
                        System.out.println("Turma ou aluno não encontrado.");
                    } else {
                        turma.adicionarAluno(aluno);
                        System.out.println("Aluno adicionado à turma!");
                    }
                    break;

                case 6: // ASSOCIAR PROFESSOR
                    System.out.print("Código da turma: ");
                    String tCod = sc.nextLine();
                    System.out.print("Registro do professor: ");
                    String regProf = sc.nextLine();

                    Turma turmaAssoc = sistema.buscarTurma(tCod);
                    Professor profAssoc = sistema.buscarProfessor(regProf);

                    if (turmaAssoc == null || profAssoc == null) {
                        System.out.println("Turma ou professor não encontrado.");
                    } else {
                        turmaAssoc.setProfessor(profAssoc);
                        System.out.println("Professor associado!");
                    }
                    break;

                case 7: // REGISTRAR AVALIAÇÃO
                    System.out.print("Matrícula do aluno: ");
                    String mat = sc.nextLine();
                    System.out.print("Descrição da avaliação: ");
                    String descAv = sc.nextLine();
                    System.out.print("Nota: ");
                    double nota = sc.nextDouble(); sc.nextLine();

                    Aluno alunoAv = sistema.buscarAluno(mat);
                    if (alunoAv == null) {
                        System.out.println("Aluno não encontrado.");
                    } else {
                        Avaliacao av = new Avaliacao(descAv, alunoAv, nota);
                        alunoAv.adicionarAvaliacao(av);
                        sistema.adicionarAvaliacao(av);
                        System.out.println("Avaliação registrada!");
                    }
                    break;

                case 8: // RELATÓRIOS
                    System.out.println("\n RELATÓRIOS DISPONÍVEIS");
                    System.out.println("1 - Relatório de Alunos");
                    System.out.println("2 - Relatório de Professores");
                    System.out.println("3 - Relatório de Cursos");
                    System.out.println("4 - Relatório de Turmas");
                    System.out.println("5 - Relatório Geral");
                    System.out.print("Escolha: ");

                    int r = sc.nextInt(); sc.nextLine();
                    switch (r) {
                        case 1: sistema.relatorioAlunos(); break;
                        case 2: sistema.relatorioProfessores(); break;
                        case 3: sistema.relatorioCursos(); break;
                        case 4: sistema.relatorioTurmas(); break;
                        case 5: sistema.demonstrarSistema(); break;
                        default: System.out.println("Opção inválida!");
                    }
                    break;

                case 0:
                    System.out.println("\n Sistema encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
