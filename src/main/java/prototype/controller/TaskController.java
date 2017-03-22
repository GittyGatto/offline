package prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prototype.businessService.Task;
import prototype.businessService.TaskBusinessService;
import prototype.domain.TaskEntity;

@RestController
public class TaskController {
	@Autowired
	private TaskBusinessService taskBusinessService;

	@RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
	public Task getTask(@PathVariable("taskId") Long taskId){
		Task task = taskBusinessService.getTask(taskId);
		return task;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> getAllProjectTasks(Long projectId) {
		return (List<Task>) taskBusinessService.getAllProjectTasks(projectId);
	}

	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public TaskEntity saveTask(@RequestBody TaskEntity task) {
		taskBusinessService.saveTask(task);
		return task;
	}
}