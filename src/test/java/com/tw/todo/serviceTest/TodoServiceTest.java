package com.tw.todo.serviceTest;

import com.tw.todo.model.Todo;
import com.tw.todo.service.TodoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class TodoServiceTest {

    @Test
    void toGetListOfTodos(){
        TodoService todoService = new TodoService();

        List<Todo> listOfTodos = new ArrayList<Todo>();

        assertThat(Objects.equals(todoService.getListOfTodos(), listOfTodos), equalTo(true));
    }

    @Test
    void toAddATaskToListOfTodos(){
        TodoService todoService = new TodoService();
        List<Todo> listOfTodos = new ArrayList<Todo>();

        Todo firstTodo = new Todo();
        todoService.add(firstTodo);
        firstTodo.setTodoId(listOfTodos.size());
        listOfTodos.add(firstTodo);

        assertThat(Objects.equals(todoService.getListOfTodos(), listOfTodos), equalTo(true));
    }
}