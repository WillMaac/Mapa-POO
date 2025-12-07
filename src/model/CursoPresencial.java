package model;

public class CursoPresencial extends Curso {

    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }

    @Override
    public String detalharCurso() {
        return "Curso Presencial: " + getNome() +
                " | Código: " + getCodigo() +
                " | Carga: " + getCargaHoraria() +
                "h | Sala: " + salaDeAula;
    }
}
