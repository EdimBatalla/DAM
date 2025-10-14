// Classe que representa un producte d'una botiga
var Producte = /** @class */ (function () {
    function Producte(nom, preu, stock) {
        this.nom = nom;
        this.preu = preu;
        this.stock = stock;
    }
    return Producte;
}());
// Classe que gestiona els productes
var GestioProductes = /** @class */ (function () {
    function GestioProductes() {
        this.productes = [];
    }
    // Afegir un producte
    GestioProductes.prototype.afegirProducte = function (producte) {
        this.productes.push(producte);
    };
    // Actualitzar el stock d'un producte
    GestioProductes.prototype.actualitzarStock = function (nom, nouStock) {
        var producteTrobat = false;
        // Busquem el producte pel seu nom
        for (var i = 0; i < this.productes.length; i++) {
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
    };
    // Mostrar tots els productes disponibles
    GestioProductes.prototype.mostrarProductes = function () {
        if (this.productes.length === 0) {
            console.log("No hi ha productes disponibles.");
            return;
        }
        console.log("Llistat de productes disponibles:");
        var i = 0;
        // Utilitzant el bucle while per mostrar els productes
        while (i < this.productes.length) {
            var producte = this.productes[i];
            console.log("Nom: " + producte.nom + ", Preu: " + producte.preu + "€, Stock: " + producte.stock);
            i++;
        }
    };
    return GestioProductes;
}());
// Exemple d'ús
var gestio = new GestioProductes();
// Afegir productes
gestio.afegirProducte(new Producte("Portàtil", 1500, 10));
gestio.afegirProducte(new Producte("Smartphone", 800, 20));
// Actualitzar el stock del producte "Portàtil"
gestio.actualitzarStock("Portàtil", 8);
// Mostrar els productes disponibles
gestio.mostrarProductes();
