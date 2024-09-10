package com.example.myApp.comment.dto;

import com.example.myApp.book.BookModel;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private BookModel book;
}
