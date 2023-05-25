package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository  commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private CommentDto commentDto;
    private Comment comment;
    private Post post;


    @BeforeAll
    static void beforeAll(){
        logger.info("Start test");
    }

    @BeforeEach
    void setUp(){
        logger.info("set up Comment for each test");
        this.post = new Post(1L,"Mia","He","This is Mia He", LocalDateTime.now(),LocalDateTime.now());
        this.comment = new Comment(1L,"Min He","minhe@123.com","I like it");
        this.comment.setPost(post);
        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment,CommentDto.class);
    }


    @Test
    void testCreateComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDto commentResponse = commentService.createComment(post.getId(), commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    public void testCreateComment_ResourceNotFoundException(){
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id",1L));
        Assertions.assertThrows(ResourceNotFoundException.class,()->commentService.createComment(1L,commentDto));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        List<CommentDto> commentDtos = commentService.getCommentsByPostId(post.getId());

        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(1,commentDtos.size());
        CommentDto commentResponse = commentDtos.get(0);
        Assertions.assertEquals(commentDto.getName(),commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    void testGetCommentById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        CommentDto commentResponse = commentService.getCommentById(post.getId(), comment.getId());

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(),commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
    }

    @Test
    void testGetCommentsByPostId_ResourceNotFoundException(){
        Mockito.lenient().when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.getCommentById(1L,2L));

        Mockito.lenient().when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.getCommentById(1L,2L));

    }
    @Test
    void testGetCommentsByPostId_BlogAPIException(){
        Post post2 = new Post(2L,"Min","He","This is not the same post id", LocalDateTime.now(),LocalDateTime.now());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post2));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(post2.getId(), comment.getId()));

    }

    @Test
    void testUpdateComment() {
        String body = "update-" + comment.getBody();
        commentDto.setBody(body);
        Comment updateComment = new Comment();
        updateComment.setName(comment.getName());
        updateComment.setEmail(comment.getEmail());
        updateComment.setBody(body);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updateComment);

        CommentDto commentResponse = commentService.updateComment(post.getId(), comment.getId(), this.commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(),commentResponse.getName());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());


    }

    @Test
    void testUpdateComment_ResourceNotFoundException(){
        Mockito.lenient().when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.updateComment(1L,1L,commentDto));

        Mockito.lenient().when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.updateComment(1L,1L,commentDto));

    }
    @Test
    void testUpdateComment_BlogAPIException(){
        Post post2 = new Post(2L,"Min","He","This is not the same post id", LocalDateTime.now(),LocalDateTime.now());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post2));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(post2.getId(), comment.getId(),commentDto));

    }

    @Test
    void testDeleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L,1L);
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    void testDeleteComment_ResourceNotFoundException(){
        Mockito.lenient().when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.deleteComment(1L,1L));

        Mockito.lenient().when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment","id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class ,()->commentService.deleteComment(1L,1L));

    }
    @Test
    void testDeleteComment_BlogAPIException(){
        Post post2 = new Post(2L,"Min","He","This is not the same post id", LocalDateTime.now(),LocalDateTime.now());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post2));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(post2.getId(), comment.getId()));

    }

}