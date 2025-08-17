<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Perfil - Krypton Inventory</title>
    <link rel="stylesheet" href="../model/css/style.css">
</head>
<body class="dashboard-body">

    <div class="main-layout">
        <?php include '../library/siderbarW.php'; ?>

        <main id="content">
            <header class="content-header">
                <h1>Editar Perfil</h1>
                <p>Actualiza tu información personal y estado laboral.</p>
            </header>
            
            <form class="profile-form">
                <div class="profile-grid">
                    <div class="profile-picture-col">
                        <h4>Foto de Perfil</h4>
                        <div class="profile-picture-preview">
                            <img src="path/to/default-avatar.png" id="profile-img-preview">
                            <label for="profile-picture-upload" class="picture-upload-overlay">
                                <span>&#128247;</span>
                            </label>
                            <input type="file" id="profile-picture-upload" name="profile_picture" accept="image/*">
                        </div>
                    </div>

                    <div class="profile-data-col">
                        <h4>Datos Personales</h4>
                        <div class="input-group">
                            <input type="text" id="fullname" name="fullname" value="Carlos Ramírez" required>
                            <label for="fullname">Nombre Completo</label>
                        </div>
                        <div class="input-group">
                            <input type="email" id="email" name="email" value="carlos.ramirez@krypton.inv" required>
                            <label for="email">Email</label>
                        </div>
                        <div class="input-group">
                            <input type="tel" id="phone" name="phone" value="300-123-4567">
                            <label for="phone">Teléfono</label>
                        </div>

                        <h4>Estado Laboral</h4>
                        <div class="status-toggle-group">
                             <label class="status-toggle">
                                <input type="checkbox" id="work-status" name="work_status" checked>
                                <span class="slider"></span>
                             </label>
                             <span id="status-label">Activo</span>
                        </div>
                    </div>
                </div>

                <div class="profile-actions">
                    <button type="submit" class="btn">Guardar Cambios</button>
                </div>
            </form>
        </main>
    </div>
</body>
</html>