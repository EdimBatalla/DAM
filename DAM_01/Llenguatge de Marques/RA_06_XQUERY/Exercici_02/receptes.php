<?php
// Conexión a la base de datos
$conn = mysqli_connect("localhost", "root", "", "bd_receptes");

if (!$conn) {
    die("Error al conectar con la base de datos: " . mysqli_connect_error());
}

$affectedRow = 0;

// Cargar el archivo XML
$xml = simplexml_load_file("receptes.xml") or die("Error: No se pudo cargar el archivo XML");

// Recorrer cada recepta
foreach ($xml->recepta as $recepta) {
    $titol = mysqli_real_escape_string($conn, $recepta->titol);
    $temps = mysqli_real_escape_string($conn, $recepta->temps);

    // Convertir ingredientes en cadena separada por comas
    $ingredientsArray = [];
    foreach ($recepta->ingredients->ingredient as $ingredient) {
        $ingredientsArray[] = (string)$ingredient;
    }
    $ingredients = mysqli_real_escape_string($conn, implode(", ", $ingredientsArray));

    $imagen = mysqli_real_escape_string($conn, $recepta->imagen);

    // Query SQL para insertar los datos
    $sql = "INSERT INTO receptes (titol, temps, ingredients, imagen)
            VALUES ('$titol', '$temps', '$ingredients', '$imagen')";

    $result = mysqli_query($conn, $sql);

    if (!empty($result)) {
        $affectedRow++;
    } else {
        echo "Error al insertar: " . mysqli_error($conn) . "<br>";
    }
}

mysqli_close($conn);
?>

<h2>Insertar dades del XML a la base de dades</h2>
<?php
if ($affectedRow > 0) {
    echo "<p>$affectedRow receptes inserides correctament.</p>";
} else {
    echo "<p>No s'ha inserit cap recepta.</p>";
}
?>
