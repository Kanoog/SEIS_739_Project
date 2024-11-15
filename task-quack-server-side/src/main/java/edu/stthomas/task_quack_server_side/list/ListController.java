package edu.stthomas.task_quack_server_side.list;

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
public class ListController {

    private final ListService service;

    public ListController(ListService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ListContent> getALL() {
        return service.findAllList();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ListContent create(@RequestBody ListContent list) {
        return service.createList(list);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ListContent update(@PathVariable Integer id, @RequestBody ListContent updateList) {
        return service.updateList(updateList, id);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Integer id) {
        return service.deleteList(id);
    }

}
