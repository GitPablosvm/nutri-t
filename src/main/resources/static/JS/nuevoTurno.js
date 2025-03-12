// Función para marcar/desmarcar todos los checkboxes
function toggleAllCheckBoxes() {
    const checkboxes = document.querySelectorAll('.lista-turnos input[type="checkbox"]');
    checkboxes.forEach(checkbox => checkbox.checked = !checkbox.checked);
}

// Función para agregar un nuevo turno (por ahora solo muestra un alert)
function openAddTurnoForm() {
    alert('Agregar turno con administrativo');
    // Aquí podrías abrir un formulario para agregar un nuevo turno.
}
