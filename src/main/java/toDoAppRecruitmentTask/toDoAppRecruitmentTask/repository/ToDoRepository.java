package toDoAppRecruitmentTask.toDoAppRecruitmentTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toDoAppRecruitmentTask.toDoAppRecruitmentTask.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
