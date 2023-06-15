package toDoAppRecruitmentTask.toDoAppRecruitmentTask.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.service.TaskService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600,
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT})
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        log.info("in method addTask(). Takes body: {}", task);
        return taskService.addTask(task);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        log.info("in method updateTask(). Takes id: {}", id);
        return taskService.updateTask(id, task);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteTask(Long id) {
        log.info("in method deleteTask(). Takes id: {}", id);
        taskService.deleteTask(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Task> getSearchedListOrAllEmployees(
            @RequestParam(value = "taskName", required = false, defaultValue = "")String taskName,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") Sort.Direction sortDirection) {
        log.info("in method getSearchedListOrAllEmployees()");
        return taskService.searchAndSort(taskName, sortBy, sortDirection);
    }


}
