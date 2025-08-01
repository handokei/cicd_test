package com.example.cicd_test.controller;

import com.example.cicd_test.contorller.TodoController;
import com.example.cicd_test.contorller.dto.TodoCreatReqeust;
import com.example.cicd_test.model.Todo;
import com.example.cicd_test.service.TodoService;
import com.example.cicd_test.service.dto.TodoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(controllers = TodoController.class)
@DisplayName("Todo: Controller Test")
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TodoService todoService;

    @Test
    void create() throws Exception {
        String title = "title";
        String content = "content";

        TodoCreatReqeust reqeust = new TodoCreatReqeust(title,content);

        TodoResponse todoResponse = new TodoResponse(1L, title, content);

        when(todoService.createTodo(title,content)).thenReturn(todoResponse);

        ResultActions actions = mockMvc.perform(post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reqeust)));

        actions.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("title"));
    }
}
