package prototype.businessService;

import java.util.List;

import prototype.domain.TaskEntity;

public class Project {
	private Long id;
	private String name;
	private List<Task> tasks;
	private Integer taskCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount){
		this.taskCount = taskCount;
	}
}
