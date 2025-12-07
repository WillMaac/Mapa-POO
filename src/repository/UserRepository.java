package repository;


import model.Usuario;
import java.util.*;


public class UserRepository {
    private final Map<String, Usuario> byLogin = new HashMap<>();


    public void save(Usuario usuario) {
        Objects.requireNonNull(usuario, "usuario não pode ser nulo");
        byLogin.put(usuario.getLogin(), usuario);
    }


    public Optional<Usuario> findByLogin(String login) {
        return Optional.ofNullable(byLogin.get(login));
    }


    public List<Usuario> findAll() {
        return new ArrayList<>(byLogin.values());
    }
}