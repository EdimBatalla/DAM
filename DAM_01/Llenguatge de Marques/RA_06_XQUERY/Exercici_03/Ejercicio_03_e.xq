<llibres>{
for $llibre in doc("libros.xml")//libro
order by string-length(normalize-space($llibre/titulo))
return
  <llibre>
    <titol>{$llibre/titulo/text()}</titol>
    {
      for $autor in $llibre/autor
      return <autor>{concat($autor/nombre/text(), " ", $autor/apellido/text())}</autor>
    }
  </llibre>
}</llibres>