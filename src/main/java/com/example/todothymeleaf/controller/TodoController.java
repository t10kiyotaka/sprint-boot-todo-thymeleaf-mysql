package com.example.todothymeleaf.controller;

import com.example.todothymeleaf.model.Todo;
import com.example.todothymeleaf.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Todo todo, BindingResult result, Model model){
        model.addAttribute("todoList", todoService.selectAllTodo());
        return "index";
    }

    /**
     * Make 3 tasks (for test use)
     */
    @PostMapping("/init")
    public String initTodo() {
        Todo[] todos = {
            new Todo(1, "Buy milk", false),
            new Todo(2, "Buy bread", false),
            new Todo(3, "Run", false)
        };
        for(Todo todo : todos) {
            todoService.addTodo(todo);
        }
        return "redirect:/";
    }

    @PostMapping("/")
    public String addTodo(Todo todo, BindingResult result, Model model) {
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/{id}/update")
    public String updateTodo(Todo todo, BindingResult result, Model model) {
        todoService.update(todo);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}
