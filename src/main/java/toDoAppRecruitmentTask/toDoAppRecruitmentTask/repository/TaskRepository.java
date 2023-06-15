package toDoAppRecruitmentTask.toDoAppRecruitmentTask.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskNameContainingIgnoreCase(String taskName, Sort sort);



}
