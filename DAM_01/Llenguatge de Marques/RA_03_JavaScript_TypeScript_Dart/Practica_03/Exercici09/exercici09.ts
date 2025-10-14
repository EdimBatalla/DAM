// Funció per afegir informació a la pàgina
function afegirInformacio(): void {
    const nom = (<HTMLInputElement>document.getElementById("nom")).value;
    const numero = (<HTMLInputElement>document.getElementById("numero")).value;
  
    const missatgeElement = document.getElementById("missatge");
    if (nom === "" || numero === "") {
      missatgeElement.innerHTML = "Tots els camps han de ser omplerts.";
      missatgeElement.className = "error";
    } else {
      missatgeElement.innerHTML = "Nom: " + nom + "<br>Número: " + numero;
      missatgeElement.className = "";
    }
  }
  
  // Funció per calcular la suma dels números de 1 fins al número introduït
  function calcularResultat(): void {
    const numero = parseInt((<HTMLInputElement>document.getElementById("numero")).value);
    const missatgeElement = document.getElementById("missatge");
  
    if (isNaN(numero) || numero <= 0) {
      missatgeElement.innerHTML = "Si us plau, introdueix un número positiu.";
      missatgeElement.className = "error";
      return;
    }
  
    let resultat = 0;
    // Bucle for per sumar els números de 1 fins al número indicat
    for (let i = 1; i <= numero; i++) {
      resultat += i;
    }
  
    missatgeElement.innerHTML = "La suma de tots els números fins a " + numero + " és: " + resultat;
    missatgeElement.className = "";
  }
  
  // Funció que utilitza while per mostrar una llista de números fins al número indicat
  function mostrarNumeros(): void {
    const numero = parseInt((<HTMLInputElement>document.getElementById("numero")).value);
    const missatgeElement = document.getElementById("missatge");
  
    if (isNaN(numero) || numero <= 0) {
      missatgeElement.innerHTML = "Si us plau, introdueix un número positiu.";
      missatgeElement.className = "error";
      return;
    }
  
    let i = 1;
    let numeros = "";
    // Bucle while per mostrar números fins a l'input
    while (i <= numero) {
      numeros += i + " ";
      i++;
    }
  
    missatgeElement.innerHTML = "Els números fins a " + numero + " són: " + numeros;
    missatgeElement.className = "";
  }
  
  // Funció que utilitza do...while per mostrar els quadrats dels números fins al número introduït
  function mostrarQuadrats(): void {
    const numero = parseInt((<HTMLInputElement>document.getElementById("numero")).value);
    const missatgeElement = document.getElementById("missatge");
  
    if (isNaN(numero) || numero <= 0) {
      missatgeElement.innerHTML = "Si us plau, introdueix un número positiu.";
      missatgeElement.className = "error";
      return;
    }
  
    let i = 1;
    let quadrats = "";
    // Bucle do...while per mostrar els quadrats dels números fins al número indicat
    do {
      quadrats += (i * i) + " ";
      i++;
    } while (i <= numero);
  
    missatgeElement.innerHTML = "Els quadrats dels números fins a " + numero + " són: " + quadrats;
    missatgeElement.className = "";
  }
  
  // Assignem els esdeveniments als botons
  document.getElementById("afegirBtn")!.addEventListener("click", afegirInformacio);
  document.getElementById("calcularBtn")!.addEventListener("click", calcularResultat);
  