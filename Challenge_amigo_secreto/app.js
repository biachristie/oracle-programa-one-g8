let amigos = [];

function adicionarAmigo() {
    let inputAmigo = document.getElementById("amigo");
    
    if (inputAmigo.value == "") {
        alert("Por favor, insira um nome válido.");
    } else {
        amigos.push(inputAmigo.value);
        inputAmigo.value = "";
        exibirListaAmigos();
    }
}

function exibirListaAmigos() {
    let listaAmigos = document.getElementById("listaAmigos");
    listaAmigos.innerHTML = "";

    amigos.forEach(element => {
        let itemLista = document.createElement("li");
        itemLista.innerHTML = element;
        listaAmigos.append(itemLista);
    });
}

function sortearAmigo() {
    if (amigos != "") {
        let i = Math.floor(Math.random() * amigos.length);
        let nomeSorteado = amigos[i];

        let resultado = document.getElementById("resultado");
        resultado.innerHTML = `<li>O amigo secreto sorteado é: ${ nomeSorteado }</li>`;
    }
}