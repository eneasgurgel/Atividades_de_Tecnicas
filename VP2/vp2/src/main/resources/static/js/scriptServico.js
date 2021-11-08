function limparCampos() {
    document.getElementById("maoDeObra").value = "";
    document.getElementById("pecas").value = "";
}

function cadastrarServico() {
    let maoDeObra = document.getElementById("maoDeObra").value;
    let pecas = document.getElementById("pecas").value;

    let servico = {
        'maoDeObra' : maoDeObra,
        'pecas' : pecas,
        'total' : 0
    };


    function reqListener () {
        let servico = JSON.parse(this.responseText);
        adicionarServico(servico);
    }
    console.log(servico);
    let oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "servicos", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(servico));
}

function adicionarServico(servico) {
    let container = document.createElement("div");
    container.classList.add("container");

    let maoDeObra = document.createElement("div");
    maoDeObra.classList.add("row");
    maoDeObra.innerHTML = "<h2>" + servico.maoDeObra + "</h2>";

    let pecas = document.createElement("div");
    pecas.classList.add("row");
    let p = document.createElement("p");
    p.innerHTML = servico.pecas;
    pecas.appendChild(p);

    container.appendChild(maoDeObra);
    container.appendChild(pecas);
    document.getElementById("servicos").appendChild(container);
    limparCampos();
}



function exibirServicos() {

    let oReq = new XMLHttpRequest();
    oReq.onload = function(){
        let listaDeServicos = JSON.parse(this.responseText);
        for (let i = 0; i < listaDeServicos.length; i++) {
            adicionarPeca(listaDeServicos[i]);
        }
    } ;
    oReq.open("GET", "servicos", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}


window.addEventListener("load", function (){
    exibirServicos();
});