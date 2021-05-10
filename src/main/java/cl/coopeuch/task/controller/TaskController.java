package cl.coopeuch.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.coopeuch.task.entity.Task;
import cl.coopeuch.task.service.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Iterable<Task> listaTareas() {
		return taskService.listaTareas();
	}

	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Task agregarTarea(@RequestBody Task taskIN) {
		return taskService.agregarTarea(taskIN);
	}

	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Task actualizaTarea(@RequestBody Task taskIN) {
		Task taskBD = taskService.findByID(taskIN.getId());
		if(taskBD == null) {
			return new Task();
		}
		return taskService.actualizaTarea(taskIN);
	}

	@DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Task eliminaTarea(@RequestBody Task taskIN) {
		Task taskBD = taskService.findByID(taskIN.getId());
		if(taskBD == null) {
			return new Task();
		}
		return taskService.eliminaTarea(taskIN);
	}
}
