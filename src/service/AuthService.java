package service;


import auth.Autenticacao;
import model.Usuario;
import repository.UserRepository;


import java.util.Optional;


public class AuthService {
    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<Usuario> autenticar(String login, String senha) {
        Optional<Usuario> userOpt = userRepository.findByLogin(login);
        if (userOpt.isEmpty()) return Optional.empty();
        Usuario u = userOpt.get();
        if (u instanceof Autenticacao) {
            Autenticacao a = (Autenticacao) u;
            if (a.autenticar(login, senha)) return Optional.of(u);
        }
        return Optional.empty();
    }
}