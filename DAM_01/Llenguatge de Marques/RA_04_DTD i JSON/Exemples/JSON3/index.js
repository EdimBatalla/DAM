// Importem Express i jsonwebtoken
const express = require('express');
const jwt = require('jsonwebtoken');

const app = express();
const secretKey = 'secretKey'; // Clau secreta per signar el token
////////////////////////////////////////////////////////////

// Configuració manual de CORS
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*'); // Permet qualsevol origen
    res.header('Access-Control-Allow-Headers', 'Authorization, Content-Type'); // Permet headers específics
    if (req.method === 'OPTIONS') {
        res.header('Access-Control-Allow-Methods', 'GET, POST'); // Permet mètodes específics
        return res.status(200).json({});
    }
    next();
});



/////////////////////////////////////////////

// Middleware per parsejar JSON
app.use(express.json());

// Endpoint per autenticar l'usuari i generar un token JWT
app.post('/login', (req, res) => {
    // Exemple simple d'autenticació
    const { username, password } = req.body;

    console.log('Dades rebudes:', req.body);

    // Aquí podries verificar l'usuari i la contrasenya en una base de dades
    if (username === 'usuari' && password === 'contrasenya') {
        // Si l'autenticació és correcta, generem el token
        const token = jwt.sign({ userId: 1 }, secretKey, { expiresIn: '1h' });

        console.log('Token generat:', token);


        res.json({ token });
    } else {
        res.status(401).json({ error: 'Credencials invàlides' });
    }
});

// Middleware per verificar el token JWT
const authenticateJWT = (req, res, next) => {
    const token = req.header('Authorization');

    console.log('Token rebut:', token);

    if (token) {
        jwt.verify(token, secretKey, (err, decoded) => {
            if (err) {
                return res.status(403).json({ error: 'Token invàlid o caducat' });
            }
            req.user = decoded; // Afegim la informació del token a la petició
            next();
        });
    } else {
        res.status(401).json({ error: 'Autenticació requerida' });
    }
};

// Endpoint protegit que requereix autenticació
app.get('/data', authenticateJWT, (req, res) => {
    // Si l'autenticació és correcta, retornem les dades
    res.json({ nom: "Joan", edat: 30 });
});

// Iniciem el servidor a l'escolta del port 3000
app.listen(3000, () => {
    console.log('Servidor executant-se en el port 3000');
});
