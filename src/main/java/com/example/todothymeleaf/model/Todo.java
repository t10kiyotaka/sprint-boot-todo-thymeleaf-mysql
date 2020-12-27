package com.example.todothymeleaf.model;

public class Todo {
    private int id;
    private String content;
    private boolean isDone;

    public Todo(int id, String content, boolean isDone) {
        this.id = id;
        this.content = content;
        this.isDone = isDone;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return content;
    }

    public boolean isDone() {
        return isDone;
    }
}
