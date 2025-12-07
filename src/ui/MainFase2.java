package ui;

import model.CursoEAD;
import model.CursoPresencial;

public class MainFase2 {
    public static void main(String[] args) {

        System.out.println("\n FASE 2 – Herança e Especialização ");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        CursoEAD ead = new CursoEAD("Java Avançado", "EAD001", 100, "Rocketseat");
        CursoPresencial pres = new CursoPresencial("Banco de Dados", "PRES001", 80, "Sala 204");

        System.out.println(ead.detalharCurso());
        System.out.println(pres.detalharCurso());
    }
}
