//instal·lar node.js https://nodejs.org/
//intal·lar express amb "npm init -y" i després "npm install express"

// Importem el mòdul express i creem una instància de l'aplicació Express.
const express = require('express');
const app = express();

// Aquesta ruta defineix un endpoint /data que respondrà amb un objecte JSON quan es faci una petició GET.
app.get('/data', (req, res) => {
    // Enviem una resposta en format JSON
    res.json({ nom: "Joan", edat: 30 });
});

// Aquí, el servidor es posa en marxa i comença a escoltar peticions al port 3000.
app.listen(3000, () => {
    console.log('Servidor executant-se en el port 3000');
});

//executem servidor amb node index.js
//Provar la API a http://localhost:3000/data
