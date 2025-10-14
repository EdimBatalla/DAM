//Definim les tres formes geomètriques
enum Forma {
    Cercle = "Cercle",
    Quadrat = "Quadrat",
    Rectangle = "Rectangle"
}
//afegim dos arguments forma i dimensions per la funció calcularArea.
function calcularArea(forma: Forma, dimensions: number[]): number {
//utilitzem un switch per aplicar la fórmula adequada segons la forma    
    switch (forma) {
        case Forma.Cercle:
            if (dimensions.length !== 1) {
                throw new Error("El cercle necessita només una dimensió: el radi");
            }
            const radi = dimensions[0];
            return Math.PI * Math.pow(radi, 2);

        case Forma.Quadrat:
            if (dimensions.length !== 1) {
                throw new Error("El quadrat necessita només una dimensió: el costat.");
            }
            const costat = dimensions[0];
            return costat * costat;

        case Forma.Rectangle:
            if (dimensions.length !== 2) {
                throw new Error("El rectangle necessita dues dimensions: base i alçada");
            }
            const [base, alçada] = dimensions;
            return base * alçada;
        default:
            throw new Error("Forma no reconeguda");
    }
}
//Definim una llista amb les dimensions de cada forma
function exemple(): void {
    const formes: { forma: Forma; dimensions: number[] }[] = [
        { forma: Forma.Cercle, dimensions: [5] },       
        { forma: Forma.Quadrat, dimensions: [4] },      
        { forma: Forma.Rectangle, dimensions: [6, 3] }  
    ];
//Obtenim les propietats de cada element de l'array formes, fem que es calculo l'àrea de la forma corresponent, i utilitzem el console.log per mostrar el resultat per pantalla
    formes.forEach(({ forma, dimensions }) => {
        try {
            const area = calcularArea(forma, dimensions);
            console.log(`L'àrea del ${forma} amb dimensions ${dimensions.join(", ")} és: ${area.toFixed(2)}`);
        } catch (error) {
            console.error(`Error calculant l'àrea del ${forma}: ${(error as Error).message}`);
        }
    });
}

exemple();