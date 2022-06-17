package com.tw.todo.service;

import com.tw.exceptions.TodoDoesntExistException;
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

    public Todo update(Todo updatedTodo) throws TodoDoesntExistException {

        boolean flag = true;
        for(Todo todo: todoList){
            if(todo.getTodoId() == updatedTodo.getTodoId()){
                flag=false;
                break;
            }
        }
        if(flag){
            throw new TodoDoesntExistException();
        }

        todoList.removeIf(todo -> todo.getTodoId() == updatedTodo.getTodoId());
        todoList.add(updatedTodo);

        for (Todo todo : todoList) {
            if (todo.getTodoId() == updatedTodo.getTodoId()) {
                return todo;
            }
        }

        return null;
    }

    public Todo delete(int todoId) throws TodoDoesntExistException {
        Todo deletedTodo = null;

        for(Todo todo: todoList){
            if(todo.getTodoId() == todoId){
                deletedTodo = todo;
            }
        }

        if(deletedTodo == null){
            throw new TodoDoesntExistException();
        }

        todoList.removeIf(todo -> todo.getTodoId() == todoId);

        return deletedTodo;
    }
}
