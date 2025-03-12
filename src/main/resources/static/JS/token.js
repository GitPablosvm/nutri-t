function generarToken() {
    let token = "";
    for (let i = 0; i < 7; i++) {
        token += Math.floor(Math.random() * 10); // Genera un número del 0 al 9
    }
    alert("Tu token es: " + token);
}