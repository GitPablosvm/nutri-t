
$(document).ready(function () {
    agregarNuevoTurno();


});

async function agregarNuevoTurno(){


    let datos={};
    datos.nombre=document.getElementById("nombre").value;
    datos.apellido=document.getElementById("apellido").value;
    datos.dni=document.getElementById("dni").value;

    console.log(datos);


    const request = await fetch('api/NuevoTurno', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    console.log(request);


}