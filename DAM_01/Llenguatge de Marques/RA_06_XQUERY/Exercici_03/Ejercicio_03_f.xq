<titulos>{
for $titulo in doc("libros.xml")//libro/titulo
return <libro titol="{$titulo/text()}"/>
}</titulos>