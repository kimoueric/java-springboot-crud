import React from "react";

const Todo = () => {
  return (
    <div className=" flex justify-between my-2">
      <div className=" w-4/5 p-3 rounded rounded-xl bg-sky-600 text-white">
        Learn about charts patterns
      </div>
      <button className="w-1/4 text-white ms-2 rounded rounded-xl bg-red-600">
        delete
      </button>
    </div>
  );
};

export default Todo;
