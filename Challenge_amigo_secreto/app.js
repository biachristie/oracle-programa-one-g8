let amigos = [];

function adicionarAmigo() {
    let inputAmigo = document.getElementById("amigo");
    
    if (inputAmigo.value == "") {
        alert("Por favor, insira um nome válido.");
    } else {
        let nomeAmigo = verificarInput(inputAmigo.value);

        if (typeof nomeAmigo !== "undefined" && !verificarNomeRepetido(nomeAmigo)) {
            amigos.push(nomeAmigo);
            inputAmigo.value = "";
            exibirListaAmigos();
        }
    }
}

function verificarInput(value) {
    const caracteresPermitidos = /^[A-Za-záéíóúãâêôàèùçÁÉÍÓÚÂÊÔÀÈÙÇ`^~´ ]*$/;
    
    if (!caracteresPermitidos.test(value)) {
        alert("Caractere inválido! Apenas letras e acentos são permitidos.");
    } else {
        let nomeAmigo = removerEspaços(value);
        return nomeAmigo.toUpperCase();
    }
}

function removerEspaços(value) {
    let stringEditada = value.trim();
    return stringEditada;
}

function verificarNomeRepetido(value) {
    if (amigos.includes(value)) {
        alert("Nome repetido! Insira outro nome.");
        return true
    }
}

function exibirListaAmigos() {
    let listaAmigos = document.getElementById("listaAmigos");
    listaAmigos.innerHTML = "";

    if (amigos.length) {
        amigos.forEach(element => {
            let itemLista = document.createElement("li");
            itemLista.innerHTML = element;
            listaAmigos.append(itemLista);
        });
    }
}

function sortearAmigo() {
    if (amigos != "") {
        let i = Math.floor(Math.random() * amigos.length);
        let nomeSorteado = amigos[i];

        let resultado = document.getElementById("resultado");
        resultado.innerHTML = `<li>O amigo secreto sorteado é: ${ nomeSorteado }</li>`;
    }
}