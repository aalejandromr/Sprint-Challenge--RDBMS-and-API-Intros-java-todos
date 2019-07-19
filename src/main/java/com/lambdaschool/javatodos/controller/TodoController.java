package com.lambdaschool.javatodos.controller;

import com.lambdaschool.javatodos.model.Todo;
import com.lambdaschool.javatodos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PutMapping(value = "/todoid/{todoid}")
    public ResponseEntity<?> updateTodo(@Valid @RequestBody Todo todo, @PathVariable long todoid)
    {
        todoService.update(todo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
