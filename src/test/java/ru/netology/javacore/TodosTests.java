package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @Test
    void testGetAllTaskMethod1() {
        Todos todos = new Todos();
        todos.addTask("домашка");
        todos.addTask("погулять");
        String result = todos.getAllTasks();
        String expected = "домашка погулять";
        Assertions.assertEquals(result, expected);
    }

    @Test
    void testGetAllTaskMethod2() {
        Todos todos = new Todos();
        todos.addTask("домашка");
        todos.addTask("погулять");
        String result = todos.getAllTasks();
        String expected = "погулять домашка";
        Assertions.assertNotEquals(result, expected);
    }

    @Test
    void testGetAllTaskMethod3() {
        Todos todos = new Todos();
        todos.addTask("домашка");
        todos.addTask("погулять");
        String result = todos.getAllTasks();
        String expected = "домашка, погулять";
        Assertions.assertNotEquals(result, expected);
    }
}
