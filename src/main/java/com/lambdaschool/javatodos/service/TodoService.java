package com.lambdaschool.javatodos.service;

import com.lambdaschool.javatodos.model.Todo;

public interface TodoService {
    Todo save(Todo todo);
    Todo update(Todo todo, long id);
}
