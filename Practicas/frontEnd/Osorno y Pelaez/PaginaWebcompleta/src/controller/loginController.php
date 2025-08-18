<?php
//0 Iniciamos con session_star(): Esto nos sirve para recordar al usuario
session_start();

//requiere_once sirve para traer un archivo antes de que se carge este archivo
require_once '../../config/db_config.php';

//Vamos a verificar si el formulario es exitoso

//$_SERVER["REQUEST_METHOD"] SIRVE PARA VERIFICAR SI EL METODO LLEGO TIPO POST,...
if($_SERVER["REQUEST_METHOD"] == "POST"){
    // Con _POST podemos acceder a una etiqueta en HTML
    $email = $_POST['email'];
    $password = $ $_POST['password'];

     // a) Escribimos la consulta SQL con un marcador de posición (?) para el dato variable.
    $sql = "SELECT id, nombre_completo, password FROM trabajadores WHERE email = ?";

    // b) Preparamos la consulta. El objeto $conn (de db_config.php) crea una plantilla segura.
    $stmt = $conn->prepare($sql);

    // c) Vinculamos la variable $email al marcador de posición.
    // La "s" indica que el dato que estamos pasando es un String (texto).
    $stmt->bind_param("s",$email);

    //Ejecutamos la consulta
    $stmt->execute();

    // Despues de ejecutar la consulta
    // Obtenemos el resultado 

    $result = $stmt->get_result();

    // Verificamos si la consulta encontró exactamente
    // una UNA fila (usuario)
    //num_rows devuelve las numero de filas en la consulta
    if($result->num_rows == 1){
        // Si encontro un usuario, obtenemos sus datos
        $trabajador = $result->fetch_assoc();
        //IMPORTANTE: Verificamos la contraseña
        if(password_verify($password, $trabajador['password'])){
            // Contraseña correcta --> login exitoso
            
            // Guardamos la información del trabajador en la sesión para usarla en otras páginas.
            $_SESSION['trabajador_id'] = $trabajador['id'];
            $_SESSION['trabajador_nombre'] = $trabajador['nombre_completo'];
            // Redirigimos al usuario al dashboard.
            // NOTA: La ruta debe ser relativa a la ubicación del controlador
            header("../view/dashboard.php");
            //header sirve para redirigir a otra pagina
            exit(); //detebemos el script
        }else{
            //Contraseña incorrecta
            $_SESSION['error_login'] = "La contraseña es incorrecta";
            header("../../public/login.php");
            // Importante: header Siempre debe ir antes de que se envíe cualquier HTML.
            exit();
        }
    }else{
        // No se encontró ningún trabajador con ese email
        $_SESSION['error_login'] = "No se encontró correo electronico";
        header("../../public/login.php");
        exit();
    }

    // Cerramos la sentencia preparada 

    $stmt->close();
}

// Cerramos la conexión a la BD

$conn->close();
?>