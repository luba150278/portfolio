const $ = jQuery
let prov = false
let arr = [,]
// $('#my-canvas').click(function ()
// {
//   console.log('aaa')
// })


let canvas = document.getElementById('my-canvas')
let ctx = canvas.getContext("2d")

ctx.lineWidth = 2; // толщина линии

document.body.appendChild(canvas);

let x1 = 0, y1 = 0, x2 = 0, y2 = 0;
let canDrawSelection = false;

canvas.addEventListener("mousedown", function(e) {
  canDrawSelection = true;
  x1 = e.clientX;
  y1 = e.clientY;
  x2 = e.clientX;
  y2 = e.clientY;
  
  if(prov == false)
   {
    ctx.moveTo(x1, y1)
    prov = true}
});

canvas.addEventListener("mouseup", function(e) {
  canDrawSelection = false;
});

canvas.addEventListener("mousemove", function(e) {
  x2 = e.clientX;
  y2 = e.clientY;
  
});

function drawSelection() {
  if (canDrawSelection === true) {
    ctx.beginPath();
    ctx.lineWidth="2";
    ctx.strokeStyle="blue";
    ctx.rect(x1, y1, x2 - x1, y2 - y1);
    ctx.stroke();
  }
}

function render() {
  ctx.canvas.width = window.innerWidth;
  ctx.canvas.height = window.innerHeight;
  ctx.fillStyle = "white";
  ctx.fillRect(0, 0, ctx.canvas.width, ctx.canvas.height);
  
  drawSelection();
}

function animate() {
  requestAnimationFrame(animate);
  render();
}

animate();




// canvas.onclick = function () {
//   console.log('aaaaa')
//   let x=event.offsetX
//   let y=event.offsetY
//   ctx.lineTo(x, y) //рисуем линию
//   ctx.stroke()
// }