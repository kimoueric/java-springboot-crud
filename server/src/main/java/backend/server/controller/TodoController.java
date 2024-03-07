package backend.server.controller;

import backend.server.entite.Todo;
import backend.server.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TodoController {
    private final TodoService todoService ;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    @CrossOrigin(origins = "localhost:5173/" ,methods = RequestMethod.GET)
    public Map<String , Object> getTodos(){
        Iterable<Todo> todos = this.todoService.getTodos();

        if (todos.iterator().hasNext()){
            return Map.of("data" ,todos ) ;
        }
        else {
            return Map.of("message" , "Pas de donnees disponibles") ;
        }


    }

    @PostMapping("todo")
    @CrossOrigin(origins = "localhost:5173/" ,methods = RequestMethod.POST)
    public Map<String,String> saveTodo(@RequestBody Todo todo){
        if(this.todoService.saveTodo(todo)){
            return Map.of("message" , "Enregistre avec succes");
        }
        return null;
    }

    @DeleteMapping("todo/{id}")
    @CrossOrigin(origins = "localhost:5173/" ,methods = RequestMethod.DELETE)
    public Map<String,String> deleteTodo(@PathVariable int id){
        if(this.todoService.deleteTodo(id)){
            return Map.of("message" , "Supprime avec succes");
        }
        return null;
    }
}
