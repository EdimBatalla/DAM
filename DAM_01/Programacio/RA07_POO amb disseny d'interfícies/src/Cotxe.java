import java.util.ArrayList;

public class Cotxe {

	private String matricula;
	private String marca;
	private String model;
	private String any;
	private ArrayList<Reparacio> reparacions;

	// constructor
	public Cotxe(String matricula, String model, String marca, String any) {
		this.matricula = matricula;
		this.model = model;
		this.marca = marca;
		this.any = any;
		this.reparacions = new ArrayList<>();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAny() {
		return any;
	}

	public void setAny(String any) {
		this.any = any;
	}

	public ArrayList<Reparacio> getReparacions() {
		return reparacions;
	}

	public void setReparacions(ArrayList<Reparacio> reparacions) {
		this.reparacions = reparacions;
	}

	public String toString() {
		return "Matrícula: " + matricula + " | Marca: " + marca + " | Model: " + model + " | Any: " + any;
	}
	
	public void afegirReparacio(Reparacio reparacio) {
        reparacions.add(reparacio);
        
	}
}
