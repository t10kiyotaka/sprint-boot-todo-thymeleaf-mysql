package com.example.todothymeleaf.Dao;

import com.example.todothymeleaf.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeTodoDataAccessService implements TodoDao {

    private static List<Todo> DB = new ArrayList<>();

    @Override
    public int insertTodo(Todo todo) {
        DB.add(todo);
        return 1;
    }

    @Override
    public int updateTodo(Todo newTodo) {
        return findById(newTodo.getId()).map(todo -> {
            int index = DB.indexOf(todo);
            if(index >= 0) {
                DB.set(index, newTodo);
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);
    }

    @Override
    public int deleteTodo(int id) {
        boolean isDeleted = DB.removeIf(todo -> todo.getId() == id);
        return isDeleted ? 1 : 0;
    }

    @Override
    public List<Todo> selectAllTodo() {
        return DB;
    }

    @Override
    public Optional<Todo> findById(int id) {
        return DB.stream()
            .filter(todo -> todo.getId() == id)
            .findFirst();
    }
}
