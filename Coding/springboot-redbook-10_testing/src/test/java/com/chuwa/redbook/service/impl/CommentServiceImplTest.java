package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDto;
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
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository commentRepositoryMock;
    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;
    @InjectMocks
    private PostServiceImpl postService;

    private CommentDto commentDto;
    private Comment comment;
    private PostDto postDto;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("Start test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Comment for each test");

        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());

        this.comment = new Comment(47084613L, "yuanchen", "yc47084613@gmail.com", "jdgdkufgfgksdjs");

        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.postDto = modelMapper.map(this.post, PostDto.class);
    }

    @Test
    public void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(comment);
        // Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

//        PostDto postResponse = postService.createPost(postDto);
        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        Assertions.assertNotNull(commentResponse);
//        Assertions.assertEquals();
//        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
        Assertions.assertEquals(this.commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(this.commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(this.commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testCreateComment_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> commentService.createComment(1L, commentDto));

    }


    @Test
    public void testGetCommentsByPostId() {

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong())).thenReturn(comments);

        List<CommentDto> commentResponses = commentService.getCommentsByPostId(1L);

        Assertions.assertNotNull(commentResponses);
        Assertions.assertEquals(1, commentResponses.size());
        CommentDto commentResponse = commentResponses.get(0);
        Assertions.assertEquals(this.commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(this.commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(this.commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testGetCommentById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        CommentDto commentResponse = commentService.getCommentById(1L, 47084613L);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(this.commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(this.commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(this.commentDto.getEmail(), commentResponse.getEmail());
    }


    @Test
    public void testGetCommentById_BlogAPIException() {
        Post post1 = new Post(2L, "menmen", "menmenmenmenmenmen", "lalalalalalala", LocalDateTime.now(), LocalDateTime.now());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                        .thenReturn(Optional.of(post1));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post"));

        Assertions.assertThrows(BlogAPIException.class,
                () -> commentService.getCommentById(2L, 47084613L));
    }

    @Test
    public void testGetCommentById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> commentService.createComment(1L, commentDto));

    }

    @Test
    public void testUpdateComment() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class))).thenReturn(comment);

        CommentDto commentResponse = commentService.updateComment(1L, 47084613L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(this.commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(this.commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(this.commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testUpdateComment_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                        .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 47084613L));

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> commentService.updateComment(1L, 47084613L, commentDto));
    }

    @Test
    public void testDeleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 47084613L);

        Mockito.verify(commentRepositoryMock, Mockito.times(1))
                .delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteComment_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                        .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 47084613L));

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> commentService.deleteComment(1L, 47084613L));
    }
}
