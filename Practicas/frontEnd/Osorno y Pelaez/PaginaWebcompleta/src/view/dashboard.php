<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Krypton Inventory</title>
    <link rel="stylesheet" href="../../public/assets/css/style.css">
</head>
<body class="dashboard-body"> <div class="main-layout">
        <?php include '../../src/view/library/siderbar.php'; ?>

        <main id="content">
            <header class="content-header">
                <h1>Registrar Nuevo Equipo</h1>
                <p>Completa la información detallada del computador a continuación.</p>
            </header>
            
            <div class="form-container">
                <form action="controller/equipo_controller.php" method="POST" enctype="multipart/form-data">
                    
                    <div class="form-grid">
                        <div class="grid-column">
                            <div class="input-group">
                                <input type="text" id="nombre_equipo" name="nombre_equipo" required>
                                <label for="nombre_equipo">Nombre del Equipo (Ej: Dell Latitude 5420)</label>
                            </div>

                            <div class="input-group">
                                <input type="text" id="cedula_ingresa" name="cedula_ingresa" required>
                                <label for="cedula_ingresa">Cédula de quien entrega</label>
                            </div>

                            <div class="input-group">
                                <input type="text" id="nombre_recibe" name="nombre_recibe" required>
                                <label for="nombre_recibe">Nombre de quien recibe</label>
                            </div>

                             <div class="input-group file-upload">
                                <div class="file-upload-wrapper">
                                    <!--ESTUDIAR ESTA ETIQUETA-->
                                    <input type="file" id="foto_equipo" name="foto_equipo" accept="image/*" required>
                                    <label for="foto_equipo" class="file-upload-label">
                                        <span class="file-upload-icon">&#128247;</span> <span class="file-upload-text">Seleccionar una imagen...</span>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="grid-column">
                            <div class="checklist-container">
                                <h4>Checklist de Estado</h4>
                                <div class="check-item">
                                    <input type="checkbox" id="check1" name="checklist[]" value="enciende">
                                    <label for="check1">¿El equipo enciende correctamente?</label>
                                </div>
                                <div class="check-item">
                                    <input type="checkbox" id="check2" name="checklist[]" value="pantalla_ok">
                                    <label for="check2">¿La pantalla no tiene daños visibles?</label>
                                </div>
                                <div class="check-item">
                                    <input type="checkbox" id="check3" name="checklist[]" value="carcasa_ok">
                                    <label for="check3">¿La carcasa no presenta golpes o fisuras?</label>
                                </div>
                                <div class="check-item">
                                    <input type="checkbox" id="check4" name="checklist[]" value="cargador">
                                    <label for="check4">¿Se entrega con cargador original?</label>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="signatures-container">
                        <div class="signature-pad">
                            <label for="firma_usuario">Firma de quien entrega</label>
                            <canvas id="firma_usuario" class="signature-canvas"></canvas>
                        </div>
                        <div class="signature-pad">
                            <label for="firma_receptor">Firma de quien recibe</label>
                            <canvas id="firma_receptor" class="signature-canvas"></canvas>
                        </div>
                    </div>
                    
                    <button type="submit" class="btn">Registrar Equipo</button>
                </form>
            </div>
        </main>
    </div>
    
    </body>
</html>