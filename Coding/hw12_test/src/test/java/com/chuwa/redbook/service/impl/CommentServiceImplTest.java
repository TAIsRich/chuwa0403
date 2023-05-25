package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostResponse;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private CommentRepository commentRepositoryMock;
    @Mock
    private PostRepository postRepositoryMock;
    @Spy
    private ModelMapper modelMapper;
    @InjectMocks
    private PostServiceImpl postService;
    @InjectMocks
    private CommentServiceImpl commentService;
    private PostDto postDto;
    private Post post;
    private CommentDto commentDto;
    private Comment comment;
    private List<CommentDto> commentDtoList;
    private List<Comment> commentList;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(6L, "qwer", "qwee", "qwerqw",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(2L,"comment1","test@test.com","testcommentbody");
        ModelMapper modelMapper = new ModelMapper();
        this.comment.setPost(this.post);
        this.postDto = modelMapper.map(this.post, PostDto.class);
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
        this.commentDtoList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.commentDtoList.add(this.commentDto);
        this.commentList.add(this.comment);
    }
    @Test
    public void testCreateComment(){
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        CommentDto commentResponse = commentService.createComment(post.getId(),commentDto);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }
    @Test
    public void testGetCommentsByPostId(){
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.any(Long.class)))
                .thenReturn(commentList);
        List<CommentDto> commentResponse = commentService.getCommentsByPostId(post.getId());
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDtoList, commentResponse);
    }
    @Test
    public void testGetCommentById(){
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        CommentDto commentResponse = commentService.getCommentById(post.getId(),comment.getId());
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testGetCommentById_CommentNotBelong(){
        Post tempPost = new Post(7L, "qwer", "qwee", "qwerqw",
                LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(tempPost));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(tempPost.getId(),comment.getId()));
    }
    @Test
    public void testUpdateComment(){
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);
        CommentDto commentResponse = commentService.updateComment(post.getId(),comment.getId(),commentDto);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testUpdateComment_CommentNotBelong(){
        Post tempPost = new Post(7L, "qwer", "qwee", "qwerqw",
                LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(tempPost));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(tempPost.getId(),comment.getId(),commentDto));
    }
    @Test
    public void testDeleteComment(){
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));
        commentService.deleteComment(post.getId(),comment.getId());
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteComment_CommentNotBelong(){
        Post tempPost = new Post(7L, "qwer", "qwee", "qwerqw",
                LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(tempPost));
        
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(tempPost.getId(),comment.getId()));
    }

}
