package edu.stthomas.task_quack_server_side.task.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.stthomas.task_quack_server_side.task.model.Tasks;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Long> {

    //JPQl query to find task by listId
    @Query("SELECT t FROM Tasks t WHERE t.list.id = :listId")
    List<Tasks> findByListId(@Param("listId") Integer listId);
}
