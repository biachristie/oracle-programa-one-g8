let amigos = [];

const limparInput = e => e.value = "";

const adicionarAmigo = () => {
    const caracteresPermitidos = /^[A-Za-záéíóúãâêôàèùçÁÉÍÓÚÂÊÔÀÈÙÇ ]*$/;

    let inputAmigo = document.getElementById("amigo");
    let nomeAmigo = inputAmigo.value.trim().toUpperCase();
    
    if (!nomeAmigo || !caracteresPermitidos.test(nomeAmigo)) {
        alert("Por favor, insira um nome válido (apenas letras e letras acentuadas).");
        limparInput(inputAmigo);
        return;
    } 
    
    if (amigos.includes(nomeAmigo)) {
        alert("Nome repetido! Insira outro nome.");
        limparInput(inputAmigo);
        return;
    }

    amigos.push(nomeAmigo);
    limparInput(inputAmigo);
    exibirListaAmigos();
    habilitarBotao();
}

const exibirListaAmigos = () => {
    let listaAmigos = document.getElementById("listaAmigos");
    listaAmigos.innerHTML = "";
    listaAmigos.innerHTML = amigos.map(nome => `<li>${ nome }</li>`).join("");
}

const habilitarBotao = () => {
    document.querySelector(".button-draw").disabled = amigos.length < 2;
}

const sortearAmigo = () => {
    let nomeSorteado = amigos[Math.floor(Math.random() * amigos.length)];
    document.getElementById("resultado").innerHTML = `<li>O amigo secreto sorteado é: ${ nomeSorteado }</li>`;
}