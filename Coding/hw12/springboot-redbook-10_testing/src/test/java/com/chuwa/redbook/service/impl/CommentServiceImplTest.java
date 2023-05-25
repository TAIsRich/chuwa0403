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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    private Post post;
    private Comment comment;
    private CommentDto commentDto;
    private long postId = 1l;

    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @Spy
    private ModelMapper modelMapperMock;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeAll
    static void beforeAll() {
        logger.info("Start test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Comment for each test");

        this.post = new Post(postId, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(10l, "ABC", "ABC@gmail", "ABCDEFG");
        this.comment.setPost(post);
        ModelMapper modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(this.comment, CommentDto.class);
    }

    @Test
    public void testCreateComment() {
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class))).thenReturn(Optional.of(post));

        CommentDto commentResponse = commentService.createComment(postId, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());

    }

    @Test
    public void testGetCommentsByPostId() {
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.any(Long.class)))
                .thenReturn(Arrays.asList(comment));

        List<CommentDto> commentDtos = commentService.getCommentsByPostId(postId);

        Assertions.assertNotNull(commentDtos);
        Assertions.assertEquals(1, commentDtos.size());
        CommentDto commentResponse = commentDtos.get(0);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testGetCommandById_Successfully() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));

        CommentDto commentResponse = commentService.getCommentById(postId, 10l);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testGetCommandById_ResourceNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 2l));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(postId, 2l));
    }

    @Test
    public void testGetCommandById_BlogAPIException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));

        comment.setPost(new Post(100l, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentById(postId, 10l));
    }

    @Test
    public void testUpdateComment_Successfully() {
        String body = "UPDATED - " + comment.getBody();
        commentDto.setBody(body);

        Comment updateComment = new Comment();
        updateComment.setId(comment.getId());
        updateComment.setName(comment.getName());
        updateComment.setEmail(comment.getEmail());
        updateComment.setBody(body);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updateComment);

        CommentDto commentResponse = commentService.updateComment(postId, 10l, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
    }

    @Test
    public void testUpdateComment_ResourceNotFound() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 2l));


        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(postId, 2l));
    }

    @Test
    public void testUpdateComment_BlogAPIException() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));

        comment.setPost(new Post(100l, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(postId, 10l, commentDto));
    }

    @Test
    public void testDeleteComment_Successfully() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));


        commentService.deleteComment(postId, 10l);

        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    public void testDeleteComment_ResourceNotFound() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 2l));


        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(postId, 2l));
    }

    @Test
    public void testDeleteComment_BlogAPIException() {

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(post));
        comment.setPost(new Post(100l, "xiao ruishi", "wanqu", "wanqu xiao ruishi",
                LocalDateTime.now(), LocalDateTime.now()));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(postId, 10l));
    }

}
