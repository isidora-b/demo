package com.example.myApp.comment.dto;

import com.example.myApp.book.BookModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private BookModel book;
}
