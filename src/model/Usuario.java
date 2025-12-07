package model;


import util.PasswordUtils;


public abstract class Usuario {
    private final String id;
    private String nome;
    private String login;
    private String passwordHash;
    private String salt;


    public Usuario(String id, String nome, String login) {
        this.id = id;
        this.nome = nome;
        this.login = login;
    }


    public String getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }


    protected void setPasswordPlain(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres");
        }
        String newSalt = PasswordUtils.generateSalt();
        String hash = PasswordUtils.hashPassword(senha, newSalt);
        this.salt = newSalt;
        this.passwordHash = hash;
    }


    protected boolean verifyPassword(String senha) {
        if (senha == null || this.passwordHash == null || this.salt == null) return false;
        return PasswordUtils.verifyPassword(senha, this.salt, this.passwordHash);
    }


    public abstract String gerarRelatorio();