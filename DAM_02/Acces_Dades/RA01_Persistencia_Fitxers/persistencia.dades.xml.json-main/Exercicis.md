# Objectiu: aprendre a persistir dades en XML i JSON utilitzant Java (JAXB i Gson).
## Requisits previs
Els alumnes han de disposar del projecte amb el gestor d'alumnes en CSV i la classe Alumne. També s'assumeix coneixement bàsic de Java i Maven.

### Exercici 1 — Exportar alumnes a XML
Llegir la llista d'alumnes (des de .dat o CSV) i exportar-la a alumnes.xml amb JAXB.
### Exercici 2 — Llegir alumnes des d'XML
Llegir alumnes.xml amb JAXB i mostrar per pantalla la llista d'alumnes.
### Exercici 3 — Filtrar aprovats
Crear aprovats.xml amb els alumnes amb nota >= 5 i ordenar per nota descendent.
### Exercici 4 — Actualitzar nota
Demana el nom d'un alumne i una nova nota; modifica l'XML i reescriu-lo.
### Exercici 5 — Importar CSV  XML
Llegir alumnes.csv (Nom,Cognom,Edat,Nota) i afegir els alumnes al alumnes.xml existent.
### Exercici 6 — Exportar a JSON
Exporta la mateixa llista a alumnes.json amb Gson (pretty print).
### Exercici 7 — Llegir des de JSON i cercar
Llegeix alumnes.json i implementa una cerca per nom que mostri l'alumne trobat.
### Exercici 8 — Comparativa XML vs JSON
Exporta la mateixa llista a XML i JSON; compara mida de fitxers i llegibilitat i respon quin format
triaries per una API REST i per una configuració d'empresa?
## Pistes generals
#### 1 Per XML utilitzeu JAXB: anotar la classe Alumne amb @XmlRootElement i crear una classe wrapper per la llista.
#### 2 Per JSON utilitzeu Gson: toJson() per exportar i fromJson() amb TypeToken per llistes.
#### 3 Manageu les excepcions IO i comprovar existència de fitxers abans de llegir.
#### 4 Per reescriure fitxers (actualitzar/eliminar) carregueu tota la llista a memòria, modifiqueu-la i torneu a escriure el fitxer.
## Format de lliurament
#### Entregueu un informe explicant cada exercici com l’heu resol, amb els fitxers alumnes.xml i alumnes.json generats i el codi font de les classes Java que heu modificat o creat. Cal explicar/ comentar el codi.