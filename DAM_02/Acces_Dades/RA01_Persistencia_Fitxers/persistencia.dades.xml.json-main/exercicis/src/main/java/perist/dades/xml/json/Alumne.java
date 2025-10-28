package perist.dades.xml.json;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Alumne implements Serializable{//Clase alumne serialitzable
    public String nom;
    public double nota;
    public Alumne() {
    } // Constructor buit per JAXB
    public Alumne(String nom, double nota) {
    this.nom = nom;
    this.nota = nota;
    }
    @Override
    public String toString() {
    return nom + " (" + nota + ")";
    }
}
