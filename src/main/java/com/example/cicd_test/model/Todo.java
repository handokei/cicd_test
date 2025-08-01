package com.example.cicd_test.model;

import com.example.cicd_test.config.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends BaseEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    public static Todo create(String title, String content) {
        Todo todo = new Todo();
        todo.title = title;
        todo.content = content;
        return todo;
    }
}
