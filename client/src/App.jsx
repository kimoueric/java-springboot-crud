import React from "react";
import Todo from "./components/Todo";

const App = () => {
  return (
    <div className=" flex justify-center items-center  h-screen">
      <div className=" ">
        {/* header card */}
        <div className="my-5">
          <h1 className="text-3xl font-medium my-5">
            TodoList build with ReactJs and Java Spring{" "}
          </h1>
          <form action="" className="flex justify-between ">
            <input
              className="border w-4/5 p-3 rounded rounded-xl border-black outline-none"
              type="text"
              name=""
              id=""
              placeholder="Add your todo here !"
            />
            <button className="w-1/4  ms-2 rounded rounded-xl bg-sky-600 text-white">
              Add
            </button>
          </form>
        </div>
        {/* content card  */}

        <div className=" items-center">
          <h3 className="font-normal text-center text-2xl">List of todos</h3>
          <Todo />
        </div>
      </div>
    </div>
  );
};

export default App;
