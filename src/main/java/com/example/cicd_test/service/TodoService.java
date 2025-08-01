package com.example.cicd_test.service;

import com.example.cicd_test.contorller.dto.TodoCreatReqeust;
import com.example.cicd_test.model.Todo;
import com.example.cicd_test.repository.TodoRepository;
import com.example.cicd_test.service.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {


    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponse createTodo(String title, String content) {
        Todo todo = Todo.create(title, content);

        Todo save = todoRepository.save(todo);
        return TodoResponse.from(save);
    }
}
