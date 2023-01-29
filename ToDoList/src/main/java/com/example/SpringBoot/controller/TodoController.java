package com.example.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringBoot.model.Todo;
import com.example.SpringBoot.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listTodos",todoService.getAllTodo());
        return "index";
    }

    @GetMapping("/showNewTodoForm")
    public String showNewTodoForm(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "new_todo";
    }

    @PostMapping("/saveTodo")
    public String saveTodo(@ModelAttribute("todo") Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        Todo todo = todoService.getTodoById(id);

        model.addAttribute("todo", todo);
        return "update_todo";
    }

    @GetMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable (value = "id") long id) {

        this.todoService.deleteTodoById(id);
        return "redirect:/";
    }
}