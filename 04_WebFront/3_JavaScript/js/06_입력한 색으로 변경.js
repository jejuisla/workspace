// const bg = document.querySelectorAll(".bg");
const bg = document.getElementsByClassName("bg");
const input = document.querySelectorAll(".input-text");
// const input = document.getElementsByClassName("input-text");

function color() {
  bg[0].style.backgroundColor = input[0].value;
  // bg[1].style.backgroundColor = input[1].value;
  // bg[2].style.backgroundColor = input[2].value;
  // bg[3].style.backgroundColor = input[3].value;
  // bg[4].style.backgroundColor = input[4].value;
  for (let i = 0; i < bg.length; i++) {
    bg[i].style.backgroundColor = input[i].value;
  }
}
