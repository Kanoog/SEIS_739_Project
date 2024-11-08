package edu.stthomas.task_quack_server_side.service;


import org.springframework.stereotype.Service;

import edu.stthomas.task_quack_server_side.model.TaskList;
@Service
public interface ListService {
  Iterable<TaskList> list();
}
