package com.lambdaschool.javatodos.service;

import com.lambdaschool.javatodos.model.Todo;
import com.lambdaschool.javatodos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todorepo;

    @Transactional
    @Override
    public Todo save(Todo todo) {
        return todorepo.save(todo);
    }

    @Transactional
    @Override
    public Todo update(Todo todo, long id) {
        Todo newTodo = todorepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getDescription() != null)
        {
            newTodo.setDescription(todo.getDescription());
        }

        if (todo.getDate() != null)
        {
            newTodo.setDate(todo.getDate());
        }

        if(todo.isCompleted() != false)
        {
            newTodo.setCompleted(todo.isCompleted());
        }

        if (todo.getUser() != null)
        {
            newTodo.setUser(todo.getUser());
        }

        return todorepo.save(newTodo);
    }
}
