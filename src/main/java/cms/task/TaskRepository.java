package cms.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import cms.task.Task;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface TaskRepository extends Repository<Task, Integer> {

    @Query("SELECT DISTINCT task FROM Task task WHERE task.name LIKE :firstName%")
    @Transactional(readOnly = true)
    Collection<Task> findByFirstName(@Param("firstName") String firstName);

	void save(Task task);

}
