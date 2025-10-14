<titulos>{
  for $llibre in doc("libros.xml")//libro
  where $llibre/@año = "2000"
  return $llibre/titulo
}</titulos>