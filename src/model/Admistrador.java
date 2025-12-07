package model;


import auth.Autenticacao;


public class Administrador extends Usuario implements Autenticacao {
    private final String adminId;


    public Administrador(String adminId, String nome, String login) {
        super(adminId, nome, login);
        this.adminId = adminId;
    }


    public void setSenha(String senha) { setPasswordPlain(senha); }


    @Override
    public boolean autenticar(String login, String senha) {
        if (!getLogin().equals(login)) return false;
        return verifyPassword(senha);
    }


    @Override
    public String gerarRelatorio() {
        return String.format("Administrador[id=%s, nome=%s]", getId(), getNome());
    }
}