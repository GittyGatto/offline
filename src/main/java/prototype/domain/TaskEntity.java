package prototype.domain;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeq")
	@SequenceGenerator(name = "idSeq", sequenceName = "task_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private TaskEntity parent;

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public TaskEntity getParent() {
		return parent;
	}

	public void setParent(TaskEntity parent) {
		this.parent = parent;
	}

	public void setId(Long id) {
		this.id = id;
	}
}