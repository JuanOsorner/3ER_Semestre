<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - Krypton Inventory</title>
    <link rel="stylesheet" href="../model/css/style.css"> 
</head>
<body>

    <div class="auth-container">
        <div class="auth-wrapper">
            <div class="logo-container">
                <img src="../model/src/logoKrip.png" alt="Logo Krypton Inventory">
            </div>

            <form id="register-form" action="controller/register_controller.php" method="POST">
                <h2>Crear Cuenta</h2>
                
                <div class="input-group">
                    <input type="text" id="fullname" name="fullname" required>
                    <label for="fullname">Nombre Completo</label>
                </div>

                <div class="input-group">
                    <input type="email" id="email" name="email" required>
                    <label for="email">Email</label>
                </div>
                
                <div class="input-group">
                    <input type="password" id="password" name="password" required>
                    <label for="password">Contraseña</label>
                </div>

                <div class="input-group">
                    <input type="password" id="confirm_password" name="confirm_password" required>
                    <label for="confirm_password">Confirmar Contraseña</label>
                </div>
                
                <button type="submit" class="btn">Registrarse</button>
                
                <div class="switch-form">
                    <p>¿Ya tienes una cuenta? <a href="../login.php">Inicia sesión</a></p>
                </div>
            </form>
        </div>
    </div>

</body>
</html>