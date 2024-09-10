package com.example.myApp.comment;

import com.example.myApp.book.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    @Id
    private String id;
    private String content;
    @DBRef
    private BookModel book;
}
