package edu.stthomas.task_quack_server_side.list.model;

import edu.stthomas.task_quack_server_side.task.model.Tasks;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="List")
public class Lists {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer listId;

    @Column(name = "list", nullable = false)
    private String list;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tasks> tasks = new ArrayList<>();
}
