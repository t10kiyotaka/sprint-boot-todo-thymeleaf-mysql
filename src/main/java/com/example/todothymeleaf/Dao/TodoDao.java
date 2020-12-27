package com.example.todothymeleaf.Dao;

import com.example.todothymeleaf.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDao {
    int insertTodo(Todo todo);

    int updateTodo(Todo todo);

    int deleteTodo(int id);

    List<Todo> selectAllTodo();

    Optional<Todo> findById(int id);
}
