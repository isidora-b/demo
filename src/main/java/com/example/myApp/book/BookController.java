package com.example.myApp.book;

import com.example.myApp.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getBooks () {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBook (@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public BookDto createBook (@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    public BookDto updateBook (@RequestBody BookDto updatedBookDto,@PathVariable Long id) {
        return bookService.updateBook(updatedBookDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
