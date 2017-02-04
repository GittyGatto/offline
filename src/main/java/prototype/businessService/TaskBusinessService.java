package prototype.businessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prototype.domain.TaskEntity;
import prototype.repository.TaskRepository;

@Service
public class TaskBusinessService {

	@Autowired
	private TaskRepository taskRepository;

	public List<TaskEntity> getAllTasks() {
		return (List<TaskEntity>) taskRepository.findAll();
	}

	public List<TaskEntity> getAllProjectTasks(Long projectId) {
		return (List<TaskEntity>) taskRepository.findByProjectId(projectId);
	}
}
