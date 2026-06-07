package com.example.Crud_App.repo;

import com.example.Crud_App.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
