// Desafio 01 : Crie uma função que calcule o índice de massa corporal (IMC) de uma pessoa, a partir de sua altura, em metros, e peso, em quilogramas, que serão recebidos como parâmetro.
function calcularIMC(peso, altura) {
    let imc = peso / (altura * altura)
    console.log(`Seu IMC é ${ imc }.`);
}

calcularIMC(43, 1.6);

// Desafio 02 : Crie uma função que calcule o valor do fatorial de um número passado como parâmetro.
function calcularFatorial(numero) {
    if (numero === 0 || numero === 1) {
        return 1;
    }

    for (let i = numero - 1; i >= 1; i--) {
        numero *= i;
    }

    return numero;
}

let numero = 5;
let resultado = calcularFatorial(numero);
console.log(`O fatorial de ${ numero } é ${ resultado }.`);


// Desafio 03 : Crie uma função que converte um valor em dólar, passado como parâmetro, e retorna o valor equivalente em reais. Para isso, considere a cotação do dólar igual a R$4,80.
function converterDolarEmReal(valorEmDolar) {
    const cotacaoDolar = 4.80;
    let valorEmReal = valorEmDolar * cotacaoDolar;
    return valorEmReal.toFixed(2);
}

let valorEmDolar = 10;
let valorEmReal = converterDolarEmReal(10);
console.log(`${ valorEmDolar } dólares equivalem a R$ ${ valorEmReal }.`);

// Desafio 04 : Crie uma função que mostre na tela a área e o perímetro de uma sala retangular, utilizando altura e largura que serão dadas como parâmetro.
function calcularRetangulo(altura, largura) {
    let area = altura * largura;
    let perimetro = (altura + largura) * 2;
    console.log("Área: %s, Perímetro: %s", area, perimetro);
}

calcularRetangulo(2,5);

// Desafio 05 : Crie uma função que mostre na tela a área e o perímetro de uma sala circular, utilizando seu raio que será fornecido como parâmetro. Considere Pi = 3,14.
function calcularCirculo(raio) {
    const pi = 3.14;
    let area = pi * (raio * raio);
    let perimetro = 2 * pi * raio;
    console.log("Área: %s, Perímetro: %s", area, perimetro);
}

calcularCirculo(3);

// Desafio 6 : Crie uma função que mostre na tela a tabuada de um número dado como parâmetro.
function exibirTabuada(numero) {
    for (let i = 1; i <= 10 ; i++) {
        let resultado = numero * i;
        console.log(`${ numero } x ${ i } = ${ resultado }`);
    }
}

exibirTabuada(5);