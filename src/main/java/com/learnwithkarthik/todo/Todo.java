package com.learnwithkarthik.todo;

public class Todo {

    private Long id;
    private String task;

    public Todo(Long id, String task) {
        this.id = id;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }
}
