package edu.stthomas.task_quack_server_side.task.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.stthomas.task_quack_server_side.common.exception.ResourceNotFoundException;
import edu.stthomas.task_quack_server_side.list.model.Lists;
import edu.stthomas.task_quack_server_side.list.repository.ListRepo;
import edu.stthomas.task_quack_server_side.task.model.Tasks;
import edu.stthomas.task_quack_server_side.task.repository.TaskRepo;
import edu.stthomas.task_quack_server_side.task.service.TaskService;

@Service
public class TaskServiceImp implements TaskService {

    private String LIST_NOT_FOUND = "List not found with list ID: ";
    private String TASK_NOT_FOUND = "Task not found with task ID: ";


    private TaskRepo tasks;
    private ListRepo list;

    public TaskServiceImp(TaskRepo taskRepo, ListRepo listRepo) {
        this.tasks = taskRepo;
        this.list = listRepo;
    }

    @Override
    public List<Tasks> findAllTaskByListId(Integer listId) {
        Optional<Lists> existingList = list.findById(Long.valueOf(listId));
        if (!existingList.isPresent()) {
            throw new ResourceNotFoundException(LIST_NOT_FOUND + listId);
        }
        return tasks.findByListId(listId);
    }

    @Override
    public Tasks createTask(Integer listId, Tasks task) {
        Optional<Lists> existingList = list.findById(Long.valueOf(listId));
        if (!existingList.isPresent()) {
            throw new ResourceNotFoundException(LIST_NOT_FOUND + listId);
        }
        Lists referenceList = existingList.get();
        task.setList(referenceList);

        return tasks.save(task);
    }

    @Override
    public Tasks updateTask(Tasks updateTask,Integer listId, Integer id) {
        Optional<Lists> existingList = list.findById(Long.valueOf(listId));
       
        if (!existingList.isPresent()) {
            throw new ResourceNotFoundException(LIST_NOT_FOUND + listId);
        }
        if (!tasks.existsById(Long.valueOf(id))) {
            throw new ResourceNotFoundException(TASK_NOT_FOUND + id);
        }

        Tasks task = tasks.findById(Long.valueOf(id)).get();

        if(!task.getTask().equals(updateTask.getTask())){
            task.setTask(updateTask.getTask());
        }
        if(!task.getDueDate().equals(updateTask.getDueDate())){
            task.setDueDate(updateTask.getDueDate());
        }
        return tasks.save(task);
    }

    @Override
    public String deleteTask(Integer id) {
        tasks.deleteById(Long.valueOf(id));
        return "The task is deleted";
    }

}
