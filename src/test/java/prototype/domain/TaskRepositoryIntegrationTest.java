package prototype.domain;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import prototype.repository.ProjectRepository;
import prototype.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class TaskRepositoryIntegrationTest {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectRepository projectRepository;

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
		TaskEntity task = createAndSaveTask("hallo");
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
		TaskEntity task = createAndSaveTask("hallo");
		// when
		task.setName("ciao");
		TaskEntity result = taskRepository.save(task);
		// then
		assertNotNull(result);
		assertEquals(task.getId(), result.getId());
		assertEquals("ciao", result.getName());
	}

	@Test
	public void deleteTask() {
		// given
		ProjectEntity project = createAndSaveProject("right");
		TaskEntity task = createAndSaveProjectTask("task", project);
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

	@Test
	public void getAllTasksByProjectId() {
		// given
		ProjectEntity rightProject = createAndSaveProject("right");
		TaskEntity task1 = createAndSaveProjectTask("task1", rightProject);
		TaskEntity task2 = createAndSaveProjectTask("task2", rightProject);
		ProjectEntity wrongProject = createAndSaveProject("wrong");
		TaskEntity task3 = createAndSaveProjectTask("task3", wrongProject);
		List<TaskEntity> resultTasks = new ArrayList<TaskEntity>();
		resultTasks.add(task1);
		resultTasks.add(task2);
				
		// when
		Long projectId = rightProject.getId();
		List<TaskEntity> tasks = taskRepository.findByProjectId(projectId);
		
		// then
		assertThat(tasks, is(resultTasks));
		assertThat(tasks, hasItems(task1));
		assertThat(tasks, hasItems(task2));
		assertThat(tasks.size(), is(2));
		assertThat(tasks, contains(task1, task2));
		assertThat(tasks, containsInAnyOrder(task2, task1));
		assertThat(tasks, not(IsEmptyCollection.empty()));		
	}

	private TaskEntity createAndSaveProjectTask(String name, ProjectEntity project) {
		TaskEntity task = new TaskEntity();
		task.setName(name);
		task.setProject(project);
		taskRepository.save(task);
		return task;
	}

	private TaskEntity createAndSaveTask(String taskName) {
		TaskEntity task = createTask(taskName);
		return taskRepository.save(task);
	}

	private TaskEntity createTask(String taskName) {
		TaskEntity task = new TaskEntity();
		task.setName(taskName);
		return task;
	}

	private ProjectEntity createAndSaveProject(String name) {
		ProjectEntity project = new ProjectEntity();
		project.setName(name);
		projectRepository.save(project);
		return project;
	}
}
