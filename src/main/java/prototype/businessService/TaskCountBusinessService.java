package prototype.businessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prototype.domain.TaskEntity;

import java.util.List;

@Service
public class TaskCountBusinessService {

    @Autowired
    private TaskBusinessService taskBusinessService;

    public Integer getTaskCount(Long projectId) {
        List<Task> tasks = taskBusinessService.getAllProjectTasks(projectId);
        if (tasks!= null){
            return tasks.size();
        }
        return 0;
    }

    public Integer getSubtaskCount(Long taskId){
        List<TaskEntity> subtask = taskBusinessService.getAllSubtasks(taskId);
        if (subtask != null){
            return subtask.size();
        }
        return 0;
    }
}
