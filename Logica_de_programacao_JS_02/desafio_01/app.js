// Desafio 01 : Altere o conteúdo da tag h1 com document.querySelector e atribua o seguinte texto: Hora do Desafio.
let titulo = document.querySelector("h1");
titulo.innerHTML = "Hora do Desafio";

// Desafio 02 : Crie uma função que exiba no console a mensagem O botão foi clicado sempre que o botão Console for pressionado.
function mostrarMensagemConsole() {
    console.log("O botão foi clicado");
}

// Desafio 03 : Crie uma função que exiba um alerta com a mensagem: Eu amo JS, sempre que o botão Alerta for pressionado.
function mostrarMensagemAlerta() {
    alert("Eu amo JS");
}

// Desafio 04 : Crie uma função que é executada quando o botão prompt é clicado, perguntando o nome de uma cidade do Brasil. Em seguida, exiba um alerta com a mensagem concatenando a resposta com o texto: Estive em {cidade} e lembrei de você.
function mostrarCidade() {
    let cidade = prompt("Digite o nome de uma cidade do Brasil:");

    alert(`Estive em ${ cidade } e lembrei de você`);
}

// Desafio 05 : Ao clicar no botão soma, peça 2 números inteiros e exiba o resultado da soma em um alerta.
function soma() {
    let numero1 = parseInt(prompt("Digite um número inteiro:"));
    let numero2 = parseInt(prompt("Digite outro número inteiro:"));
    let soma = numero1 + numero2;
    
    alert(`A soma de ${ numero1 } e ${ numero2 } é ${ soma }.`);
}