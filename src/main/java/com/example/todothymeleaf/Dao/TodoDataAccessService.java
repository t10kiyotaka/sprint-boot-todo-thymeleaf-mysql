package com.example.todothymeleaf.Dao;

import com.example.todothymeleaf.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class TodoDataAccessService implements TodoDao {
    final private JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTodo(Todo todo) {
        final String sql = "insert into todo (id, content, is_done) values (?, ?, ?)";
        return jdbcTemplate.update(sql, todo.getId(), todo.getContent(), todo.isDone());
    }

    @Override
    public int updateTodo(Todo todo) {
        final String sql = "Update todo set content = ?, is_done = ? where id = ?";
        return jdbcTemplate.update(sql, todo.getContent(), todo.isDone(), todo.getId());
    }

    @Override
    public int deleteTodo(int id) {
        final String sql = "Delete from todo where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Todo> selectAllTodo() {
        final String sql = "select * from todo";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            boolean isDone = resultSet.getBoolean("is_done");
            return new Todo(id, content, isDone);
        });
    }

    @Override
    public Optional<Todo> findById(int id) {
        final String sql = "select * from todo where id = ?";
        Todo todo = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            int _id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            boolean isDone = resultSet.getBoolean("is_done");
            return new Todo(_id, content, isDone);
        });
        return Optional.ofNullable(todo);
    }
}
