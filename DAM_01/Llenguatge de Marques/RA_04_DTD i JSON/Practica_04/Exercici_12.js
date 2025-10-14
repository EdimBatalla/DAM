// 1. Definim correctament la cadena JSON
const jsonPelicula = `{
    "titol": "Interstellar",
    "director": "Christopher Nolan",
    "any": 2014,
    "actors": ["Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"],
    "duracio": 169
}`;

// 2. Convertim la cadena JSON en un objecte JavaScript
const objectePelicula = JSON.parse(jsonPelicula);

// 3. Mostrem el valor de la propietat "director" a la consola
console.log("Director:", objectePelicula.director);

// 4. Mostrem la llista d'actors a la consola
console.log("Actors:", objectePelicula.actors);