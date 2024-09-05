package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDTO {

    private Long tno; //게시글 번호

    private String writer; //게시글 작성자

    private String title; //게시글 제목

    private String content; //게시글 내용
}
