package com.example.myApp.book.dto;
import com.example.myApp.book.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto bookToBookDto(BookModel book);
    BookModel bookDtoToBook(BookDto bookDto);

    List<BookDto> booksToBookDtos (List<BookModel> books);
    List<BookModel> bookDtosToBooks (List<BookDto> bookDtos);
}
