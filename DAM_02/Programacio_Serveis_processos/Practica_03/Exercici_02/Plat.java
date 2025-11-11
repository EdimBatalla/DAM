package Exercici_02;

public class Plat {
    private final int id;
    private final String nom;
    private final String cuiner;

    public Plat(int id, String nom, String cuiner) {
        this.id = id;
        this.nom = nom;
        this.cuiner = cuiner;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCuiner() {
        return cuiner;
    }

    @Override
    public String toString() {
        return "Plat{id=" + id + ", nom='" + nom + "', cuiner='" + cuiner + "'}";
    }
}
