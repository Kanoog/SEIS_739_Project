package edu.stthomas.task_quack_server_side.task;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface TaskService {
    
    List<Task> findAllTask();

    Task createTask(Task task);

    Task updateTask(Task updateTask, Integer id);

    String deleteTask(Integer id);

}
