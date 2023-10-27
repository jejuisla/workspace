const heartImg = document.querySelector("#img");
const countHeart = document.querySelector("#count-heart");

let count = 0;
countHeart.innerHTML = count;

heartImg.addEventListener("click", () => {
  if (heartImg.src.match("basic-heart.png")) {
    heartImg.src = "red-heart.jpg";
    countHeart.innerHTML = ++count;
  } else {
    heartImg.src = "basic-heart.png";
    countHeart.innerHTML = --count;
  }
});
