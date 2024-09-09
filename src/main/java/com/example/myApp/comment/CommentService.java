package com.example.myApp.comment;

import com.example.myApp.comment.CommentModel;
import com.example.myApp.comment.CommentRepository;
import com.example.myApp.comment.dto.CommentDto;
import com.example.myApp.comment.dto.CommentMapper;
import com.example.myApp.exceptionHandler.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> getComments () {
        return commentMapper.commentsToCommentDtos(commentRepository.findAll());
    }

    public CommentDto getComment (Long id) {
        return commentMapper.commentToCommentDto(commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id)));
    }

    public CommentDto createComment (CommentDto commentDto) {
        commentRepository.save(commentMapper.commentDtoToComment(commentDto));
        return commentDto;
    }

    public CommentDto updateComment (CommentDto updatedCommentDto, Long id) {
        CommentModel comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id));
        comment.setContent(updatedCommentDto.getContent());
        comment.setBook(updatedCommentDto.getBook());
        commentRepository.save(comment);
        return commentMapper.commentToCommentDto(comment);
    }

    public void deleteComment(Long id) {
        CommentModel comment = commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no comment with id=" + id));
        commentRepository.delete(comment);
    }
}
