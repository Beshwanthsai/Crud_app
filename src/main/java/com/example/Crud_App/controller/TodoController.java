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

    @PutMapping("/todos/update/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Todo UpdateTodo(@PathVariable Long id,@RequestBody Todo todo){
        todo.setId(id);
        repo.save(todo);
        return todo;
    }

    @DeleteMapping("/todos/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteTodo(@PathVariable Long id){
        repo.deleteById(id.intValue());

    }

    @DeleteMapping("/todos/deleteall")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteAllTodos(){
        repo.deleteAll();
    }
}
