<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Krypton Inventory</title>
    <link rel="stylesheet" href="../../../public/assets/css/style.css"> 
</head>
<body>

    <div class="auth-container">
        <div class="auth-wrapper">
            <div class="logo-container">
                <img src="../../../public/assets/img/logoKrip.png" alt="Logo Krypton Inventory">
            </div>

            <form id="login-form" action="controller/login_controller.php" method="POST">
                <h2>Iniciar Sesión</h2>
                
                <div class="input-group">
                    <input type="text" id="username" name="username" required>
                    <label for="username">Usuario o Email</label>
                </div>
                
                <div class="input-group">
                    <input type="password" id="password" name="password" required>
                    <label for="password">Contraseña</label>
                </div>
                
                <div class="form-options">
                    <div class="remember-me">
                        <input type="checkbox" id="remember" name="remember">
                        <label for="remember">Recordarme</label>
                    </div>
                    <a href="#" class="forgot-password">¿Olvidaste tu contraseña?</a>
                </div>
                
                <button type="submit" class="btn">Ingresar</button>
                
                <div class="switch-form">
                    <p>¿No tienes una cuenta? <a href="../../view/auth/registro.php">Regístrate</a></p>
                </div>
            </form>
        </div>
    </div>

</body>
</html>