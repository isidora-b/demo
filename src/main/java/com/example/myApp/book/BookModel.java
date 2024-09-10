package com.example.myApp.book;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    @Id
    private String id;
    private String title;
    private String author;
}
