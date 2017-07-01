package prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prototype.domain.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

	List<TaskEntity> findByProjectId(Long projectId);

	List<TaskEntity> findByParentId(Long parentId);
	
}
