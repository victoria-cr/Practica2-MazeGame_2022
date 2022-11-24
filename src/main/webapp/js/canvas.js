var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var root = JSON.parse(document.getElementById("json").textContent);
console.log(root);
console.log(root.doors);

ctx.font = "14px Arial";
ctx.fillText("Room: " + root.room, 5, 15);
ctx.fillText("Keys: " + root.inventory.keys, 5, 30);
ctx.fillText("Coins: " + root.inventory.coins, 5, 45);

//VARIABLES CUADRADO
var width = 300;
var height = 300;
var grosor = 20;

//VARIABLES PUERTAS
var widthSquare = 20;
var heightSquare = 20;

//VARIABLE LLAVE
var imagenLlave = new Image();

//VARIABLE MONEDA
var imagenMoneda = new Image();

//VARIABLE PERSONAJE
var imagenPersonaje = new Image();

//VARIABLE FLECHAS
var imagenFlechas= new Image();

canvas.addEventListener ("mousedown", function (event) {
    const boundingRect = canvas.getBoundingClientRect();
    // Marcas del canvas
    const x = Math.trunc(event.clientX - boundingRect.left);
    const y = Math.trunc(event.clientY - boundingRect.top);
    console.log("X: " + x + ", Y: " + y);
    //Llave
    if ((100 + grosor <= x && x <= 100 + grosor + 100 + grosor + 45) && (100 + grosor <= y && y <= 100 + grosor + 45)) {
        console.log("Key");
    }
    //Moneda
    if ((100 + grosor <= x && x <= 100 + grosor + 60) && (100 + height - grosor - 60 <= y && y <= 100 + height - grosor)) {
        console.log("Coin");
    }
    //Flecha arriba
    if ((530 <= x && x <= 575) && (340 <= y && y <= 390)) {
        console.log("Arriba");
    }
    //Flecha abajo
    if ((530 <= x && x <= 575) && (392 <= y && y <= 440)) {
        console.log("Abajo");
    }
    //Flecha izquierda
    if ((480 <= x && x <= 523) && (392 <= y && y <= 440)) {
        console.log("Izquierda");
    }
    //Flecha derecha
    if ((575 <= x && x <= 620) && (392 <= y && y <= 440)) {
        console.log("Derecha");
    }
});

//ROOM
ctx.beginPath();
ctx.rect(100, 100, width, height);
ctx.lineWidth = grosor;
ctx.stroke();

//PUERTAS
colorDoors(root.doors.N);
ctx.fillRect(100 + width/2 - widthSquare, 100 - heightSquare/2, widthSquare*2, heightSquare);

colorDoors(root.doors.E);
ctx.fillRect(100 + width - widthSquare/2, 100 + height/2 - heightSquare, widthSquare, heightSquare*2);

colorDoors(root.doors.S);
ctx.fillRect(100 + width/2 - widthSquare, 100 - heightSquare/2 + height, widthSquare*2, heightSquare);

colorDoors(root.doors.W);
ctx.fillRect(100 - widthSquare/2, 100 + height/2 - heightSquare, widthSquare, heightSquare*2);

function colorDoors(door) {
  if (door == "open") {
    ctx.fillStyle = "white";
  }

  if (door == "closed") {
    ctx.fillStyle = "red";
  }
}

//LLAVE
imagenLlave.src = "../imagenes/llave.png";
console.log(imagenLlave);
imagenLlave.onload = pintarLlave;

function pintarLlave() {
    ctx.drawImage(imagenLlave, 100 + grosor, 100 + grosor, 45, 45);
}

//MONEDA
imagenMoneda.src = "../imagenes/moneda.png";
console.log(imagenMoneda);
imagenMoneda.onload = pintarMoneda;

function pintarMoneda() {
    ctx.drawImage(imagenMoneda, 100 + grosor, 100 + height - grosor - 60, 60, 60);
}

//PERSONAJE
imagenPersonaje.src = "../imagenes/stitch.png";
console.log(imagenPersonaje);
imagenPersonaje.onload = pintarPersonaje;

function pintarPersonaje() {
    ctx.drawImage(imagenPersonaje, 100 + width/2 - grosor*2, 100 + height/2 - grosor*2, 90, 90);
}

//FLECHAS
imagenFlechas.src = "../imagenes/flechas.png";
console.log(imagenFlechas);
imagenFlechas.onload = pintarFlechas;

function pintarFlechas() {
    ctx.drawImage(imagenFlechas, 480, 340, 140, 100);
}