package backend.server.controller;

import backend.server.entite.Todo;
import backend.server.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TodoController {
    private final TodoService todoService ;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    @CrossOrigin(origins = "http://localhost:5173" ,methods = RequestMethod.GET)
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
    @CrossOrigin(origins = "http://localhost:5173" ,methods = RequestMethod.POST)

    public ResponseEntity saveTodo(@RequestBody Todo todo){

        if(this.todoService.saveTodo(todo)){
            return ResponseEntity.ok(Map.of("message", "Enregistre avec succes"));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Échec de l'enregistrement"));
        }
    }

    @DeleteMapping("todo/{id}")
    @CrossOrigin(origins = "http://localhost:5173" ,methods = RequestMethod.DELETE)
    public Map<String,String> deleteTodo(@PathVariable int id){
        if(this.todoService.deleteTodo(id)){
            return Map.of("message" , "Supprime avec succes");
        }
        return null;
    }
}
