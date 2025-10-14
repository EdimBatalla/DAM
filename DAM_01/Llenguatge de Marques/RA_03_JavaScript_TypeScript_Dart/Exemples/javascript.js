  // Variables y tipos de dades
var nom = 'Joan';
console.log('Nom:', nom);

let numero = 42;
let flotant = 3.14;
let salutacio = 'Hola';
let esVeritat = true;
let colors = ['vermell', 'verd', 'blau'];
let persona = { nom: 'Joan', edat: 30 };

console.log('Numero:', numero);
console.log('Flotant:', flotant);
console.log('Salutació:', salutacio);
console.log('Es veritat:', esVeritat);
console.log('Array Colors:', colors);
console.log('Persona:', persona);

// Operadors
let suma = 5 + 3;
let producte = 4 * 2;
let a = 10;
a += 5;
let esIgual = (5 == '5');
let esEstrictamentIgual = (5 === '5');
let resultat = (5 > 3 && 2 < 4);

console.log('Suma:', suma);
console.log('Producte:', producte);
console.log('A després de += 5:', a);
console.log('5 == "5":', esIgual);
console.log('5 === "5":', esEstrictamentIgual);
console.log('Resultat de (5 > 3 && 2 < 4):', resultat);

// Estructures de control
let edat = 20;
if (edat > 18) {
    console.log('Ets un adult');
} else {
    console.log('Ets menor d edat');
}

for (let i = 0; i < 10; i++) {
    console.log('For loop, i:', i);
}

let i = 0;
while (i < 10) {
    console.log('While loop, i:', i);
    i++;
}


  
  document.addEventListener('DOMContentLoaded', function() {
            console.log('Document carregat');

            // Funció per mostrar una alerta
            function mostrarAlerta() {
                alert('Botó clickat');
            }

            // Afegir esdeveniment al botó
            document.getElementById('ElMeuBoto').addEventListener('click', mostrarAlerta);

            // Mostrar text del input
            document.getElementById('mostrarText').addEventListener('click', function() {
                let inputText = document.getElementById('miInput').value;
                alert('Has escrit: ' + inputText);
            });

            // Canviar color del h1
            document.getElementById('canviarColor').addEventListener('click', function() {
                let colors = ['red', 'green', 'blue', 'yellow', 'purple'];
                let colorAleatori = colors[Math.floor(Math.random() * colors.length)];
                document.getElementById('ElmeuElement').style.color = colorAleatori;
            });

            // Afegir element a la llista
            document.getElementById('afegirElement').addEventListener('click', function() {
                let nouElement = document.createElement('li');
                nouElement.textContent = 'Nou color';
                document.getElementById('llistaColors').appendChild(nouElement);
            });
        });