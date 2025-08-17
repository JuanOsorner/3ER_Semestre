<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Trabajador - Krypton Inventory</title>
    <link rel="stylesheet" href="../model/css/style.css">
</head>
<body class="dashboard-body">

    <?php 
        // Incluimos los componentes reutilizables para que JS pueda acceder a las plantillas
        include '../library/contenidoHTML.php'; 
    ?>

    <div class="main-layout">
        <?php include '../library/siderbarW.php'; ?>

        <main id="content">
            <header class="content-header">
                <h1>Panel de Tareas</h1>
                <p>Gestiona aquí el mantenimiento de los equipos asignados.</p>
            </header>
            
            <div class="kanban-board">
                <div class="kanban-column">
                    <h3 class="column-header">Pendientes</h3>
                    <div class="tasks-list" id="pending-tasks">
                        <div class="task-card" draggable="true" data-task-id="1">
                            <h4 class="task-title">Reemplazo de Teclado</h4>
                            <p class="task-details">Equipo: Dell XPS 15</p>
                            <div class="task-actions">
                                <button class="btn-task edit-task">Editar</button>
                                <button class="btn-task delete-task">Eliminar</button>
                            </div>
                        </div>
                    </div>
                    <button class="btn-add-task" data-column="pending">+ Nueva Tarea</button>
                </div>

                <div class="kanban-column">
                    <h3 class="column-header">En Progreso</h3>
                    <div class="tasks-list" id="progress-tasks">
                         </div>
                    <button class="btn-add-task" data-column="progress">+ Nueva Tarea</button>
                </div>

                <div class="kanban-column">
                    <h3 class="column-header">Completadas</h3>
                    <div class="tasks-list" id="completed-tasks">
                         </div>
                </div>
            </div>
        </main>
    </div>
    
    </body>
</html>