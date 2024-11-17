package edu.stthomas.task_quack_server_side.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.stthomas.task_quack_server_side.list.model.Lists;

@Repository
public interface ListRepo extends JpaRepository<Lists, Long> {

}
