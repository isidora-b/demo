package com.example.myApp.book;

import com.example.myApp.book.dto.BookDto;
import com.example.myApp.book.dto.BookMapper;
import com.example.myApp.exceptionHandler.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getBooks () {
        return bookMapper.booksToBookDtos(bookRepository.findAll());
    }

    public BookDto getBook (String id) {
        return bookMapper.bookToBookDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("There is no book with id=" + id)));
    }

    public BookDto createBook (BookDto bookDto) {
        bookRepository.save(bookMapper.bookDtoToBook(bookDto));
        return bookDto;
    }

    public BookDto updateBook (BookDto updatedBookDto, String id) {
        BookModel book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("There is no book with id=" + id));
        book.setTitle(updatedBookDto.getTitle());
        book.setAuthor(updatedBookDto.getAuthor());
        bookRepository.save(book);
        return bookMapper.bookToBookDto(book);
    }

    public void deleteBook(String id) {
        BookModel book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("There is no book with id=" + id));
        bookRepository.delete(book);
    }
}
