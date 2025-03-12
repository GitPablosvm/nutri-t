window.onload = function () {
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

                </div>
            </section>
    `
}