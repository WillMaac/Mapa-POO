package ui;

import model.*;
import repository.*;
import service.*;
import util.IdGenerator;
import repository.AlunoRepository;


import java.util.Scanner;

public class MainFase7 {

    // Repos & Services
    private static final CursoRepository cursoRepo = new CursoRepository();
    private static final AlunoRepository alunoRepo = new AlunoRepository();
    private static final ProfessorRepository profRepo = new ProfessorRepository();

    private static final CursoService cursoService = new CursoService(cursoRepo);
    private static final AlunoService alunoService = new AlunoService(alunoRepo);
    private static final ProfessorService professorService = new ProfessorService(profRepo);

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" FASE 7 - Arquitetura em Camadas ");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        seed();

        while (true) {
            System.out.println("\n MENU FASE 7 ");
            System.out.println("1 - Cadastrar Curso");
            System.out.println("2 - Listar Cursos");
            System.out.println("3 - Cadastrar Professor");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Cadastrar Aluno");
            System.out.println("6 - Listar Alunos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = Integer.parseInt(sc.nextLine().trim());
            try {
                switch (op) {
                    case 1 -> flowCadastrarCurso();
                    case 2 -> flowListarCursos();
                    case 3 -> flowCadastrarProfessor();
                    case 4 -> flowListarProfessores();
                    case 5 -> flowCadastrarAluno();
                    case 6 -> flowListarAlunos();
                    case 0 -> { System.out.println("Encerrando..."); return; }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void seed() {
        // cursos
        Curso c1 = new Curso("Ciência da Computação", "CC101", 2400);
        Curso c2 = new Curso("Desenvolvimento Back-End em Java", "JB202", 360);
        cursoService.cadastrarCurso(c1);
        cursoService.cadastrarCurso(c2);

        // professores
        Professor p1 = new Professor("Carlos Henrique", "PR00685994" + IdGenerator.next(), "Desenvolvimento Back-End em Java");
        Professor p2 = new Professor("Mariana Alves", "PR75069985" + IdGenerator.next(), "Banco de Dados");
        professorService.cadastrarProfessor(p1);
        professorService.cadastrarProfessor(p2);

        // alunos
        Aluno a1 = new Aluno("Anderson Willian Jacinto de Jesus", "a6670656" + IdGenerator.next(), c1);
        Aluno a2 = new Aluno("Beatriz Santos", "a3620365" + IdGenerator.next(), c2);
        alunoService.cadastrarAluno(a1);
        alunoService.cadastrarAluno(a2);
    }

    private static void flowCadastrarCurso() {
        System.out.println("\n Cadastrar Curso ");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Carga horária (horas): ");
        int carga = Integer.parseInt(sc.nextLine().trim());
        Curso c = new Curso(nome, codigo, carga);
        cursoService.cadastrarCurso(c);
        System.out.println("Curso cadastrado: " + c);
    }

    private static void flowListarCursos() {
        System.out.println("\n Cursos Cadastrados ");
        for (Curso c : cursoService.listarTodos()) {
            System.out.println(" - " + c);
        }
    }

    private static void flowCadastrarProfessor() {
        System.out.println("\n Cadastrar Professor ");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        String registro = "PR" + IdGenerator.next();
        System.out.print("Especialidade: ");
        String esp = sc.nextLine().trim();
        Professor p = new Professor(nome, registro, esp);
        professorService.cadastrarProfessor(p);
        System.out.println("Professor cadastrado: " + p);
    }

    private static void flowListarProfessores() {
        System.out.println("\n Professores Cadastrados ");
        for (Professor p : professorService.listarTodos()) {
            System.out.println(" - " + p);
        }
    }

    private static void flowCadastrarAluno() {
        System.out.println("\n Cadastrar Aluno ");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        String mat = "MT" + IdGenerator.next();
        System.out.println("Cursos disponíveis:");
        for (Curso c : cursoService.listarTodos()) {
            System.out.println(" - " + c.getCodigo() + ": " + c.getNome());
        }
        System.out.print("Código do curso (ou vazio): ");
        String codigoCurso = sc.nextLine().trim();
        Curso curso = codigoCurso.isBlank() ? null : cursoService.buscarPorCodigo(codigoCurso).orElse(null);
        Aluno a = new Aluno(nome, mat, curso);
        alunoService.cadastrarAluno(a);
        System.out.println("Aluno cadastrado: " + a);
    }

    private static void flowListarAlunos() {
        System.out.println("\n Alunos Cadastrados ");
        for (Aluno a : alunoService.listarTodos()) {
            System.out.println(" - " + a);
        }
    }
}
