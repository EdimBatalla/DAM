for $llibre in doc("libros.xml")//libro
where count($llibre/autor) > 2
order by $llibre/titulo
return $llibre