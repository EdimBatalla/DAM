var Forma;
(function (Forma) {
    Forma["Cercle"] = "Cercle";
    Forma["Quadrat"] = "Quadrat";
    Forma["Rectangle"] = "Rectangle";
})(Forma || (Forma = {}));
function calcularArea(forma, dimensions) {
    switch (forma) {
        case Forma.Cercle:
            if (dimensions.length !== 1) {
                throw new Error("El cercle necessita només una dimensió: el radi");
            }
            var radi = dimensions[0];
            return Math.PI * Math.pow(radi, 2);
        case Forma.Quadrat:
            if (dimensions.length !== 1) {
                throw new Error("El quadrat necessita només una dimensió: el costat.");
            }
            var costat = dimensions[0];
            return costat * costat;
        case Forma.Rectangle:
            if (dimensions.length !== 2) {
                throw new Error("El rectangle necessita dues dimensions: base i alçada");
            }
            var base = dimensions[0], alçada = dimensions[1];
            return base * alçada;
        default:
            throw new Error("Forma no reconeguda");
    }
}
function exemple() {
    var formes = [
        { forma: Forma.Cercle, dimensions: [5] },
        { forma: Forma.Quadrat, dimensions: [4] },
        { forma: Forma.Rectangle, dimensions: [6, 3] }
    ];
    formes.forEach(function (_a) {
        var forma = _a.forma, dimensions = _a.dimensions;
        try {
            var area = calcularArea(forma, dimensions);
            console.log("L'\u00E0rea del ".concat(forma, " amb dimensions ").concat(dimensions.join(", "), " \u00E9s: ").concat(area.toFixed(2)));
        }
        catch (error) {
            console.error("Error calculant l'\u00E0rea del ".concat(forma, ": ").concat(error.message));
        }
    });
}
exemple();
