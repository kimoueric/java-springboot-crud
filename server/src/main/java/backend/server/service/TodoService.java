package backend.server.service;

import backend.server.entite.Todo;
import backend.server.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> getTodos() {
        return  this.todoRepository.findAll();
    }

    public boolean saveTodo(Todo todo) {

        try{
            Todo todoTemp = new Todo() ;
            todoTemp.setContent(todo.getContent());
            this.todoRepository.save(todoTemp) ;
            return true ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteTodo(int id) {

        try{
            Optional<Todo> todoTemp = this.todoRepository.findById(id);

            if(todoTemp.isPresent()){
                this.todoRepository.deleteById(id) ;
                return true ;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
