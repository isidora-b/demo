package com.example.myApp.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
}
