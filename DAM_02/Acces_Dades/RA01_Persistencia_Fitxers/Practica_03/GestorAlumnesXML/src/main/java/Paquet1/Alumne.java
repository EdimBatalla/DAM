package Paquet1;

import java.io.Serializable;

public class Alumne implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private double nota;

    public Alumne(String nom, double nota) {
        this.nom = nom;
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public double getNota() {

        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' + ", nota=" + nota + ')';
    }

   
}