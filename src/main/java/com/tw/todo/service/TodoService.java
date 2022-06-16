package com.tw.todo.service;

import com.tw.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private List<Todo> todoList = new ArrayList<>();

    public List<Todo> getListOfTodos() {
        return todoList;
    }
}
