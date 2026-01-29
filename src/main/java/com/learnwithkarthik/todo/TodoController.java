package com.learnwithkarthik.todo;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Collection<Todo> getTodos() {
        return todos.values();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Map<String, String> body) {
        Long id = counter.incrementAndGet();
        Todo todo = new Todo(id, body.get("task"));
        todos.put(id, todo);
        return todo;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todos.remove(id);
    }
}
