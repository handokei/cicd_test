package com.example.cicd_test.service;

import com.example.cicd_test.model.Todo;
import com.example.cicd_test.repository.TodoRepository;
import com.example.cicd_test.service.dto.TodoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;
    @Test
    void save() {
        // Given
        //테스트 전제 조건 및 환경 설정
        String title = "title";
        String content = "content";
        Todo todo = Todo.create(title, content);

        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
       // When
        //실행할 행동
        TodoResponse todoResponse = todoService.createTodo(title, content);

        // Then
        //검증 사항
        assertThat(todoResponse).isNotNull();
        assertThat(todoResponse.getTitle()).isEqualTo(title);
        assertThat(todoResponse.getContent()).isEqualTo(content);
    }
}
