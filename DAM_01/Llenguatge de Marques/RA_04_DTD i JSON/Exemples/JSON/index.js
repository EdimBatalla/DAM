
//Creem objecte Javascript NO JSON
const user = {
    nom:"Joan",
    cognom:"Lopez",
    edat:20,
    nickname:"SuperLopez",
    hobbies:["viatjar","córrer","futbol"],
    adreca:{
        direcció:"Bemen 3",
        ciutat:"Barcelona"
    } ,
    casat:true,
    //JSON no suporta tots els tipus de Javascript, per exemple
    salutacio() {
        return 'hola';
    }
}
console.log(user);

//Podem accedir a qualsevol element de l'objecte Javascript
console.log(user.nom);
console.log(user.hobbies);
console.log(user.adreca.ciutat);
console.log(user.salutacio());

//Ara el volem crear a un objecte JSON

let userJson = JSON.stringify(user);
console.log(userJson);

//volem afegir que l'usuari tingui una llista de contactes

const contactes = [
    {nom:"David", nickname:"David123"},
    {nom:"Miquel", nickname:"Miki123"},
    {nom:"Maria", nickname:"Maria123"}
]

console.log(contactes);
//veiem conversió JSON
let contactesJson = JSON.stringify(contactes);
console.log(contactesJson);

//afegim els contactes crean una nova propietat a l'objecte user
user.contactes = contactes;
let userJson2 = JSON.stringify(user);
console.log(userJson2);


//mostrem els contactes en l'html amb la llista agendaContactes

let stringSortida = '';

//recorrem l'array de contactes per crear la llista de contactes en format html
for(let i=0; i<contactes.length; i++){
    stringSortida = stringSortida + '<li>' + contactes[i].nom + '</li>'
}

//insertem el string de sortida al document html per fer la llista html seleccionant la llista amb getElementById (DOM)

document.getElementById('agendaContactes').innerHTML = stringSortida;


//Conversió JSON a javascript amb parse
let StringJSON = '{"nom":"Joan","cognom":"Lopez","edat":20,"nickname":"SuperLopez","hobbies":["viatjar","córrer","futbol"],"adreca":{"direcció":"Bemen 3","ciutat":"Barcelona"},"casat":true}';
let userJs = JSON.parse(StringJSON);
console.log(userJs);

let elements = '';

//Exportar dades d'un altre servidor amb fetch 
fetch('https://jsonplaceholder.typicode.com/users')
    //Si hi ha resposta la mostrem per pantalla del terminal, sempre millor carregar primer el document i després utilitzar-lo
    .then (response => {
        //obtenim la resposta utilitzant la funció json()
        return response.json();
    })
     //les dades obtingudes les mostrem per terminal i creem llista per mostrarho al html
    .then (data => {
        console.log(data);
        for(let i=0; i<data.length; i++){
            elements = elements + '<li>' + data[i].name + '</li>'
        }
        document.getElementById('persones').innerHTML = elements;
    })
    //posem les dades rebudes a la llista html persones


    //En cas d'error al obtenir o mostrar les dades capturem i mostrem l'error
    .catch (error => {
        console.error('Error', error);
    })