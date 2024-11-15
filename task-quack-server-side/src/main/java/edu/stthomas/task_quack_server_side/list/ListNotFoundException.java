package edu.stthomas.task_quack_server_side.list;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ListNotFoundException extends RuntimeException {

    public ListNotFoundException(){
        super("List Not Found");
    }
}
