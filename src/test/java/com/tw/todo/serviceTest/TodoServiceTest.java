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
    void shouldBeAbleToGetAListOfTodos(){
        TodoService todoService = new TodoService();

        List<Todo> listOfTodos = new ArrayList<Todo>();

        assertThat(Objects.equals(todoService.getListOfTodos(), listOfTodos), equalTo(true));
    }

    @Test
    void shouldBeAbleToAddATaskToListOfTodos(){
        TodoService todoService = new TodoService();
        List<Todo> listOfTodos = new ArrayList<Todo>();

        Todo firstTodo = new Todo();
        todoService.add(firstTodo);
        firstTodo.setTodoId(listOfTodos.size());
        listOfTodos.add(firstTodo);

        assertThat(Objects.equals(todoService.getListOfTodos(), listOfTodos), equalTo(true));
    }

    @Test
    void shouldBeAbleToUpdateAnExistingTodo(){
        TodoService todoService = new TodoService();
        List<Todo> listOfTodos = new ArrayList<>();

        Todo firstTodo = new Todo();
        firstTodo.setTodoName("First Task");
        Todo secondTodo = new Todo();
        secondTodo.setTodoName("Second Task");
        todoService.add(firstTodo);
        todoService.add(secondTodo);
        Todo updatedTodo = new Todo();
        updatedTodo.setTodoId(1);
        updatedTodo.setTodoName("Updated Task");
        listOfTodos.add(firstTodo);
        listOfTodos.add(updatedTodo);

        todoService.update(updatedTodo);
        assertThat(Objects.equals(todoService.getListOfTodos(), listOfTodos), equalTo(true));
    }

    @Test
    void shouldBeAbleToDeleteAnExistingTodo(){
        TodoService todoService = new TodoService();

        Todo firstTodo = new Todo();
        Todo secondTodo = new Todo();
        todoService.add(firstTodo);
        todoService.add(secondTodo);
        todoService.delete(secondTodo.getTodoId());

        assertThat(todoService.getListOfTodos().contains(secondTodo), equalTo(false));
    }

    @Test
    void shouldBeAbleToReturnTheDeletedTodoOnDeletionOfExistingTodo(){
        TodoService todoService = new TodoService();
        Todo deletedTodo;

        Todo firstTodo = new Todo();
        Todo secondTodo = new Todo();
        todoService.add(firstTodo);
        todoService.add(secondTodo);
        deletedTodo = todoService.delete(secondTodo.getTodoId());

        assertThat(Objects.equals(deletedTodo,secondTodo), equalTo(true));
    }
}