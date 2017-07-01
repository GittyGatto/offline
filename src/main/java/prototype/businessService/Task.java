package prototype.businessService;

import java.util.List;

public class Task {
	private long id;
	private String name;
	private long projectId;
	private long parentId;
	private Task parent;
	private List<Task> subTasks;
	private Integer subTaskCount;

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public Integer getSubTaskCount() {
		return subTaskCount;
	}

	public void setSubTaskCount(Integer subTaskCount) {
		this.subTaskCount = subTaskCount;
	}
}