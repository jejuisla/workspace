function print(temp) {
  const result = document.getElementById("result");
  result.innerText = "결과 : " + temp;
  // 요소.innerText : 내용에 글자 대입
}
// input 입력 요소의 값은 모두 string 타입
// 계산기를 만들 때 string타입을 number타입으로 변환해야 함
// Number("123") == 123
function plus() {
  // const first = document.getElementById("input-first");
  const first = document.querySelector("#input-first");
  // const second = document.getElementById("input-second");
  const second = document.querySelector("#input-second");
  print(Number(first.value) + Number(second.value));
}
function minus() {
  const first = document.getElementById("input-first");
  const second = document.getElementById("input-second");
  print(Number(first.value) - Number(second.value));
}
function multi() {
  const first = document.getElementById("input-first");
  const second = document.getElementById("input-second");
  print(Number(first.value) * Number(second.value));
}
function division() {
  const first = document.getElementById("input-first");
  const second = document.getElementById("input-second");
  print(Number(first.value) / Number(second.value));
}
function percent() {
  const first = document.getElementById("input-first");
  const second = document.getElementById("input-second");
  print(Number(first.value) % Number(second.value));
}
