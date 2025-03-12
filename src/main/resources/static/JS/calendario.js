document.addEventListener('DOMContentLoaded', function () {
    let profesionalSeleccionado = '';
    let horarioSeleccionado = '';
    let diaSeleccionado = '';

    // Función para seleccionar un profesional con animación
    document.querySelectorAll('.profesional').forEach(function(button) {
        button.addEventListener('click', function() {
            document.querySelectorAll('.profesional').forEach(btn => btn.classList.remove('selected'));
            this.classList.add('selected');
            profesionalSeleccionado = this.dataset.nombre;
        });
    });

    // Función para seleccionar un horario
    document.querySelectorAll('input[name="hora"]').forEach(function(radio) {
        radio.addEventListener('change', function() {
            horarioSeleccionado = this.value;
        });
    });

    // Función para seleccionar un día
    document.querySelectorAll('.calendario td').forEach(function(cell) {
        cell.addEventListener('click', function() {
            document.querySelectorAll('.calendario td').forEach(day => day.classList.remove('selected'));
            this.classList.add('selected');
            diaSeleccionado = this.textContent;
        });
    });

    // Función para mostrar la información en el modal
    document.querySelector('.solicitar').addEventListener('click', function() {
        if (profesionalSeleccionado && horarioSeleccionado && diaSeleccionado) {
            document.getElementById('modal-text').textContent =
                `✅ Su turno fue agendado con:\n\n📌 Profesional: ${profesionalSeleccionado}\n🕒 Horario: ${horarioSeleccionado}\n📅 Día: ${diaSeleccionado}`;
            document.getElementById('modal').style.display = 'flex';
        } else {
            alert('Por favor, selecciona un profesional, un horario y un día.');
        }
    });

    // Función para cerrar el modal al hacer clic en la "X"
    document.querySelector('.close').addEventListener('click', function() {
        document.getElementById('modal').style.display = 'none';
    });

    // Función para cerrar el modal al hacer clic fuera del contenido
    window.addEventListener('click', function(event) {
        let modal = document.getElementById('modal');
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
});

