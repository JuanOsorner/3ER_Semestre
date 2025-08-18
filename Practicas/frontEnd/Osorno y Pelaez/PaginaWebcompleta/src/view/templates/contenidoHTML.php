<div id="toast-container"></div>

<template id="toast-template">
    <div class="toast toast-hide" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-icon"></div>
        <p class="toast-message"></p>
        <button type="button" class="toast-close-btn">&times;</button>
    </div>
</template>

<template id="modal-template">
    <div class="modal-overlay" tabindex="-1">
        <div class="modal-container" role="dialog" aria-modal="true">
            <header class="modal-header">
                <h3 class="modal-title"></h3>
                <button type="button" class="modal-close-btn">&times;</button>
            </header>
            <div class="modal-body">
                </div>
            <footer class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" data-confirm="modal">Confirmar</button>
            </footer>
        </div>
    </div>
</template>

<template id="task-modal-content">
    <form class="task-form">
        <div class="input-group">
            <input type="text" id="task-title" name="task-title" required>
            <label for="task-title">Título de la Tarea</label>
        </div>
        <div class="input-group">
            <label class="textarea-label">Descripción del Problema</label>
            <textarea id="task-problem" name="task-problem" rows="4" placeholder="Detalla el problema reportado por el cliente..."></textarea>
        </div>
        <div class="input-group">
            <label class="textarea-label">Solución Aplicada</label>
            <textarea id="task-solution" name="task-solution" rows="4" placeholder="Describe los pasos que realizaste para solucionarlo..."></textarea>
        </div>
    </form>
</template>