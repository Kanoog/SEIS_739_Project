package edu.stthomas.task_quack_server_side.task;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService {

    private TaskRepo lists;

    public TaskServiceImp(TaskRepo repository) {
        this.lists = repository;
    }

    @Override
    public List<Task> findAllTask() {
        return lists.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return lists.save(task);
    }

    @Override
    public Task updateTask(Task updateTask, Integer id) {
        return lists.save(updateTask);
    }

    @Override
    public String deleteTask(Integer id) {
        lists.deleteById(Long.valueOf(id));
        return "The Task is deleted";
    }

}
