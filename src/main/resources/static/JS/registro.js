document.getElementById("registroForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const newUsername = document.getElementById("newUsername").value;
    const email = document.getElementById("email").value;
    const newPassword = document.getElementById("newPassword").value;

    // Validación de campos
        if (!newUsername || !email || !newPassword) {
            alert("Por favor, completa todos los campos.");
            return;
        }

    const response = await fetch("http://localhost:8080/api/auth/registro", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: newUsername, email, password: newPassword }),
    });

    if (response.ok) {
        alert("Usuario registrado con éxito.");
        window.location.href = "/login.html";
    } else {
        alert("Error al registrar. Inténtalo de nuevo.");
    }
});
