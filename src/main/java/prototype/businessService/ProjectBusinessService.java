package prototype.businessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prototype.domain.ProjectEntity;
import prototype.repository.ProjectRepository;

@Service
public class ProjectBusinessService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<ProjectEntity> getAllProjects(){
		return projectRepository.findAll();
	}

}
