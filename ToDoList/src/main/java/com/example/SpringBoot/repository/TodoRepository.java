package com.example.SpringBoot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}