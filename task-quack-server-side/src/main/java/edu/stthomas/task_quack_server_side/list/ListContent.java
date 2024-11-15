package edu.stthomas.task_quack_server_side.list;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ListContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    private String list;
    
    private String tasks;

    private LocalDate dueDate;
}
