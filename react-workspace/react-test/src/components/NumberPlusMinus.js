import React, { useState } from "react";

const NumberPlusMinus = () => {
  const [count, setCount] = useState(0);

  return (
    <>
      <button
        onClick={() => {
          setCount(count - 1);
        }}
        className="minus"
      >
        -
      </button>
      <span>{count}</span>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
        className="plus"
      >
        +
      </button>
    </>
  );
};

export default NumberPlusMinus;
