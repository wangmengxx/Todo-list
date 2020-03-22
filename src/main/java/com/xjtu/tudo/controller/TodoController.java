package com.xjtu.tudo.controller;

import com.xjtu.tudo.domain.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class TodoController {
    private ArrayList<Todo> arrayList = new ArrayList<>();

    public TodoController() {
        this.arrayList = generateData();
    }


    @GetMapping(value = "tasks")
    public ArrayList<Todo> getTask() {
        return arrayList;
    }

    @PostMapping(value = "tasks")
    public String postTodo(Todo todo) {
        arrayList.add(todo);
        return "success";
    }

    @GetMapping(value = "tasks/{id}")
    public Todo getTodo(@PathVariable("id") int id) {
        for (Todo td : arrayList
        ) {
            if (td.getId() == id) {
                return td;
            }
        }
        return null;
    }

    @DeleteMapping(value = "tasks/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        for (Todo td : arrayList
        ) {
            if (td.getId() == id) {
                arrayList.remove(td);
                return "success";
            }
        }
        return "error";
    }

    private ArrayList<Todo> generateData() {
        for (int i = 1; i <= 10; i++) {
            Todo todo = new Todo();
            todo.setId(i);
            todo.setContent("Restful API homework");
            todo.setCreatedTime(new Date().toString());
            arrayList.add(todo);
        }
        return arrayList;
    }

}

