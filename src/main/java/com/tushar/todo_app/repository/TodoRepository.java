package com.tushar.todo_app.repository;

import com.tushar.todo_app.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo,String> {
    List<Todo> findTodosByUserid(String userid);
    Todo findTodosByTodoid(String todoid);
}
