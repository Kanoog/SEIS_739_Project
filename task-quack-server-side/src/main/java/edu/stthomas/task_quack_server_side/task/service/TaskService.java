package edu.stthomas.task_quack_server_side.task.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import edu.stthomas.task_quack_server_side.task.model.Tasks;


@Service
public interface TaskService {
    
    List<Tasks> findAllTaskByListId(Integer listId);

    Tasks createTask(Integer listId, Tasks task);

    Tasks updateTask(Tasks updateTask, Integer listID, Integer taskId);

    String deleteTask(Integer id);

    void updateTaskCompletion(Object updateTask, Integer listId, Integer id);

}
