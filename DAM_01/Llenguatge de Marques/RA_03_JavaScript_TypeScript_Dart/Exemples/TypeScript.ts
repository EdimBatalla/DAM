//  Declaració de variables amb tipus
let nom1: string = 'Joan'; // Una cadena de text
let edat1: number = 30; // Un número
let esActiu: boolean = true; // Un valor booleà

//  Taules i tuples
let colors1: string[] = ['vermell', 'verd', 'blau']; // Un array de cadenes
let registre: [string, number] = ['Anna', 25]; // Una tupla (cadena i número)

//  Enumeracions
enum Direccio {
    Nort,
    Sud,
    Est,
    Oest
}
let direccioFavorita: Direccio = Direccio.Est;

//  Interfícies i objectes
interface Persona {
    nom: string;
    edat: number;
}
let person: Persona = { nom: 'Pau', edat: 35 };

//  Funció amb tipus
function sumar(a: number, b: number): number {
    return a + b;
}

//  Classe orientada a objectes
class Animal {
    nom: string;

    constructor(nom: string) {
        this.nom = nom;
    }

    parla(): string {
        return `L'animal es diu ${this.nom}`;
    }
}

// Crear un animal
let gat = new Animal('Misi');

//  Seleccionem l'element HTML amb l'ID "output" per mostrar-hi els resultats
let outputDiv = document.getElementById('output');

// Verifiquem si s'ha trobat l'element (outputDiv no és null)
if (outputDiv) {
    // Inserim contingut dins del div "output" amb text concatenat per mostrar els resultats
    outputDiv.innerHTML = 
        "<p><b>Variables:</b></p>" +
        "<p>Nom: " + nom1 + "</p>" +
        "<p>Edat: " + edat1 + "</p>" +
        "<p>Es actiu: " + esActiu + "</p>" +

        "<p><b>Taules i tuples:</b></p>" +
        "<p>Colors: " + colors1.join(', ') + "</p>" + // Utilitzem join per mostrar l'array com una cadena
        "<p>Registre: Nom - " + registre[0] + ", Edat - " + registre[1] + "</p>" +

        "<p><b>Enumeracions:</b></p>" +
        "<p>Direcció favorita: " + Direccio[direccioFavorita] + "</p>" +

        "<p><b>Objectes amb interfícies:</b></p>" +
        "<p>Persona: Nom - " + person.nom + ", Edat - " + person.edat + "</p>" +

        "<p><b>Funcions:</b></p>" +
        "<p>5 + 10 = " + sumar(5, 10) + "</p>" +

        "<p><b>Classes:</b></p>" +
        "<p>" + gat.parla() + "</p>";
}
