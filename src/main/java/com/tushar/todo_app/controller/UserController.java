package com.tushar.todo_app.controller;

import com.tushar.todo_app.model.Todo;
import com.tushar.todo_app.repository.TodoRepository;
import com.tushar.todo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    final
    UserRepository userRepository;
    final
    TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "Login";
    }

    @GetMapping("/")
    public String home(Principal principal, Model model){
        List<Todo> todoList=todoRepository.findTodosByUserid(principal.getName());
        model.addAttribute("todolist",todoList);
        return "index";
    }
    @GetMapping("/addtodo")
    public String addtodo(@RequestParam String message,Principal principal){
        this.todoRepository.save(new Todo(null,message,principal.getName()));
        return "redirect:/";
    }
    @GetMapping("/remove/{todoid}")
    public String removetodo(@PathVariable String todoid,Principal principal){
        Todo todo=todoRepository.findTodosByTodoid(todoid);
        if(todo.getUserid().equals(principal.getName())){
            todoRepository.delete(todo);
        }
        return "redirect:/";
    }
}
