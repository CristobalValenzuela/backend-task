package cl.coopeuch.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TaskApp {

	public static void main(String[] args) {
		SpringApplication.run(TaskApp.class, args);
	}
}
