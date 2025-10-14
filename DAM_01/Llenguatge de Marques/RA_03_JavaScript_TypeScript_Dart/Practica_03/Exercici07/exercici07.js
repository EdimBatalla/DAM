// Llista de tasques
var tasques = [];
// Funció per afegir una tasca a la llista
function afegirTasca(nom) {
    var novaTasca = {
        id: tasques.length + 1, // Generem un ID basat en la longitud de la llista
        nom: nom,
        completada: false // Les tasques afegides per defecte no estan completades
    };
    tasques.push(novaTasca);
    console.log("Tasca afegida: ".concat(novaTasca.nom));
}
// Funció per marcar una tasca com a completada
function marcarCompletada(id) {
    var tasca = tasques.find(function (t) { return t.id === id; });
    if (tasca) {
        tasca.completada = true;
        console.log("Tasca ".concat(tasca.nom, " completada."));
    }
    else {
        console.log("No s'ha trobat la tasca amb ID ".concat(id, "."));
    }
}
// Funció per mostrar totes les tasques
function mostrarTasques() {
    if (tasques.length === 0) {
        console.log("No hi ha tasques a mostrar.");
    }
    else {
        tasques.forEach(function (tasca) {
            console.log("ID: ".concat(tasca.id, ", Nom: ").concat(tasca.nom, ", Completada: ").concat(tasca.completada));
        });
    }
}
// Exemple d'ús
afegirTasca("Comprar llet");
afegirTasca("Estudiar TypeScript");
mostrarTasques();
marcarCompletada(1);
mostrarTasques();
