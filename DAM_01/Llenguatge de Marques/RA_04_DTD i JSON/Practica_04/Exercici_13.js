// 1. Fer una petició GET a l'API JSONPlaceholder
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json()) // Convertim la resposta a JSON
    .then(data => {
        // 2. Mostrem a la consola els noms dels usuaris
        data.forEach(user => console.log(user.name));
    })
    .catch(error => console.error("Error en la petició:", error));
