package com.richard.myredbook.service.impl;

import cn.hutool.core.lang.Opt;
import com.richard.myredbook.dao.CommentRepository;
import com.richard.myredbook.dao.PostRepository;
import com.richard.myredbook.entity.Comment;
import com.richard.myredbook.entity.Post;
import com.richard.myredbook.exception.BlogAPIException;
import com.richard.myredbook.exception.ResourceNotFoundException;
import com.richard.myredbook.payload.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Post post;
    private Post foreignPost;
    private Comment comment;
    private CommentDto commentDto;

    @BeforeAll
    static void beforeAll() {
        log.info("START COMMENT SERVICE TEST");
    }

    @BeforeEach
    void setUp() {

        log.info("Set up for each test.");

        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        this.foreignPost = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        this.comment = new Comment(1L, "wan qu da gong zai", "wanqu@gmail.com", "wo jue de bu hao wan", post,
                LocalDateTime.now(), LocalDateTime.now());

        this.modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(comment, CommentDto.class);
    }

    @Test
    void createComment_ResourceNotFoundException() {

        // 1. define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        // 2. execute and assertions
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));

    }

    @Test
    void createComment() {

        // 1. define behaviors
        // 1.1 retrieve the post which this comment belongs to
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        // 2. execute
        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        // 3. assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());

    }

    @Test
    void getCommentsByPostId_ResourceNotFoundException() {

        // 1. define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        // 2. execute and assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentsByPostId(1L));

    }

    @Test
    void getCommentsByPostId() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 create the expected value of getCommentsByPostId()
        List<Comment> comments = new ArrayList<>() {{add(comment);}};
        // 1.3 retrieve the comments
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        // 2. execute
        List<CommentDto> commentDtos = commentService.getCommentsByPostId(1L);

        // 3. assertion
        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(1, commentDtos.size());

        CommentDto commentResponse = commentDtos.get(0);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());

    }

    @Test
    void getCommentById_ResourceNotFoundException_post() {

        // 1. define behaviors
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1));

        // 2. execute and assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));

    }

    @Test
    void getCommentById_ResourceNotFoundException_comment() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1));

        // 2. execute and assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));

    }

    @Test
    void getCommentById() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        // 2. execute
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        // 3. assert
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());

    }

    @Test
    void updateComment_ResourceNotFoundException_post() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        // 2. execute and assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void updateComment_ResourceNotFoundException_comment() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));

        // 2. execute and assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));

    }

    @Test
    void updateComment_BlogAPIException() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(foreignPost));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        // 2. execute
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(2L, 1L, commentDto));

    }

    @Test
    void updateComment() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.3 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        // 2. execute
        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        // 3. assert
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());

    }

    @Test
    void deleteComment() {

        // 1. define behaviors
        // 1.1 retrieve the post
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        // 1.2 retrieve the comment
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        // 2. execute
        commentService.deleteComment(1L, 1L);

        // 3. assert
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }
}