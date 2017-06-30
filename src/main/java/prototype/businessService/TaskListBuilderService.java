package prototype.businessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskListBuilderService {

    @Autowired
    private TaskBusinessService taskBusinessService;

    public List<Task> getAllProjectTasks(Long projectId) {

        List<Task> allTasks = taskBusinessService.getAllProjectTasks(projectId);

        List<Task> parentTasks = getParentTasks(allTasks);

        List<Task> subTasks = getSubTasks(allTasks);

        List<Task> resultList = new ArrayList<>();

        for (Task subTask: subTasks) {

            Long parentTaskId = subTask.getParentId();

            for (Task parentTask : parentTasks) {

                if (parentTask.getId() == parentTaskId){

                    resultList.add(subTask);

                }

                parentTask.setSubTasks(resultList);
            }
        }

        return parentTasks;
    }

    private List<Task> getSubTasks(List<Task> allTasks) {
        List<Task> subTasks = new ArrayList<>();
        for (Task task: allTasks) {
            Long parentId = task.getParentId();
            if (parentId != 0) {
                subTasks.add(task);
            }
        }
        return subTasks;
    }

    private List<Task> getParentTasks(List<Task> allTasks) {
        List<Task> parentTasks = new ArrayList<>();
        for (Task task : allTasks) {
            Long parentId = task.getParentId();
            if (parentId == 0) {
                parentTasks.add(task);
            }
        }
        return parentTasks;
    }

}