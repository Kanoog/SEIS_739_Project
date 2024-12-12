package edu.stthomas.task_quack_server_side.list.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.stthomas.task_quack_server_side.list.model.Lists;
import edu.stthomas.task_quack_server_side.list.service.ListService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/lists")
public class ListController {

    private final ListService service;

    public ListController(ListService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Lists> getALL() {
        return service.findAllList();
    }

    @GetMapping("/{id}")
    public Optional<Lists> getListByIdL(@PathVariable Long id) {
        return service.findListById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Lists create(@RequestBody Lists list) {
        return service.createList(list);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Lists update(@PathVariable Integer id, @RequestBody Lists updateList) {
        return service.updateList(updateList, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete (@PathVariable Integer id) {
        this.service.deleteList(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
