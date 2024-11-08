package edu.stthomas.task_quack_server_side.service;

import org.springframework.stereotype.Service;

import edu.stthomas.task_quack_server_side.model.TaskList;
import edu.stthomas.task_quack_server_side.repository.TaskRepository;

@Service
public class ListServiceImpl implements ListService{

    private TaskRepository taskRepository;
    
    public ListServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<TaskList> list() {
        return this.taskRepository.findAll();
    }
}
