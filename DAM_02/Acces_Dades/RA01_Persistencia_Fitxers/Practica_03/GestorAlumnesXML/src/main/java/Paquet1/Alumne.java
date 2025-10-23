package Paquet1;

import java.io.Serializable;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nom", "cognom", "edat", "nota"})
public class Alumne implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String cognom;
    private int edat;
    private double nota;

    public Alumne() {}

    public Alumne(String nom, double nota) {
        this.nom = nom;
        this.nota = nota;
    }

    public Alumne(String nom, String cognom, int edat, double nota) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.nota = nota;
    }

    // getters i setters...

    @Override
    public String toString() {
        return nom + " " + cognom + " (" + edat + " anys) - " + nota;
    }
}