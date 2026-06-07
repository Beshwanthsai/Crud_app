package com.example.Crud_App.controller;

import com.example.Crud_App.entity.Todo;
import com.example.Crud_App.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoRepo repo;

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        List<Todo> todos = repo.findAll();
        return todos;
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return repo.findById(id.intValue()).get() ;
    }

    @PostMapping("/todos/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todos){
        return repo.save(todos);
    }

//    @PutMapping("/todos/")
//    public Todo UpdateTodo(@Reque)
}
