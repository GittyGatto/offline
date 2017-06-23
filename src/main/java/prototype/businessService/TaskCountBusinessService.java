package prototype.businessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
