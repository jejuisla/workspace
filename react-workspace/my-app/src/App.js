import "./App.css";
// import 여기서 사용할 이름 from js파일경로;
import ClassComponent from "./components/R01_ClassComponent";
import FunctionComponent from "./components/R02_FunctionComponent";

import PropsEx1 from "./components/R03_Props1";
import PropsEx2 from "./components/R04_Props2";
import Props3 from "./components/R05_Props3";

import State1 from "./components/R06_State1";
import State2 from "./components/R07_State2";
import State3 from "./components/R08_State3";

import TodoList from "./components/R09_TodoList";

import Context1 from "./components/R10_Context1";
import Context2 from "./components/R11_Context2";

import Context3 from "./components/R13_Context/Parent";

/* ================================================================================================== */
/* 
  React의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다.
  여러 요소를 반환하고 싶을 때 부모 요소로 묶어준다.
*/
/* ================================================================================================== */
function App() {
  return (
    /* <></> (fragment, 조각) : 반환되는 요소를 감싸는 태그, 해석 X */
    <>
      {/* <h1>테스트</h1>
      <ClassComponent /> */}
      {/* jsx주석 */}
      {/* <ClassComponent /> */}
      {/* <hr /> */}
      {/* <FunctionComponent /> */}
      {/* 두개의 컴포넌트가 별도로 동작 */}
      {/* <FunctionComponent /> */}
      {/* <hr /> */}
      {/* <PropsEx1 />
      <PropsEx1 name="홍길동" num="1" age="23" />
      <PropsEx1 name="김철수" num="2" />
      <hr />
      <PropsEx2 name="강감찬" age="72" address="낙성대" gender="남자" />
      <PropsEx2 name="천추태후" age="66" address="개경" gender="여자" />
      <hr />
      <Props3 name="고재모" />
      <Props3 name="뉴진스" /> */}
      {/* <State1 />
      <hr />
      <State2 init={10} />
      <hr />
      <State3 /> */}
      {/* <TodoList /> */}

      {/* <Context1 /> */}
      {/* <Context2 /> */}
      {/* <Context3 /> */}
    </>
  );
}

export default App;
