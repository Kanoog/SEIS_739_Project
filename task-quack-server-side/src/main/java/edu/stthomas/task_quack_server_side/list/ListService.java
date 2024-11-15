package edu.stthomas.task_quack_server_side.list;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface ListService {
    
    List<ListContent> findAllList();

    ListContent createList(ListContent content);

    ListContent updateList(ListContent updateTask, Integer id);

    String deleteList(Integer id);

}
