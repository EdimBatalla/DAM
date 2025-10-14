public class Reparacio {

    private String descripcio;
    private String data;
    private double preu;
    private String estat; // "pendent", "en reparació", "finalitzada"

    public Reparacio(String descripcio, String data, double preu, boolean finalitzada) {
        this.descripcio = descripcio;
        this.data = data;
        this.preu = preu;
        this.estat = finalitzada ? "finalitzada" : "pendent";
    }

    // Constructor alternatiu per estat directe (opcional)
    public Reparacio(String descripcio, String data, double preu, String estat) {
        this.descripcio = descripcio;
        this.data = data;
        this.preu = preu;
        this.estat = estat;
    }

    // Getters i Setters
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return "Descripció: " + descripcio +
               " | Data: " + data +
               " | Preu: " + preu +
               "€ | Estat: " + estat;
    }
}
