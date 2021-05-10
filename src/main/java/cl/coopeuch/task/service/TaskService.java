package cl.coopeuch.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.coopeuch.task.entity.Task;
import cl.coopeuch.task.reporitory.TaskRepository;

/**
 * Clase servicio que procesa las piticiones hacia el repositorio
 * @author Cristobal Valenzuela
 *
 */
@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Iterable<Task> listaTareas() {
		return taskRepository.findAll();
	}

	public Task agregarTarea(Task taskIN) {
		return taskRepository.save(taskIN);
	}

	public Task actualizaTarea(Task taskIN) {
		return taskRepository.save(taskIN);
	}

	public Task eliminaTarea(Task taskIN) {
		taskRepository.delete(taskIN);
		return taskIN;
	}

	public Task findByID(Integer id) {
		return taskRepository.findById(id).get();
	}
}
