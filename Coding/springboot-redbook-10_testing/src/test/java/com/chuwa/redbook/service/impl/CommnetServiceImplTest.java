package com.chuwa.redbook.service.impl;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;


import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);
    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;
    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    private Post post;
    private Comment comment, comment2;
    private List<Comment> comments;
    private CommentDto commentDto;
    private CommentDto commentDto2;

    @BeforeEach
    void setUp() {
        logger.info("set up Post and comment for each test");
        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L, "name", "email", "body");
        this.comment2 = new Comment(2L, "name2", "email2", "body2");
        comment.setPost(post);
        comment2.setPost(post);
        comments = new ArrayList<>();
        this.comments.add(comment);
        this.comments.add(comment2);
        this.modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(comment, CommentDto.class);
        this.commentDto2 = modelMapper.map(comment2, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        //define the behaviors
        when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        //execute
        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        //assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());


    }

    @Test
    void testGetCommentsByPostId() {
        //define the behaviors
        when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        //execute
        List<CommentDto> commentDtos = commentService.getCommentsByPostId(1L);

        //assertions
        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(2, commentDtos.size());

        CommentDto commentResponse1 = commentDtos.get(0);
        CommentDto commentResponse2 = commentDtos.get(1);

        Assertions.assertEquals(commentResponse1.getId(), commentDto.getId());
        Assertions.assertEquals(commentResponse2.getId(), commentDto2.getId());

        Assertions.assertEquals(commentResponse1.getName(), commentDto.getName());
        Assertions.assertEquals(commentResponse2.getName(), commentDto2.getName());

        Assertions.assertEquals(commentResponse1.getEmail(), commentDto.getEmail());
        Assertions.assertEquals(commentResponse2.getEmail(), commentDto2.getEmail());

        Assertions.assertEquals(commentResponse1.getBody(), commentDto.getBody());
        Assertions.assertEquals(commentResponse2.getBody(), commentDto2.getBody());
    }

    @Test
    void testGetCommentById() {
        //define the behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        //execute
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);

        //assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentResponse.getId(), commentDto.getId());
        Assertions.assertEquals(commentResponse.getName(), commentDto.getName());
        Assertions.assertEquals(commentResponse.getEmail(), commentDto.getEmail());
        Assertions.assertEquals(commentResponse.getBody(), commentDto.getBody());
    }

    @Test
    void testGetCommentById_BlogAPIException() {
        comment.setPost(new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        //define the behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        //execute and assertions
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testUpdateComment() {
        String body = "UPDATED -" + comment.getBody();
        commentDto.setBody(body);

        //deep copy
        Comment updateComment = new Comment();
        updateComment.setId(comment.getId());
        updateComment.setBody(body);
        updateComment.setName(comment.getName());
        updateComment.setEmail(comment.getEmail());

        //define behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updateComment);

        //execute
        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        //assertions
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentResponse.getId(), commentDto.getId());
        Assertions.assertEquals(commentResponse.getName(), commentDto.getName());
        Assertions.assertEquals(commentResponse.getEmail(), commentDto.getEmail());
        Assertions.assertEquals(commentResponse.getBody(), commentDto.getBody());
    }

    @Test
    void testUpdateComment_BlogAPIException() {
        comment.setPost(new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        //define the behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        //execute and assertions
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testDeleteComment() {
        //define the behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        //execute
        commentService.deleteComment(1L, 1L);

        //verify
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    void testDeleteComment_BlogAPIException() {
        comment.setPost(new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        //define the behaviors
        when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        //execute and assertions
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));
    }

}
