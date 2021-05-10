package cl.coopeuch.task;

import java.util.Date;

import org.springframework.context.annotation.Bean;

import cl.coopeuch.task.entity.Task;

public class TaskTest {

	@Bean
	public Task obtieneTask() {
		return  new Task(0, "TaskControllerTest", new Date(), true);
	}
}
