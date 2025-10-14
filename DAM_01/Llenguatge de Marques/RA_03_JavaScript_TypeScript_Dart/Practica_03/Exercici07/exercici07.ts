// Definició de la interfície per a la tasca
interface Tasca {
    id: number;
    nom: string;
    completada: boolean;
  }
  
  // Llista de tasques
  let tasques: Tasca[] = [];
  
  // Funció per afegir una tasca a la llista
  function afegirTasca(nom: string): void {
    const novaTasca: Tasca = {
      id: tasques.length + 1, // Generem un ID basat en la longitud de la llista
      nom: nom,
      completada: false // Les tasques afegides per defecte no estan completades
    };
    tasques.push(novaTasca);
    console.log(`Tasca afegida: ${novaTasca.nom}`);
  }
  
  // Funció per marcar una tasca com a completada
  function marcarCompletada(id: number): void {
    const tasca = tasques.find(t => t.id === id);
    if (tasca) {
      tasca.completada = true;
      console.log(`Tasca ${tasca.nom} completada.`);
    } else {
      console.log(`No s'ha trobat la tasca amb ID ${id}.`);
    }
  }
  
  // Funció per mostrar totes les tasques
  function mostrarTasques(): void {
    if (tasques.length === 0) {
      console.log("No hi ha tasques a mostrar.");
    } else {
      tasques.forEach(tasca => {
        console.log(`ID: ${tasca.id}, Nom: ${tasca.nom}, Completada: ${tasca.completada}`);
      });
    }
  }
  
  // Exemple d'ús
  afegirTasca("Comprar llet");
  afegirTasca("Estudiar TypeScript");
  mostrarTasques();
  
  marcarCompletada(1);
  mostrarTasques();
  