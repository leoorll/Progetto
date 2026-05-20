<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sette e Mezzo</title>

<style>

body{
    margin:0;
    font-family: Arial, sans-serif;
    background: #0b4d1b;
    color:white;
    text-align:center;
}

h1{
    margin-top:20px;
    font-size:40px;
}

#tavolo{
    margin:30px auto;
    width:80%;
    background:#146b2e;
    border:5px solid #d4af37;
    border-radius:20px;
    padding:30px;
    box-shadow:0 0 20px black;
}

.area{
    margin:20px 0;
}

.carte{
    display:flex;
    justify-content:center;
    gap:10px;
    margin-top:15px;
}

.carta{
    width:70px;
    height:100px;
    background:white;
    color:black;
    border-radius:10px;
    display:flex;
    align-items:center;
    justify-content:center;
    font-size:28px;
    font-weight:bold;
    box-shadow:0 0 10px black;
}

button{
    padding:12px 25px;
    margin:10px;
    border:none;
    border-radius:10px;
    font-size:18px;
    cursor:pointer;
    transition:0.2s;
}

button:hover{
    transform:scale(1.05);
}

#pesca{
    background:#28a745;
    color:white;
}

#stai{
    background:#dc3545;
    color:white;
}

#messaggio{
    margin-top:20px;
    font-size:24px;
    font-weight:bold;
}

</style>
</head>

<body>

<h1> Sette e Mezzo </h1>

<div id="tavolo">

    <div class="area">
        <h2>Giocatore</h2>
        <p>Punteggio: <span id="puntiGiocatore">0</span></p>

        <div class="carte" id="carteGiocatore"></div>
    </div>

    <div class="area">
        <h2>Banco</h2>
        <p>Punteggio: <span id="puntiBanco">0</span></p>

        <div class="carte" id="carteBanco"></div>
    </div>

    <button id="pesca" onclick="pescaCarta()">
        Pesca Carta
    </button>

    <button id="stai" onclick="turnoBanco()">
        Stai
    </button>

    <div id="messaggio"></div>

</div>

<script>

let puntiGiocatore = 0;
let puntiBanco = 0;

function generaCarta(){

    let numero = Math.floor(Math.random() * 10) + 1;

    if(numero >= 8){
        return 0.5;
    }

    return numero;
}

function mostraCarta(id, valore){

    let carta = document.createElement("div");
    carta.classList.add("carta");

    if(valore == 0.5){
        carta.innerHTML = "F";
    }else{
        carta.innerHTML = valore;
    }

    document.getElementById(id).appendChild(carta);
}

function pescaCarta(){

    let carta = generaCarta();

    puntiGiocatore += carta;

    mostraCarta("carteGiocatore", carta);

    document.getElementById("puntiGiocatore").innerHTML =
        puntiGiocatore;

    if(puntiGiocatore > 7.5){

        document.getElementById("messaggio").innerHTML =
            "Hai sballato! Hai perso!";

        disattivaBottoni();
    }
}

function turnoBanco(){

    while(puntiBanco < 5){

        let carta = generaCarta();

        puntiBanco += carta;

        mostraCarta("carteBanco", carta);
    }

    document.getElementById("puntiBanco").innerHTML =
        puntiBanco;

    controllaVincitore();
}

function controllaVincitore(){

    let messaggio = "";

    if(puntiBanco > 7.5){
        messaggio = "Il banco ha sballato! Hai vinto!";
    }
    else if(puntiGiocatore > puntiBanco){
        messaggio = "Hai vinto!";
    }
    else if(puntiGiocatore < puntiBanco){
        messaggio = "Ha vinto il banco!";
    }
    else{
        messaggio = "Pareggio!";
    }

    document.getElementById("messaggio").innerHTML = messaggio;

    disattivaBottoni();
}

function disattivaBottoni(){

    document.getElementById("pesca").disabled = true;
    document.getElementById("stai").disabled = true;
}

</script>

</body>
</html>
