var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var root = JSON.parse(document.getElementById("json").textContent);
console.log(root);

ctx.font = "14px Arial";
ctx.fillText("Room: " + root.room, 5, 15);
ctx.fillText("Keys: " + root.keys, 5, 30);
ctx.fillText("Coins: " + root.coins, 5, 45);

//SQUARE VARIABLES
var width = 300;
var height = 300;
var grosor = 20;

//DOORS VARIABLES
var widthSquare = 20;
var heightSquare = 20;

//KEY VARIABLE
var imageKey = new Image();

//COIN VARIABLE
var imageCoin = new Image();

//CHARACTER VARIABLE
var imageCharacter = new Image();

//ARROWS VARIABLE
var imageArrows= new Image();

canvas.addEventListener ("mousedown", function (event) {
    const boundingRect = canvas.getBoundingClientRect();
    //CANVAS
    const x = Math.trunc(event.clientX - boundingRect.left);
    const y = Math.trunc(event.clientY - boundingRect.top);
    console.log("X: " + x + ", Y: " + y);
    //KEY
    if ((100 + width - grosor - 45 <= x && x <= 100 + width - grosor) && (100 + height - grosor - 45 <= y && y <= 100 + height - grosor)) {
        window.location.assign("http://127.0.0.1:8080/getKey");
    }
    //COIN
    if ((100 + grosor <= x && x <= 100 + grosor + 60) && (100 + height - grosor - 60 <= y && y <= 100 + height - grosor)) {
        window.location.assign("http://127.0.0.1:8080/getCoin");
    }
    //ARROW UP
    if ((530 <= x && x <= 575) && (340 <= y && y <= 390)) {
        if (root.N == "closed")
        ctx.fillText("The door is closed", 120, 135);
        else if (root.N == "wall")
        ctx.fillText("This is a wall", 120, 135);
        else window.location.assign("http://127.0.0.1:8080/nav?dir=N");
    }
    //ARROW DOWN
    if ((530 <= x && x <= 575) && (392 <= y && y <= 440)) {
        if (root.S == "closed")
        ctx.fillText("The door is closed", 120, 135);
        else if (root.S == "wall")
        ctx.fillText("This is a wall", 120, 135);
        else window.location.assign("http://127.0.0.1:8080/nav?dir=S");
    }
    //ARROW LEFT
    if ((480 <= x && x <= 523) && (392 <= y && y <= 440)) {
        if (root.W == "closed")
        ctx.fillText("The door is closed", 120, 135);
        else if (root.W == "wall")
        ctx.fillText("This is a wall", 120, 135);
        else window.location.assign("http://127.0.0.1:8080/nav?dir=W");
    }
    //ARROW RIGHT
    if ((575 <= x && x <= 620) && (392 <= y && y <= 440)) {
        if (root.E == "closed")
        ctx.fillText("The door is closed", 120, 135);
        else if (root.E == "wall")
        ctx.fillText("This is a wall", 120, 135);
        else window.location.assign("http://127.0.0.1:8080/nav?dir=E");
    }
});

//ROOM
ctx.beginPath();
ctx.rect(100, 100, width, height);
ctx.lineWidth = grosor;
ctx.stroke();

//DOORS
colorDoors(root.N);
ctx.fillRect(100 + width/2 - widthSquare, 100 - heightSquare/2, widthSquare*2, heightSquare);

colorDoors(root.E);
ctx.fillRect(100 + width - widthSquare/2, 100 + height/2 - heightSquare, widthSquare, heightSquare*2);

colorDoors(root.S);
ctx.fillRect(100 + width/2 - widthSquare, 100 - heightSquare/2 + height, widthSquare*2, heightSquare);

colorDoors(root.W);
ctx.fillRect(100 - widthSquare/2, 100 + height/2 - heightSquare, widthSquare, heightSquare*2);

function colorDoors(door) {
  if (door == "open") {
    ctx.fillStyle = "white";
  }

  if (door == "closed") {
    ctx.fillStyle = "red";
  }
}

//KEY
imageKey.src = "./images/key.png";
console.log(imageKey);
if (root.tieneLlave == true) {
    imageKey.onload = drawKey;
}

function drawKey() {
    ctx.drawImage(imageKey, 100 + width - grosor - 45, 100 + height - grosor - 45, 45, 45);
}

//COIN
imageCoin.src = "./images/coin.png";
console.log(imageCoin);
if (root.tieneMoneda == true) {
    imageCoin.onload = drawCoin;
}

function drawCoin() {
    ctx.drawImage(imageCoin, 100 + grosor, 100 + height - grosor - 60, 60, 60);
}

//CHARACTER
imageCharacter.src = "./images/stitch.png";
console.log(imageCharacter);
imageCharacter.onload = drawCharacter;

function drawCharacter() {
    ctx.drawImage(imageCharacter, 100 + width/2 - grosor*2, 100 + height/2 - grosor*2, 90, 90);
}

//ARROWS
imageArrows.src = "./images/arrows.png";
console.log(imageArrows);
imageArrows.onload = drawArrows;

function drawArrows() {
    ctx.drawImage(imageArrows, 480, 340, 140, 100);
}