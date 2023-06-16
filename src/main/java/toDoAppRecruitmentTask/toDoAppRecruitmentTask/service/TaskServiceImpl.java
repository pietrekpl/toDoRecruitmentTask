package toDoAppRecruitmentTask.toDoAppRecruitmentTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.exception.ResourceNotFoundException;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id "+id+" not found"));
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            taskRepository.deleteById(id);
        }
    }

    @Override
    public Task updateTask(Long id, Task task) {
        var existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " does not exists"));
        existingTask.setTaskName(task.getTaskName());
        existingTask.setStatus(task.getStatus());
        existingTask.setDeadline(task.getDeadline());
        return taskRepository.save(existingTask);
    }

    public List<Task> searchAndSort(String taskName, String sortBy, Sort.Direction sortDirection) {
        var sort = Sort.by(sortDirection, sortBy);
        return taskRepository.findByTaskNameContainingIgnoreCase(taskName, sort);
    }
}
