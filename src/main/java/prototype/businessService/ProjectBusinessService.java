package prototype.businessService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prototype.domain.ProjectEntity;
import prototype.repository.ProjectRepository;

@Service
public class ProjectBusinessService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskBusinessService taskBusinessService;

	@Autowired
	private TaskCountBusinessService taskCountBusinessService;

	@Autowired
	private TaskListBuilderService taskListBuilderService;

	public List<Project> getAllProjects() {
		List<ProjectEntity> projectEntities = projectRepository.findAll();
		List<Project> projects = new ArrayList();

		for (ProjectEntity projectEntity : projectEntities) {
			projects.add(toProject(projectEntity));
		}
		return projects;
	}

	private Project toProject(ProjectEntity projectEntity) {
		Project project = new Project();
		project.setId(projectEntity.getId());
		project.setName(projectEntity.getName());
		project.setTasks(taskListBuilderService.getAllParentTasks(project.getId()));
		project.setTaskCount(taskCountBusinessService.getTaskCount(project.getId()));
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

	public Project getProject(Long projectId) {
		ProjectEntity projectEntity = projectRepository.findOne(projectId);
		Project project = toProject(projectEntity);
		return project;
	}
	
	public ProjectEntity getProjectEntity(Long id){
		return projectRepository.findOne(id);
	}

}
