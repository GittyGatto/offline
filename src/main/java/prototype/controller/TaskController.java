package prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prototype.businessService.TaskBusinessService;
import prototype.domain.ProjectEntity;
import prototype.domain.TaskEntity;

@RestController
public class TaskController {
	@Autowired
	private TaskBusinessService taskBusinessService;

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public List<TaskEntity> getAllTasks() {
		return (List<TaskEntity>) taskBusinessService.getAllTasks();
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<TaskEntity> getAllProjectTasks(Long projectId) {
		return (List<TaskEntity>) taskBusinessService.getAllProjectTasks(projectId);
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public TaskEntity saveTask(@RequestBody TaskEntity task) {
		taskBusinessService.saveTask(task);
		return task;
	}
}