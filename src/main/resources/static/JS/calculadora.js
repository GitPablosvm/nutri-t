document.getElementById("imcForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const weight = parseFloat(document.getElementById('weight').value.replace(',', '.'));
    const height = parseFloat(document.getElementById('height').value.replace(',', '.')) / 100;

    const result = document.getElementById('result');

    if (isNaN(weight) || isNaN(height) || weight <= 0 || height <= 0) {
        result.innerHTML = "Por favor, ingresa valores válidos.";
        return;
    }

    const bmi = weight / (height ** 2);
    result.innerHTML = `Tu IMC es: ${bmi.toFixed(2)} - ${clasificarIMC(bmi)}`;
});

// Función para clasificar el IMC
function clasificarIMC(bmi) {
    if (bmi < 18.5) return "Bajo peso";
    if (bmi < 25) return "Peso normal";
    if (bmi < 30) return "Sobrepeso";
    return "Obesidad";
}
