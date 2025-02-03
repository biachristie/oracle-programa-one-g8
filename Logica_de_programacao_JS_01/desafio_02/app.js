// Desafio 01 : Pergunte ao usuário qual é o dia da semana. 
// Se a resposta for "Sábado" ou "Domingo", mostre "Bom fim de semana!". 
// Caso contrário, mostre "Boa semana!".

let diaDaSemana = prompt("Digite o dia da semana: ");

if (diaDaSemana == "Sábado" || diaDaSemana == "Domingo") {
    alert("Bom fim de semana!");
} else {
    alert("Boa semana!");
}

// Desafio 02 : Verifique se um número digitado pelo usuário é positivo ou negativo. Mostre um alerta informando.
let numero = prompt("Digite um número: ");

if (numero >= 0) {
    alert("O número digitado é positivo");
} else {
    alert("O número digitado é negativo");
}

// Desafio 03 : Crie um sistema de pontuação para um jogo. Se a pontuação for maior ou igual a 100, mostre "Parabéns, você venceu!". 
// Caso contrário, mostre "Tente novamente para ganhar.".
let pontuacao = 105;

if (pontuacao >= 100) {
    console.log("Parabéns, você venceu!");
} else {
    console.log("Tente novamente para ganhar.");
}

// Desafio 04 : Crie uma mensagem que informa o usuário sobre o saldo da conta, usando uma template string para incluir o valor do saldo.
let saldo = 50;
alert(`O saldo da conta é R$${ saldo }.`);

// Desafio 05 : Peça ao usuário para inserir seu nome usando prompt. Em seguida, mostre um alerta de boas-vindas usando esse nome.
let nomeDoUsuario = prompt("Digite o seu nome: ");
alert(`Seja bem vindo(a), ${ nomeDoUsuario }!`);