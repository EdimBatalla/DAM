<congoms>{for $cognom in distinct-values(
  (doc("libros.xml")//autor/apellido, doc("libros.xml")//editor/apellido)
)
order by $cognom
return <cognom>{$cognom}</cognom>
}</congoms>