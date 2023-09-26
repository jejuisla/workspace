const checkList = {
  "input-id": false,
  "input-pw": false,
  "input-pw2": false,
  "input-email": false,
  "input-address": false,
};

const inputId = document.querySelector("#input-id");
const inputPw = document.querySelector("#input-pw");
const inputPwCheck = document.querySelector("#input-pw2");
const inputEmail = document.querySelector("#input-email");
const inputAddress = document.querySelector("#input-address");

const idSpan = document.querySelector(".input-result-id");
const pwSpan = document.querySelector(".input-result-pw");
const pw2Span = document.querySelector(".input-result-pw2");

inputPw.addEventListener("click", () => {
  const span = document.querySelector(".input-result-pw");
  span.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
});

inputPw.addEventListener("input", () => {
  const idVal = inputId.value;
  if (idVal.length == 0) {
    idSpan.innerText = "필수 입력 항목입니다.";
    idSpan.innerText.add("error");
    idSpan.classList.remove("check");

    return;
  }
});
inputPwCheck.addEventListener("input", () => {
  const pwVal = inputPw.value;
  if (pwVal.length == 0) {
    pwSpan.innerText = "필수 입력 항목입니다.";
    // pwSpan.innerText.add("error");
    // pwSpan.classList.remove("check");

    return;
  }
});

inputEmail.addEventListener("input", () => {
  const pw2Val = inputPwCheck.value;
  if (pw2Val.length == 0) {
    pw2Span.innerText = "필수 입력 항목입니다.";
    pw2Span.innerText.add("error");
    pw2Span.classList.remove("check");

    return;
  }
});

inputPw.addEventListener("input", (e) => {
  const val = e.target.value.trim();
  const span = e.target.nextElementSibling.nextElementSibling;

  e.target.value = val;

  if (val.length == 0) {
    span.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
    span.classList.remove("check");
    span.classList.remove("error");

    checkList["input-pw"] = false;

    return;
  }
});
