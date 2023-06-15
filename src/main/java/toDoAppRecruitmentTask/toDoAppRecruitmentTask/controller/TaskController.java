package toDoAppRecruitmentTask.toDoAppRecruitmentTask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.RequestCounter;
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

    private final RequestCounter requestCounter;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task addTask(@Valid @RequestBody Task task) {
        log.info("in method addTask(). Takes body: {}", task);
        requestCounter.increment();
        return taskService.addTask(task);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        log.info("in method updateTask(). Takes id: {}", id);
        requestCounter.increment();
        return taskService.updateTask(id, task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        log.info("in method deleteTask(). Takes id: {}", id);
        requestCounter.increment();
        taskService.deleteTask(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Task> getSearchedListOrAllEmployees(
            @RequestParam(value = "taskName", required = false, defaultValue = "") String taskName,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") Sort.Direction sortDirection) {
        log.info("in method getSearchedListOrAllEmployees()");
        requestCounter.increment();
        return taskService.searchAndSort(taskName, sortBy, sortDirection);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/counter")
    public int getCountedRequests() {
       return requestCounter.getCount();
    }


}
