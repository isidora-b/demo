package com.example.myApp.comment;

import com.example.myApp.book.BookModel;
import com.example.myApp.book.BookRepository;
import com.example.myApp.book.dto.BookDto;
import com.example.myApp.comment.CommentModel;
import com.example.myApp.comment.CommentRepository;
import com.example.myApp.comment.dto.CommentDto;
import com.example.myApp.comment.dto.CommentMapper;
import com.example.myApp.exceptionHandler.BookNotFoundException;
import com.example.myApp.exceptionHandler.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> getComments () {
        return commentMapper.commentsToCommentDtos(commentRepository.findAll());
    }

    public CommentDto getComment (String id) {
        return commentMapper.commentToCommentDto(commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id)));
    }

    public CommentDto createComment (CommentDto commentDto, String bookId) {
        BookModel book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("There is no book with id=" + bookId));
        commentDto.setBook(book);
        commentRepository.save(commentMapper.commentDtoToComment(commentDto));
        return commentDto;
    }

    public CommentDto updateComment (CommentDto updatedCommentDto, String id) {
        CommentModel comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id));
        comment.setContent(updatedCommentDto.getContent());
        comment.setBook(updatedCommentDto.getBook());
        commentRepository.save(comment);
        return commentMapper.commentToCommentDto(comment);
    }

    public void deleteComment(String id) {
        CommentModel comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id));
        commentRepository.delete(comment);
    }
}
