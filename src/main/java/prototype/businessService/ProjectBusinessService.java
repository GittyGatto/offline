package prototype.businessService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prototype.domain.ProjectEntity;
import prototype.domain.TaskEntity;
import prototype.repository.ProjectRepository;
import prototype.repository.TaskRepository;

@Service
public class ProjectBusinessService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskBusinessService taskBusinessService;

	public List<Project> getAllProjects() {
		List<ProjectEntity> projectEntities = projectRepository.findAll();
		List<Project> projects = new ArrayList<>(projectEntities.size());

		for (ProjectEntity projectEntity : projectEntities) {
			projects.add(toProject(projectEntity));
		}
		return projects;
	}

	private Project toProject(ProjectEntity projectEntity) {
		Project project = new Project();
		project.setId(projectEntity.getId());
		project.setName(projectEntity.getName());
		project.setTasks(taskBusinessService.getAllProjectTasks(project.getId()));
		return project;
	}

	public void saveProject(ProjectEntity project) {
		projectRepository.save(project);
	}

	public void updateProject(ProjectEntity project) {
		projectRepository.save(project);
	}

	public void deleteProject(Long projectId) {
		projectRepository.delete(projectId);
	}

}
