package prototype.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
}
