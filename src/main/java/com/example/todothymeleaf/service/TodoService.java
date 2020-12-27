package com.example.todothymeleaf.service;

import com.example.todothymeleaf.Dao.TodoDao;
import com.example.todothymeleaf.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoDao todoDao;

    @Autowired
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public int addTodo(Todo todo) {
        return todoDao.insertTodo(todo);
    }

    public int update(Todo todo) {
        return todoDao.updateTodo(todo);
    }

    public int deleteTodo(int id) {
        return todoDao.deleteTodo(id);
    }

    public Optional<Todo> findById(int id) {
        return todoDao.findById(id);
    }

    public List<Todo> selectAllTodo() {
        return todoDao.selectAllTodo();
    }
}
