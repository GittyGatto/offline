package prototype.businessService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prototype.domain.TaskEntity;
import prototype.repository.TaskRepository;

@Service
public class TaskBusinessService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks() {
		List<TaskEntity> taskEntities = taskRepository.findAll();
		List<Task> tasks = new ArrayList<>(taskEntities.size());

		for (TaskEntity taskEntity : taskEntities) {
			tasks.add(toTask(taskEntity));
		}
		return tasks;
	}

	public List<Task> getAllProjectTasks(Long projectId) {
		List<TaskEntity> taskEntities =  taskRepository.findByProjectId(projectId);
		List<Task> tasks = new ArrayList<>(taskEntities.size());

		for (TaskEntity taskEntity : taskEntities) {
			tasks.add(toTask(taskEntity));
		}
		return tasks;
	}

	public void saveTask(TaskEntity task) {
		taskRepository.save(task);
	}
	
	private Task toTask(TaskEntity taskEntity) {
		Task task = new Task();
		task.setId(taskEntity.getId());
		task.setName(taskEntity.getName());
		task.setProjectId(taskEntity.getProject().getId());
		return task;
	}
}
