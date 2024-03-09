import axios from "axios";
import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import Todo from "./components/Todo";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";

const App = () => {
  const queryClient = useQueryClient();
  const { register, handleSubmit, reset } = useForm();

  const { data: todos } = useQuery({
    queryKey: ["todos"],
    queryFn: () =>
      axios
        .get("http://localhost:8082/api/todos")
        .then((res) => res.data.data || []),
  });

  const mutation = useMutation({
    mutationFn: (content) => {
      return axios.post("http://localhost:8082/api/todo", content);
    },
    onError: (error) => {
      console.log(error);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("todos");
    },
  });

  const onSubmit = (data) => {
    reset();
    mutation.mutate(data);
  };

  return (
    <div className=" flex justify-center items-center  h-screen">
      <div className=" ">
        {/* header card */}
        <div className="my-5">
          <h1 className="text-3xl font-medium my-5">
            TodoList build with ReactJs and Java Spring
          </h1>
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="flex justify-between "
          >
            <input
              className="border w-4/5 p-3 rounded rounded-xl border-black outline-none"
              type="text"
              placeholder="Add your todo here !"
              {...register("content", { required: true })}
            />
            <button className="w-1/4  ms-2 rounded rounded-xl bg-sky-600 text-white">
              Add
            </button>
          </form>
        </div>
        {/* content card  */}

        <div className="items-center text-center">
          <h3 className="font-normal text-center text-2xl ">List of todos</h3>
          {todos && todos.length > 0
            ? todos.map((todo) => (
                <Todo key={todo.id} id={todo.id} content={todo.content} />
              ))
            : "Empty"}
        </div>
      </div>
    </div>
  );
};

export default App;
