package ui;


import model.*;
import repository.UserRepository;
import service.AuthService;


import java.util.Optional;


public class MainFase5 {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
        AuthService authService = new AuthService(userRepo);


        Aluno aluno = new Aluno("2025001", "Ana Silva", "ana.silva");
        aluno.setCurso("Engenharia de Software");
        aluno.setSenha("senhaAluno123");


        Professor prof = new Professor("PROF1001", "Dr. Carlos", "carlos.prof");
        prof.setEspecialidade("Banco de Dados");
        prof.setSenha("Prof#2025");


        Administrador admin = new Administrador("ADM01", "Mariana TI", "admin");
        admin.setSenha("Adm!2025");


        userRepo.save(aluno);
        userRepo.save(prof);
        userRepo.save(admin);


        testarLogin(authService, "ana.silva", "senhaAluno123");
        testarLogin(authService, "carlos.prof", "senhaErrada");
        testarLogin(authService, "admin", "Adm!2025");


        System.out.println("
                Relatórios:");
        System.out.println(aluno.gerarRelatorio());
        System.out.println(prof.gerarRelatorio());
        System.out.println(admin.gerarRelatorio());
    }


    private static void testarLogin(AuthService authService, String login, String senha) {
        Optional<Usuario> u = authService.autenticar(login, senha);
        if (u.isPresent()) {
            System.out.println("Login bem-sucedido para: " + u.get().getNome() + " (" + login + ")");
        } else {
            System.out.println("Falha na autenticação para login: " + login);
        }
    }
}