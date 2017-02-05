package prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prototype.businessService.ProjectBusinessService;
import prototype.domain.ProjectEntity;

@RestController
public class ProjectController {
	@Autowired
	private ProjectBusinessService projectBusinessService;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public List<ProjectEntity> getAllProjects() {
		return (List<ProjectEntity>) projectBusinessService.getAllProjects();
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ProjectEntity saveProject(@RequestBody ProjectEntity project) {
		projectBusinessService.saveProject(project);
		return project;
	}

	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	public void updateProject(@RequestBody ProjectEntity project) {
		projectBusinessService.updateProject(project);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable("id") Long projectId) {
		projectBusinessService.deleteProject(projectId);
	}
}