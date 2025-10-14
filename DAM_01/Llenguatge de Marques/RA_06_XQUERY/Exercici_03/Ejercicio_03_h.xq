<llibres>{
for $llibre in doc("libros.xml")//libro
let $titol := normalize-space($llibre/titulo)
let $comentari := doc("comentarios.xml")//entrada[normalize-space(titulo) = $titol]/comentario
return
  <llibre>
    <titol>{$titol}</titol>
    <comentari>{$comentari/text()}</comentari>
  </llibre>
}</llibres>