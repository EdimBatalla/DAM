//Aquesta línia imprimex en pantalla el títol on s'hi indica la taula de multiplicar que s'està generant.
console.log("Taula de multiplicar del 7 (for):");
//Es crea un bucle que inicia la variable i amb valor, mentre i sigui menor o igual a 10 el bucle continuarà i s'hi incrementarà el valor de i en 1 després de cada operació.
for (let i = 1; i<=10; i++) {
//Aquesta línia combina "7 x " el valor de la variable i, i el resultat de la multiplicació. 
    console.log("7 X "+i+"="+7*i);

}

//Aquesta línia imprimex en pantalla el títol on s'hi indica la taula de multiplicar que s'està generant.
console.log("Taula de multiplicar del 7 (while):");
//Aquí es declara que la variable i te un valor inicial de 1. Amb aquesta variable es faràs ervir com a comptador per controlar el bucle.
let i = 1; 
//Aquí s'indica que s'executarà el bucle mentre la condició sigui i mes petit o igual a 10
while (i <=10) {
//Aquesta línia combina "7 x " el valor de la variable i, i el resultat de la multiplicació. 
console.log("7 X "+i+"="+7*i);
//Al final de cada operació i s'incrementa en 1 per que pugui continuar el bucle.
i++;
}