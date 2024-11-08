package edu.stthomas.task_quack_server_side.repository;


import org.springframework.data.repository.CrudRepository;

import edu.stthomas.task_quack_server_side.model.TaskList;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TaskRepository extends CrudRepository<TaskList, Integer> {

}
