package edu.stthomas.task_quack_server_side.task.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.stthomas.task_quack_server_side.task.model.Tasks;
import edu.stthomas.task_quack_server_side.task.service.TaskService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/lists/{listId}/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
   }

    @GetMapping("")
    public List<Tasks> getALL(@PathVariable Integer listId) {
        return service.findAllTaskByListId(listId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Tasks create(@PathVariable Integer listId, @RequestBody Tasks task) {
        return service.createTask(listId, task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Tasks update(@PathVariable Integer listId, @PathVariable Integer id, @RequestBody Tasks updateTask) {
        return service.updateTask(updateTask, listId, id);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<HttpStatus> updateTaskComplete(@PathVariable Integer listId, @PathVariable Integer id, @RequestBody Object updateTask) {
        this.service.updateTaskCompletion(updateTask, listId, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return service.deleteTask(id);
    }

}
