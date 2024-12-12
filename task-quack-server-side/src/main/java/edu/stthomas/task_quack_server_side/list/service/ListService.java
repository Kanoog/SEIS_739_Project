package edu.stthomas.task_quack_server_side.list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.stthomas.task_quack_server_side.list.model.Lists;


@Service
public interface ListService {
    
    List<Lists> findAllList();

    Optional<Lists> findListById(Long listId);

    Lists createList(Lists task);

    Lists updateList(Lists list, Integer id);

    void deleteList(Integer id);

}
