// Classe que representa un producte d'una botiga
class Producte {
  nom: string;
  preu: number;
  stock: number;

  constructor(nom: string, preu: number, stock: number) {
    this.nom = nom;
    this.preu = preu;
    this.stock = stock;
  }
}

// Classe que gestiona els productes
class GestioProductes {
  productes: Producte[];

  constructor() {
    this.productes = [];
  }

  // Afegir un producte
  afegirProducte(producte: Producte): void {
    this.productes.push(producte);
  }

  // Actualitzar el stock d'un producte
  actualitzarStock(nom: string, nouStock: number): void {
    let producteTrobat = false;

    // Busquem el producte pel seu nom
    for (let i = 0; i < this.productes.length; i++) {
      if (this.productes[i].nom === nom) {
        // Actualitzem el stock
        this.productes[i].stock = nouStock;
        producteTrobat = true;
        break;
      }
    }

    // Condicional per verificar si s'ha trobat el producte
    if (!producteTrobat) {
      console.log("El producte amb nom \"" + nom + "\" no existeix.");
    }
  }

  // Mostrar tots els productes disponibles
  mostrarProductes(): void {
    if (this.productes.length === 0) {
      console.log("No hi ha productes disponibles.");
      return;
    }

    console.log("Llistat de productes disponibles:");
    let i = 0;
    // Utilitzant el bucle while per mostrar els productes
    while (i < this.productes.length) {
      const producte = this.productes[i];
      console.log("Nom: " + producte.nom + ", Preu: " + producte.preu + "€, Stock: " + producte.stock);
      i++;
    }
  }
}

// Exemple d'ús

const gestio = new GestioProductes();

// Afegir productes
gestio.afegirProducte(new Producte("Portàtil", 1500, 10));
gestio.afegirProducte(new Producte("Smartphone", 800, 20));

// Actualitzar el stock del producte "Portàtil"
gestio.actualitzarStock("Portàtil", 8);

// Mostrar els productes disponibles
gestio.mostrarProductes();
