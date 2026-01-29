package com.learnwithkarthik.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class TodoUiController {

    private final TodoController todoController;

    public TodoUiController(TodoController todoController) {
        this.todoController = todoController;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        Collection<Todo> todos = todoController.getTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task) {
        todoController.addTodo(Map.of("task", task));
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoController.deleteTodo(id);
        return "redirect:/";
    }

}

