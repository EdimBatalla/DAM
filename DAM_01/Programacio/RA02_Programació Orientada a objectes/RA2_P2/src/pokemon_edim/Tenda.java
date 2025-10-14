package pokemon_edim;

import static pokemon_edim.Joc.scanner;

public class Tenda {
	int opcio;

	public void comprar() {
		Pocio pocio = new Pocio("Pocio", 100, 25, 50);
		Pocio superpocio = new Pocio("Superpocio", 100, 50, 90);
		Pocio hiperpocio = new Pocio("Hiperpocio", 100, 200, 300);
		Elixir elixir = new Elixir("Elixir", 100, 10, 200);
		Elixir elixirMax = new Elixir("Elixir Max.", 100, 25, 400);
		Revivir revivir = new Revivir("Revivir", 100, 50, 250);
		Revivir revivirMax = new Revivir("Revivir Max.", 100, 100, 500);
		Pokeball pokeball = new Pokeball("Pokeball", 100, 50, 50);
		Pokeball superball = new Pokeball("Superball", 100, 60, 350);
		Pokeball ultraball = new Pokeball("Ultraball", 100, 75, 600);
		
		do {
		System.out.println("Benvingut a la tenda.");
		System.out.println("Que vols comprar?");
		System.out.println("1. " + pocio.getNom() + " preu: " + pocio.getPreu() +"$");
		System.out.println("2. " + superpocio.getNom() + " preu: " + superpocio.getPreu() +"$");
		System.out.println("3. " + hiperpocio.getNom() + " preu: " + hiperpocio.getPreu() +"$");
		System.out.println("4. " + elixir.getNom() + " preu: " + elixir.getPreu() +"$");
		System.out.println("5. " + elixirMax.getNom() + " preu: " + elixirMax.getPreu() +"$");
		System.out.println("6. " + revivir.getNom() + " preu: " + revivir.getPreu() +"$");
		System.out.println("7. " + revivirMax.getNom() + " preu: " + revivirMax.getPreu() +"$");
		System.out.println("8. " + pokeball.getNom() + " preu: " + pokeball.getPreu() +"$");
		System.out.println("9. " + superball.getNom() + " preu: " + superball.getPreu() +"$");
		System.out.println("10. " + ultraball.getNom() + " preu: " + ultraball.getPreu() +"$");
		System.out.println("11. Sortir");
		opcio=scanner.nextInt();
				
		switch (opcio) {
		case 1:
			jugador.
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		default:
			break;
		}
	} while (opcio!=11) {
		
	
	}
}
}