package com.example.cicd_test.contorller;

import com.example.cicd_test.contorller.dto.TodoCreatReqeust;
import com.example.cicd_test.service.TodoService;
import com.example.cicd_test.service.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/todo")
@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoCreatReqeust reqeust) {

        TodoResponse todo = todoService.createTodo(reqeust.getTitle(),reqeust.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }
}
