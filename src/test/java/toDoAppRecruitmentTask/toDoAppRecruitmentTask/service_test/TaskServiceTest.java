package toDoAppRecruitmentTask.toDoAppRecruitmentTask.service_test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.repository.TaskRepository;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.service.TaskServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    public void shouldAddNewTask() {

        //given
        var task = new Task();
        task.setTaskName("Task1");
        //when
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        var addedTask = taskService.addTask(task);
        //then
        assertThat(addedTask).isNotNull();
        assertThat(addedTask.getTaskName()).isEqualTo(task.getTaskName());
        verify(taskRepository, times(1)).save(task);
    }
    @Test
    public void shouldUpdateTask() {

        //given
        var existingTask = new Task();
        var taskId = 1L;
        existingTask.setId(taskId);
        existingTask.setTaskName("Task1");

        var updatedTask = new Task();
        updatedTask.setId(taskId);
        updatedTask.setTaskName("Task1 after update");

        //when
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);
        var taskAfterUpdate = taskService.updateTask(taskId, updatedTask);

        //then
        assertThat(taskAfterUpdate).isNotNull();
        assertThat(taskAfterUpdate.getTaskName()).isEqualTo(updatedTask.getTaskName());

        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(existingTask);

    }
}
