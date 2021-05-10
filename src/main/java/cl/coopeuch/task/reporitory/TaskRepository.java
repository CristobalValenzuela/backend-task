package cl.coopeuch.task.reporitory;

import org.springframework.data.repository.CrudRepository;

import cl.coopeuch.task.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
