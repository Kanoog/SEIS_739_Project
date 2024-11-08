package edu.stthomas.task_quack_server_side.controller;

import org.springframework.web.bind.annotation.*;

import edu.stthomas.task_quack_server_side.model.TaskList;
import edu.stthomas.task_quack_server_side.repository.TaskRepository;
import edu.stthomas.task_quack_server_side.service.ListService;

// This means that this class is a RestController
@RestController
// This means URL's start with /demo (after Application path)
@RequestMapping(path = "/list")
public class ListController {

    private ListService listService;

    private TaskRepository taskRepository;
   
    public ListController(ListService listService_) {
        this.listService = listService_;
    }

    // Map ONLY POST Requests
    @PostMapping(path = "/add")
    public @ResponseBody TaskList addNewTask(@RequestParam String list, @RequestParam String dueDate) {
        // @ResponseBody means the returned Task is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        TaskList taskList = new TaskList();
        taskList.setTaskList(list);
        taskList.setDueDate(dueDate);

        taskRepository.save(taskList);
        return taskList;
    }

    @GetMapping(path = {"", "/"})
    public @ResponseBody Iterable<TaskList> getAllList() {
        // This returns a JSON or XML with the users
        return this.listService.list();
    }

}
