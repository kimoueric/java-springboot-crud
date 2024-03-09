import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios from "axios";
import React from "react";

const Todo = ({ id, content }) => {
  const queryClient = useQueryClient();
  const mutation = useMutation({
    mutationFn: () => {
      return axios.delete(`http://localhost:8082/api/todo/${id}`);
    },
    onError: (error) => {
      console.log(error);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("todos");
    },
  });
  const onDelete = () => {
    mutation.mutate();
  };
  return (
    <div className=" flex justify-between my-2">
      <div className=" w-4/5 p-3 rounded rounded-xl bg-sky-600 text-white text-start ">
        {content}
      </div>
      <button
        className="w-1/4 text-white ms-2 rounded rounded-xl bg-red-600"
        onClick={onDelete}
      >
        delete
      </button>
    </div>
  );
};

export default Todo;
