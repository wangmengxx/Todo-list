package com.xjtu.tudo;

import com.xjtu.tudo.controller.TodoController;
import com.xjtu.tudo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TodoTests {

    @Test

    public void Test(){
        TodoController todo = new TodoController();
        Todo tasks = todo.getTodo(1);
        assertEquals(1,tasks.getId());
        assertEquals("Restful API homework",tasks.getContent());
    }
}



