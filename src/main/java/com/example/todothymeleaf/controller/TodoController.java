package com.example.todothymeleaf.controller;

import com.example.todothymeleaf.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class TodoController {

    Todo[] todos = {
        new Todo(1, "Buy milk", false),
        new Todo(2, "Buy bread", false),
        new Todo(3, "Run", false)
    };
    List<Todo> todoList = Arrays.asList(todos);

    @GetMapping("/")
    public String index(Todo todo, BindingResult result, Model model){
        model.addAttribute("todoList", todoList);
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }
}
