package com.example.myApp.comment;

import com.example.myApp.comment.CommentService;
import com.example.myApp.comment.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentDto> getComments () {
        return commentService.getComments();
    }

    @GetMapping("/{id}")
    public CommentDto getComment (@PathVariable String id) {
        return commentService.getComment(id);
    }

    @PostMapping
    public CommentDto createComment (@RequestBody CommentDto commentDto, String bookId) {
        return commentService.createComment(commentDto, bookId);
    }

    @PutMapping("/{id}")
    public CommentDto updateComment (@RequestBody CommentDto updatedCommentDto,@PathVariable String id) {
        return commentService.updateComment(updatedCommentDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id) {
        commentService.deleteComment(id);
    }
}
