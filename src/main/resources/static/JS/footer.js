window.onload = function() {
    const footer = document.querySelector('footer');
    footer.classList.add('pie-pagina');

    footer.innerHTML = `
            <section id="contacto">
                <div class="fila">
                    <div class="col">
                        <h1>NutriGM</h1>
                    </div>
                    <div class="col">
                        <h3>Menú</h3>
                        <a href="#inicio">Inicio</a>
                        <a href="#platos">Platos</a>
                        <a href="#blog">Blog</a>
                    </div>
                    <div class="col">
                        <h3>Equipo</h3>
                        <a href="#">Guadalupe Mejias</a>
                        <a href="#">Stefano Mejias</a>
                    </div>
                    <div class="col">
                        <h3>Social Media</h3>
                        <div class="media">
                            <i class="fa-brands fa-twitter"></i> <a href="#">Twitter</a>
                        </div>
                        <div class="media">
                            <i class="fa-brands fa-instagram"></i> <a href="https://www.instagram.com/nutri.gm/">Instagram</a>
                        </div>
                    </div>
                    <div class="col">
                        <h3>Contacto</h3>
                        <form action="index.php" name="usuarios" method="post">
                            <div class="input-group">
                                <div class="input-field" id="nameInput">
                                    <i class="fas fa-user" id="formato_icono"></i>
                                    <input type="text" name="name" id="name" placeholder="Nombre" required>
                                </div>
                                <div class="input-field">
                                    <input type="email" name="email" id="email" placeholder="Correo" required>
                                </div>
                            </div>
                            <div class="btn-field">
                                <button type="submit">Enviar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
    `
}