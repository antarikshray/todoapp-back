package com.tw.todo.service;

import com.tw.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private List<Todo> todoList = new ArrayList<>();

    public List<Todo> getListOfTodos() {
        return todoList;
    }

    public List<Todo> add(Todo anotherTodo) {

        anotherTodo.setTodoId(todoList.size());
        todoList.add(anotherTodo);

        return todoList;
    }

    public Todo update(Todo updatedTodo) {

        todoList.removeIf(todo -> todo.getTodoId() == updatedTodo.getTodoId());
        todoList.add(updatedTodo);

        for (Todo todo : todoList) {
            if (todo.getTodoId() == updatedTodo.getTodoId()) {
                return todo;
            }
        }
        return null;
    }
}
