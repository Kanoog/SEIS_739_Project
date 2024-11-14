package edu.stthomas.task_quack_server_side.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/lists")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("")
    List<Task> getALL() {
        return service.findAllTask();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Task create(@RequestBody Task task) {
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Task update(@PathVariable Integer id, @RequestBody Task updateTask) {
        return service.updateTask(updateTask, id);
    }

    @DeleteMapping("/{id}")
    String delete (@PathVariable Integer id) {
        return service.deleteTask(id);
    }

}
