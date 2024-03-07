package backend.server.repository;


import backend.server.entite.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository  extends CrudRepository<Todo , Integer> {
}
