<?php
//AQUI CREAMOS LA LLAVE PARA LA BASE DE DATOS

// Creamos la conexión
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "krypton_inventory";

// Pasamos los datos a un nuevo objeto de conexion
$conn = new mysqli($servername, $username, $password, $dbname);


//connect_error es un metodo y -> funciona como el .
if($conn->connect_error){
    die("Error de conexion: " . $conn->connect_error);
}


/*
echo "Antes de morir";

die("Se detuvo el script aquí.");

echo "Esto nunca se ejecutará"; // ❌ No se muestra
*/
?>