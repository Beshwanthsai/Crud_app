package com.example.Crud_App.controller;

import com.example.Crud_App.entity.Todo;
import com.example.Crud_App.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
