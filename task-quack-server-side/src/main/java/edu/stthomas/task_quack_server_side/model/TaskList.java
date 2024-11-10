package edu.stthomas.task_quack_server_side.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

    
// This tells Hibernate to make a table out of this class
@Entity
@Data
@Table(name = "List")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "List")
    private String list;

    @Column(name = "DueDate")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskList() {
        return list;
    }

    public void setTaskList(String list) {
        this.list = list;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(String date) {
        this.dueDate = LocalDate.parse(date);
    }

}
