package toDoAppRecruitmentTask.toDoAppRecruitmentTask.service;

import org.springframework.data.domain.Sort;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
     Task getTaskById(Long id);
     Task addTask(Task task);
     void deleteTask(Long id);
     Task updateTask(Long id, Task task);
     List<Task> searchAndSort(String taskName, String SortBy, Sort.Direction sortDirection);
}
