
const express = require('express');
const jwt = require('jsonwebtoken');
const axios = require('axios');
const open = require('open').default;

const app = express();
const secretKey = 'ClaveSecreta';

app.use(express.json());
app.use(express.static('.'));

app.post('/login', (req, res) => {
    const { usuario, contrasenya } = req.body;
    if (usuario === 'Admin' && contrasenya === '1234') {
        const token = jwt.sign({ user: 'Admin' }, secretKey, { expiresIn: '1h' });
        res.json({ token });
    } else {
        res.status(401).json({ error: 'Credenciales incorrectas' });
    }
});

const authenticateJWT = (req, res, next) => {
    const authHeader = req.headers.authorization;
    if (authHeader) {
        const token = authHeader.split(' ')[1];
        jwt.verify(token, secretKey, (err, decoded) => {
            if (err) return res.status(403).json({ error: 'Token inválido' });
            req.user = decoded;
            next();
        });
    } else {
        res.status(401).json({ error: 'Token no proporcionado' });
    }
};

app.get('/comments', authenticateJWT, async (req, res) => {
    try {
        const response = await axios.get('https://jsonplaceholder.typicode.com/comments');
        res.json(response.data.slice(0, 10));
    } catch (error) {
        res.status(500).json({ error: 'Error al obtener comentarios' });
    }
});

app.listen(3000, () => {
    console.log('Servidor ejecutándose en el puerto 3000');
    open('http://localhost:3000');
});
