package toDoAppRecruitmentTask.toDoAppRecruitmentTask.service;

import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;

import java.util.List;

public interface TaskService {

     Task addTask(Task task);
     void deleteTask(Long id);
     Task updateTask(Long id, Task task);
     List<Task> searchByTaskName(String taskName);


}
