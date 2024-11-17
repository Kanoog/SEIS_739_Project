package edu.stthomas.task_quack_server_side.list.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.stthomas.task_quack_server_side.list.ListNotFoundException;
import edu.stthomas.task_quack_server_side.list.model.Lists;
import edu.stthomas.task_quack_server_side.list.repository.ListRepo;
import edu.stthomas.task_quack_server_side.list.service.ListService;

@Service
public class ListServiceImp implements ListService {

    private ListRepo lists;

    public ListServiceImp(ListRepo repository) {
        this.lists = repository;
    }

    @Override
    public List<Lists> findAllList() {
        return lists.findAll();
    }

    @Override
    public Optional<Lists> findListById(Long listId) {
       return lists.findById(listId);
    }

    @Override
    public Lists createList(Lists content) {
        return lists.save(content);
    }

    @Override
    public Lists updateList(Lists list, Integer listId) {
        if(!lists.existsById(Long.valueOf(listId))){
            throw new ListNotFoundException();
        }
        return lists.save(list);
    }

    @Override
    public String deleteList(Integer listId) {
        lists.deleteById(Long.valueOf(listId));
        return "The content is deleted";
    }
}
