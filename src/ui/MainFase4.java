package ui;

import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;

public class MainFase4 {

    public static void main(String[] args) {

        System.out.println(" FASE 4 – HERANÇA E POLIMORFISMO ");
        System.out.println("Desenvolvido por: Anderson Willian Jacinto de Jesus\n");

        Curso presencial = new CursoPresencial(
                "Desenvolvimento Back-End",
                "DEV-BE101",
                360,
                "Lab 12 - Bloco B"
        );

        Curso ead = new CursoEAD(
                "Programação Orientada a Objetos",
                "POO-EAD202",
                280,
                "Alura"
        );

        System.out.println(presencial.detalharCurso());
        System.out.println(ead.detalharCurso());
    }
}
