package com.learnwithkarthik.todo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    // Get all todos
    @GetMapping
    public Collection<Todo> getTodos() {
        return todos.values();
    }

    // Add a new todo
    @PostMapping
    public Todo addTodo(@RequestBody Map<String, String> body) {
        Long id = counter.incrementAndGet();
        Todo todo = new Todo(id, body.get("task"));
        todos.put(id, todo);
        return todo;
    }

    // Delete a todo by id
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todos.remove(id);
    }
}

