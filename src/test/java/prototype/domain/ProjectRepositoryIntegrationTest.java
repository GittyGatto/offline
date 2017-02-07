package prototype.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import prototype.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class ProjectRepositoryIntegrationTest {

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void saveProject() {
		// given
		ProjectEntity project = createProject("saveMe");
		// when
		projectRepository.save(project);
		Long id = project.getId();
		// then
		ProjectEntity result = projectRepository.findOne(id);
		assertEquals(id, result.getId());
		assertEquals("saveMe", result.getName());
	}

	@Test
	public void getProject() {
		// given
		ProjectEntity project = createAndSaveProject("hallo");
		Long id = project.getId();
		// when
		ProjectEntity result = projectRepository.findOne(id);
		// then
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals("hallo", result.getName());
	}

	@Test
	public void updateProject() {
		// given
		ProjectEntity project = createAndSaveProject("hallo");
		Long id = project.getId();
		// when
		project.setName("ciao");
		ProjectEntity result = projectRepository.save(project);
		// then
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals("ciao", result.getName());
	}

	public void deleteProject() {
		// given
		ProjectEntity project= createAndSaveProject("hi there");
		Long id = project.getId();
		// when
		projectRepository.delete(id);
		// then
		try {
			projectRepository.findOne(id);
			fail("Expected EmptyResultDataAccessException caused by NoResultException, but non caught.");
		} catch (Exception ex) {
			assertTrue((ex instanceof EmptyResultDataAccessException));
		}
	}
	
	@Test
	public void getAllProjects() {
		// given
		// when
		Iterable<ProjectEntity> allProjects = projectRepository.findAll();
		// then
		assertNotNull(allProjects);
	}

	private ProjectEntity createAndSaveProject(String projectName) {
		ProjectEntity project = createProject(projectName);
		return projectRepository.save(project);
	}

	private ProjectEntity createProject(String projectName) {
		ProjectEntity project = new ProjectEntity();
		project.setName(projectName);
		return project;
	}
}
