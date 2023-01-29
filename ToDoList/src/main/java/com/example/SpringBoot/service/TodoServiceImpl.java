package com.example.SpringBoot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringBoot.model.Todo;
import com.example.SpringBoot.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public void saveTodo(Todo todo) {
        this.todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(long id) {
        Optional<Todo> optional = todoRepository.findById(id);
        Todo todo = null;
        if (optional.isPresent()) {
            todo = optional.get();
        } else {
            throw new RuntimeException(" Todo not found for id :: " + id);
        }
        return todo;
    }

    @Override
    public void deleteTodoById(long id) {
        this.todoRepository.deleteById(id);
    }
}