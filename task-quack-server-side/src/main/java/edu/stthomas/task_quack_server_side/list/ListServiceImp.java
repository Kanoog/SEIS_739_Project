package edu.stthomas.task_quack_server_side.list;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImp implements ListService {

    private ListRepo lists;

    public ListServiceImp(ListRepo repository) {
        this.lists = repository;
    }

    @Override
    public List<ListContent> findAllList() {
        return lists.findAll();
    }

    @Override
    public ListContent createList(ListContent content) {
        return lists.save(content);
    }

    @Override
    public ListContent updateList(ListContent updateTask, Integer id) {
        return lists.save(updateTask);
    }

    @Override
    public String deleteList(Integer id) {
        lists.deleteById(Long.valueOf(id));
        return "The Task is deleted";
    }

}
