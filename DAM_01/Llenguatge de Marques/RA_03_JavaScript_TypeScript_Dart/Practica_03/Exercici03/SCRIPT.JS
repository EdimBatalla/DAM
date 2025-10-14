//definim la variable nota utilitzant un let i les operacions MathRandom() que genera un numero decimal aleatori entre 0 i 1. el multipliquem x 10 ja que volem notes del 1 al 10 i la operació Math.floor() serveix per arrodonir sense decimals.
let nota = Math.floor(Math.random()*10 );
console.log(nota);
//amb el condicional if (nota<=4) declarem que qualsevol nota igual o menor de 4 la consola ens mostrarà la paruala Insuficient.
if (nota <= 4) {
    console.log('Insuficient');
} 
//amb el condicional if (nota == 5) declarem que si la nota es igual a 5 la consola mostrarà la paraula Suficient.
if (nota == 5) {
    console.log('Suficient');
}
//amb el condicional if (nota == 6) declarem que si la nota es igual a 6 la consola mostrarà la paraula Bé.
if (nota == 6) {
    console.log('Bé');
}
//amb el condicional if (nota >= 7 && nota < 9) declarem que si la nota es més gran o igual a 7 i menor que 9 la consola mostrarà la paraula Notable.
if (nota >= 7 && nota < 9) {
    console.log('Notable');
}
//amb el condicional if (nota >= 9) declarem que si la nota es igual o major a 9 la consola mostrarà la paraula Excel·lent.
if (nota >= 9) {
    console.log('Excel·lent')
}