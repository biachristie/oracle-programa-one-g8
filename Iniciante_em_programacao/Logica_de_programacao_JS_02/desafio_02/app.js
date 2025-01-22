// Desafio 01 : Criar uma função que exibe "Olá, mundo!" no console.
function exibirSaudacao() {
    console.log("Olá, mundo!");
}

exibirSaudacao();

// Desafio 02 : Criar uma função que recebe um nome como parâmetro e exibe "Olá, [nome]!" no console.
function exibirSaudacao(nome) {
    console.log(`Olá, ${ nome }`);
}

exibirSaudacao("Beatriz");

// Desafio 03 : Criar uma função que recebe um número como parâmetro e retorna o dobro desse número.
function calcularDobro(numero) {
    return numero * 2;
}

let resultadoDobro = calcularDobro(2);
console.log(resultadoDobro);

// Desafio 04 : Criar uma função que recebe três números como parâmetros e retorna a média deles.
function calcularMedia(numero1, numero2, numero3) {
    return (numero1 + numero2 + numero3) / 3;
}

let media = calcularMedia(1, 2, 3);
console.log(media);

// Desafio 05 : Criar uma função que recebe dois números como parâmetros e retorna o maior deles.
function encontrarMaiorNumero(numero1, numero2) {
    return numero1 > numero2 ? numero1 : numero2;
}

let maiorNumero = encontrarMaiorNumero(1, 2);
console.log(maiorNumero);

// Desafio 6 : Criar uma função que recebe um número como parâmetro e retorna o resultado da multiplicação desse número por ele mesmo.
function calcularQuadrado(numero) {
    return numero * numero;
}

let resultado = calcularQuadrado(2);
console.log(resultado);