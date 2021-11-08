function limparCampos() {
    document.getElementById("nome").value = "";
    document.getElementById("fabricante").value = "";
    document.getElementById("quantidadePeca").value = "";
    document.getElementById("precoPeca").value = "";
}

function cadastrarPeca() {
    let nome = document.getElementById("nome").value;
    let fabricante = document.getElementById("fabricante").value;
    let quantidade = document.getElementById("quantidadePeca").value;
    let preco = document.getElementById("precoPeca").value;

    let peca = {
        'nome' : nome,
        'fabricante' : fabricante,
        'qtdEstoque' : quantidade,
        'preco' : preco
    };



    function reqListener () {
        let peca = JSON.parse(this.responseText);
        adicionarPeca(peca);
    }

    let oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "peca", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(peca));
}

function adicionarPeca(peca) {
    let container = document.createElement("div");
    container.classList.add("container");

    let nome = document.createElement("div");
    nome.classList.add("row");
    nome.innerHTML = "<h2>" + peca.nome + "</h2>";

    let fabricante = document.createElement("div");
    fabricante.classList.add("row");
    let p = document.createElement("p");
    p.innerHTML = peca.fabricante;
    fabricante.appendChild(p);

    let id = document.createElement("div");
    id.classList.add("row");
    let p2 = document.createElement("p");
    p2.innerHTML = "<strong> ID: </strong>" + peca.id;
    id.appendChild(p2);

    container.appendChild(nome);
    container.appendChild(fabricante);
    container.appendChild(id);
    document.getElementById("pecas").appendChild(container);
    limparCampos();
}

function apagarPeca(){
    let id = document.getElementById("id").value;
    let oReq = new XMLHttpRequest();
    oReq.open("DELETE", "peca/" + id, true);
    oReq.send();
}

function alterarPeca(){
    let nome = document.getElementById("nome").value;
    let fabricante = document.getElementById("fabricante").value;
    let quantidade = document.getElementById("quantidadePeca").value;
    let preco = document.getElementById("precoPeca").value;

    let peca = {
        'nome' : nome,
        'fabricante' : fabricante,
        'qtdEstoque' : quantidade,
        'preco' : preco
    };



    function reqListener () {
        let peca = JSON.parse(this.responseText);
        adicionarPeca(peca);
    }
    let id = document.getElementById("id").value;
    let oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("PUT", "peca/" + id, true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(peca));
}

function exibirPecas() {

    let oReq = new XMLHttpRequest();
    oReq.onload = function(){
        let listaDePecas = JSON.parse(this.responseText);
        for (let i = 0; i < listaDePecas.length; i++) {
            adicionarPeca(listaDePecas[i]);
        }
    } ;
    oReq.open("GET", "peca", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

window.addEventListener("load", function (){
    exibirPecas();
});