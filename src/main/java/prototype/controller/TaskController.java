package prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prototype.businessService.Task;
import prototype.businessService.TaskBusinessService;
import prototype.businessService.TaskListBuilderService;

@RestController
public class TaskController {
	@Autowired
	private TaskBusinessService taskBusinessService;

	@Autowired
	private TaskListBuilderService taskListBuilderService;

	@RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
	public Task getTask(@PathVariable("taskId") Long taskId) {
		Task task = taskListBuilderService.getTask(taskId);
		return task;
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<Task> getAllProjectTasks(Long projectId) {
		return (List<Task>) taskBusinessService.getAllProjectTasks(projectId);
	}

	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public Task saveTask(@RequestBody Task task) {
		taskBusinessService.saveTask(task);
		return task;
	}

	@RequestMapping(value = "/task/{taskId}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable("taskId") Long taskId) {
		taskBusinessService.deleteTask(taskId);
	}
}