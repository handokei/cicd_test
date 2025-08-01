package com.example.cicd_test.contorller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoCreatReqeust {

    String title;

    String content;

}
