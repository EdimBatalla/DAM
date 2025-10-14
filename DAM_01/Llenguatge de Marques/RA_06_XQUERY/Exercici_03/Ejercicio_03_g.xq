<cognoms>{
for $cognom in doc("libros.xml")//autor/apellido
return <cognom>{$cognom/text()}</cognom>
}</cognoms>