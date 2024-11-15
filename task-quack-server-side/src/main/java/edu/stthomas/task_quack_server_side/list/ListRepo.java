package edu.stthomas.task_quack_server_side.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends JpaRepository<ListContent, Long> {
    
}
