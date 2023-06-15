package toDoAppRecruitmentTask.toDoAppRecruitmentTask.service;

import org.springframework.data.domain.Sort;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;

import java.util.List;

public interface TaskService {
     List<Task>getAllTasks();
     Task addTask(Task task);
     void deleteTask(Long id);
     Task updateTask(Long id, Task task);
     List<Task> searchByTaskName(String taskName);
     List<Task> searchAndSort(String taskName, String SortBy, Sort.Direction sortDirection);
}
