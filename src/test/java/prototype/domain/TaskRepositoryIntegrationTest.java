package prototype.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import prototype.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class TaskRepositoryIntegrationTest {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void saveTask() {
		// given
		TaskEntity task = createTask("saveMe");
		// when
		taskRepository.save(task);
		Long id = task.getId();
		// then
		TaskEntity result = taskRepository.findOne(id);
		assertEquals(id, result.getId());
		assertEquals("saveMe", result.getName());
	}

	@Test
	public void getTask() {
		// given
		TaskEntity task = createAndSaveProject("hallo");
		Long id = task.getId();
		// when
		TaskEntity result = taskRepository.findOne(id);
		// then
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals("hallo", result.getName());
	}

	@Test
	public void updateTask() {
		// given
		TaskEntity task = createAndSaveProject("hallo");
		// when
		task.setName("ciao");
		TaskEntity result = taskRepository.save(task);
		// then
		assertNotNull(result);
		assertEquals(task.getId(), result.getId());
		assertEquals("ciao", result.getName());
	}

	public void deleteTask() {
		// given
		TaskEntity task = createAndSaveProject("hi there");
		Long id = task.getId();
		// when
		taskRepository.delete(id);
		// then
		try {
			taskRepository.findOne(id);
			fail("Expected EmptyResultDataAccessException caused by NoResultException, but non caught.");
		} catch (Exception ex) {
			assertTrue((ex instanceof EmptyResultDataAccessException));
		}
	}

	@Test
	public void getAllTask() {
		// given
		// when
		Iterable<TaskEntity> allTasks = taskRepository.findAll();
		// then
		assertNotNull(allTasks);
	}

	private TaskEntity createAndSaveProject(String taskName) {
		
		TaskEntity task = createTask(taskName);
		return taskRepository.save(task);
	}

	private TaskEntity createTask(String taskName) {
		TaskEntity task = new TaskEntity();
		task.setName(taskName);
		return task;
	}

}
