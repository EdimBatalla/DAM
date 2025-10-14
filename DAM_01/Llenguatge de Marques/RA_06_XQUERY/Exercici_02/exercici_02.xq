for $r at $i in //recepta
return (
  concat("INSERT INTO recepta (titol, temps, imagen) VALUES ('",
         replace($r/titol, "'", "''"), "', '",
         replace($r/temps, "'", "''"), "', '",
         replace($r/imagen, "'", "''"), "');"),
  for $ing in $r/ingredients/ingredient
  return concat("INSERT INTO ingredient (id_recepta, nom) VALUES (", $i, ", '", replace($ing, "'", "''"), "');")
)