package cl.coopeuch.task;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.coopeuch.task.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class TaskControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	private static Task mockTask;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@BeforeClass
	public static void setUpTask() {
		mockTask = new Task(0, "TaskControllerTest", new Date(), true);
	}

	@Test
	public void test01_crearTarea() throws Exception {
		String json = objectMapper.writeValueAsString(mockTask);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/task")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(json);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String taskStringJSON = result.getResponse().getContentAsString();
		Task taskInserted = objectMapper.readValue(taskStringJSON, Task.class);
		mockTask.setId(taskInserted.getId());
		json = objectMapper.writeValueAsString(mockTask);

		JSONAssert.assertEquals(json, taskStringJSON, false);
	}

	@Test
	public void test02_obtieneListaTareas() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/task").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String taskStringJSON = result.getResponse().getContentAsString();
		Task[] taskInserted = objectMapper.readValue(taskStringJSON, Task[].class);
		Assert.assertTrue(taskInserted.length > 0);
	}

	@Test
	public void test03_actualizaTarea() throws Exception {

		mockTask.setDescripcion("TaskControllerTest-Modificated");
		String json = objectMapper.writeValueAsString(mockTask);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/task")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(json);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String taskStringJSON = result.getResponse().getContentAsString();
		JSONAssert.assertEquals(json, taskStringJSON, false);
	}

	@Test
	public void test04_eliminaTarea() throws Exception {

		mockTask.setDescripcion("TaskControllerTest-Modificated");
		String json = objectMapper.writeValueAsString(mockTask);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/task")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(json);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String taskStringJSON = result.getResponse().getContentAsString();
		JSONAssert.assertEquals(json, taskStringJSON, false);
	}

}
