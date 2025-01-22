// Desafio 01 : Crie um contador que comece em 1 e vá até 10 usando um loop while. Mostre cada número.
let contador = 1;

while (contador <= 10) {
    alert(`Contador: ${ contador }`);
    contador++;
}

// Desafio 02 : Crie um contador que começa em 10 e vá até 0 usando um loop while. Mostre cada número.
let contador = 10;

while (contador >= 0) {
    alert(`Contador: ${ contador }`);
    contador--;
}

// Desafio 03 : Crie um programa de contagem regressiva. Peça um número e conte deste número até 0, usando um loop while no console do navegador.
let contador = prompt("Digite um número: ");

while (contador >= 0) {
    console.log(`Contagem regressiva: ${ contador }`);
    contador--;
}

// Desafio 04 : Crie um programa de contagem progressiva. Peça um número e conte de 0 até esse número, usando um loop while no console do navegador.
let contador = 0;
let numero = prompt("Digite um número: ");

while (contador <= numero) {
    console.log(`Contagem progressiva: ${ contador }`);
    contador++;
}