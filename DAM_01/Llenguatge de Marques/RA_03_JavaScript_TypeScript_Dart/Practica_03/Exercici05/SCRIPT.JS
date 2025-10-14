//En aquesta primera linea hem creat una array amb els noms
let noms = ['Joan', 'Anna', 'Pau'];
//Afegim esdeveniments als botons utilitzant addEventListener. Quan es fa click a un botó es mostra l'alerta corresponent.
document.getElementById('saludaJoan').addEventListener("click",function() {
    alert ("Hola" +noms[0] +"!");
});
document.getElementById('saludaAnna').addEventListener("click",function() {
    alert ("Hola" +noms[1] +"!");
});
document.getElementById('saludaPau').addEventListener("click",function() {
    alert ("Hola" +noms[2] +"!");
});
//A la següent linea de codi seleccionem l'element HTML "missatge" i amb la seguent linea actualitzem el contingut del element (paragraf)
let paragraf = document.getElementById('missatge');
paragraf.textContent = 'Missatge Actualitzat!';
//A les seguents lineas creem un array amb els colors. Obtenim la referencia del HTML "llista" i al botó per esborrar els colors.  
let colors = ['vermell', 'verd', 'blau','groc'];
let llista = document.getElementById("llista");
let esborraLlistaBtn = document.getElementById("esborraLlista");
//afegim els colors 
colors.forEach((color) => {
    let element = document.createElement("li")
    element.textContent = color;
    llista.appendChild(element);
});
//esborrar elements de la llista utilitzant un bucle while per eliminar tots els elements finsd que la llista estigui totalment buida.
esborraLlistaBtn.addEventListener("click", () => {
    while (llista.firstChild) {
        llista.removeChild(llista.firstChild);
    }
});