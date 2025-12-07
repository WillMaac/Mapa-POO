package model;

public class Professor {
    private String nome;
    private String registro;
    private String especialidade;

    public Professor(String nome, String registro, String especialidade) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (registro == null || registro.isBlank()) throw new IllegalArgumentException("Registro inválido");
        this.nome = nome;
        this.registro = registro;
        this.especialidade = especialidade == null ? "" : especialidade;
    }

    public String getNome() { return nome; }
    public String getRegistro() { return registro; }
    public String getEspecialidade() { return especialidade; }

    public String gerarRelatorio() {
        return "Relatório do Professor\nNome: " + nome +
                "\nRegistro: " + registro +
                "\nEspecialidade: " + especialidade + "\n";
    }

    @Override
    public String toString() {
        return String.format("%s (Registro: %s) - %s", nome, registro, especialidade);
    }
}
