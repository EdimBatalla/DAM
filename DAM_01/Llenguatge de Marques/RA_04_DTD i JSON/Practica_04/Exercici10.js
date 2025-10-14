const llibre = {
    títol: "El nom del vent",
    autor: "Patrick Rothfuss",
    any: 2007,
    categories: ["Fantasia", "Aventura", "Ficció"]
};

// Convertim l'objecte a una cadena JSON
const jsonLlibre = JSON.stringify(llibre);

console.log(jsonLlibre);
