package prototype.businessService;

public class Task {
	private long id;
	private String name;
	private long projectId;
	private Integer percentageCompleted;
	
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

	public Integer getPercentageCompleted() {
		return percentageCompleted;
	}

	public void setPercentageCompleted(Integer percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}
}
