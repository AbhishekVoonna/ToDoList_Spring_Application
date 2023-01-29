package com.example.SpringBoot.service;
import java.util.List;

import com.example.SpringBoot.model.Todo;

public interface TodoService {
    List<Todo> getAllTodo();
    void saveTodo(Todo todo);
    Todo getTodoById(long id);
    void deleteTodoById(long id);
}