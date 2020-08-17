package com.tushar.todo_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {
    @Id
    String todoid;
    String message;
    String userid;

    public Todo() {
    }

    public Todo(String todoid, String message, String userid) {
        this.todoid = todoid;
        this.message = message;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoid='" + todoid + '\'' +
                ", message='" + message + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getTodoid() {
        return todoid;
    }

    public void setTodoid(String todoid) {
        this.todoid = todoid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
