package prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prototype.businessService.ProjectBusinessService;
import prototype.domain.ProjectEntity;

@RestController
public class ProjectController {
	@Autowired
	private ProjectBusinessService projectBusinessService;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<ProjectEntity> getAllProjects() 
	{
		return (List<ProjectEntity>) projectBusinessService.getAllProjects();
	}
}