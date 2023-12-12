import React from "react";
// 위에 구문이 없으면 React 못 씀

/* 컴포넌트 함수명, 변수명은 대문자로 시작 */
const PropsEx1 = (props) => {
  console.log(props);

  return (
    /* fragment(조각) : 감싸는 용도, 랜더링할 때 사라짐 */
    /* 컴포넌트 함수는 하나의 요소만 리턴 가능 */
    <>
      <h3>
        번호 : {props.num} / 이름 : {props.name} / 나이 : {props.age}
      </h3>
    </>
  );
};

// 외부에서 import시 PropsEx1 함수(컴포넌트)를 기본값으로 내보냄
export default PropsEx1;
