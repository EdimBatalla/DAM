public class Cotxe {
    private int id;
    private String marca;
    private String model;
    private int idClient;

    public Cotxe(int id, String marca, String model, int idClient) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.idClient = idClient;
    }

    // Getters (i opcionalment setters)
    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getModel() { return model; }
    public int getIdClient() { return idClient; }

    @Override
    public String toString() {
        return id + " - " + marca + " " + model + " (Client ID: " + idClient + ")";
    }
}