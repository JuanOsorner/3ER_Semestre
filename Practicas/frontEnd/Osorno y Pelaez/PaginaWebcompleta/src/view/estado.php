<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estado del Equipo - Krypton Inventory</title>
    <link rel="stylesheet" href="../../public/assets/css/style.css">
</head>
<body class="dashboard-body"> <div class="main-layout">
        <?php include '../../src/view/library/siderbar.php'; ?>

        <main id="content">
            <header class="content-header">
                <h1>Estado del Mantenimiento</h1>
                <p>Aquí puedes ver el progreso y los detalles de tu equipo.</p>
            </header>
            
            <div class="status-container">
                
                <div class="status-card info-card">
                    <div class="info-header">
                        <!--TODOS ESTOS DATOS DEBEN CAMBIAR CON LA BD-->
                        <h3>Dell Latitude 5420</h3>
                        <span class="status-badge in-progress">En Mantenimiento</span>
                    </div>
                    <div class="info-grid">
                        <div class="info-item">
                            <span class="info-label">Técnico Encargado</span>
                            <span class="info-value">Carlos Ramírez</span>
                        </div>
                        <div class="info-item">
                            <span class="info-label">Ubicación para Recibir</span>
                            <span class="info-value">Recepción Técnica - Piso 2</span>
                        </div>
                    </div>
                </div>
                <!--TODO ESTO DEBE CAMBIAR CON EL MODULO DE ADMINISTRACIÓN (PARTE TRABAJADOR)-->
                <div class="status-card history-card">
                    <h4>Historial de Cambios y Actualizaciones</h4>
                    <ul class="timeline">
                        <li class="timeline-item">
                            <div class="timeline-dot"></div>
                            <div class="timeline-content">
                                <span class="timeline-date">15 de Agosto, 2025 - 10:30 AM</span>
                                <p>Se completó el diagnóstico inicial. Se detectó una falla en el módulo de memoria RAM.</p>
                            </div>
                        </li>
                        <li class="timeline-item">
                            <div class="timeline-dot"></div>
                            <div class="timeline-content">
                                <span class="timeline-date">14 de Agosto, 2025 - 04:15 PM</span>
                                <p>Equipo recibido en el laboratorio y asignado a un técnico.</p>
                            </div>
                        </li>
                         <li class="timeline-item">
                            <div class="timeline-dot"></div>
                            <div class="timeline-content">
                                <span class="timeline-date">14 de Agosto, 2025 - 04:00 PM</span>
                                <p>Equipo ingresado al sistema.</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </main>
    </div>

</body>
</html>