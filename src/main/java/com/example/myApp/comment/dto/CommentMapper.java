package com.example.myApp.comment.dto;

import com.example.myApp.comment.CommentModel;
import com.example.myApp.comment.dto.CommentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto commentToCommentDto(CommentModel comment);
    CommentModel commentDtoToComment(CommentDto commentDto);

    List<CommentDto> commentsToCommentDtos (List<CommentModel> comments);
    List<CommentModel> commentDtosToComments (List<CommentDto> commentDtos);
}
