package com.tushar.todo_app.repository;

import com.tushar.todo_app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findUserByEmail(String email);
}
