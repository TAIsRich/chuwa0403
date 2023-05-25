package com.chuwa.redbook.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private CommentDto CommentDto;
    private Comment comment;

    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("----------Start Comment Test----------");

    }

    @BeforeEach
    void setup() {
        logger.info("Set up Post for Testing");
        this.post = new Post(1L, "test post 1", "hw12", "Comment Service IMPL", LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L, "comment name", "1234@gmail.com", "comment body", post, LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.CommentDto = modelMapper.map(this.comment, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.of(post));
        CommentDto savedComment = commentService.createComment(1L, CommentDto);
        assertNotNull(savedComment);
        assertEquals(CommentDto.getId(), savedComment.getId());
        assertEquals(CommentDto.getName(), savedComment.getName());
        assertEquals(CommentDto.getEmail(), savedComment.getEmail());
    }

    @Test
    void testCreateComment_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, CommentDto));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        Mockito.when(commentRepository.findByPostId(anyLong())).thenReturn(comments);

        List<CommentDto> ans = commentService.getCommentsByPostId(1L);
        assertNotNull(ans);
        assertEquals(1, ans.size());
        assertEquals(comments.get(0).getId(), ans.get(0).getId());
    }

    @Test
    void testGetCommentById() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));

        CommentDto returnedCommentDto = commentService.getCommentById(1L, 1L);
        assertNotNull(returnedCommentDto);
        assertEquals(this.CommentDto.getId(), returnedCommentDto.getId());
        assertEquals(this.CommentDto.getName(), returnedCommentDto.getName());
    }

    @Test
    void testGetCommentById_postRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testGetCommentById_commentRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testGetCommentById_id_not_equals() {
        Post post1 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi", LocalDateTime.now(), LocalDateTime.now());

        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.of(post1));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.of(comment));

        assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testUpdateComment() {
        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));

        CommentDto dtoUpdate = new CommentDto(1L, "comment name2", "2@g.com", "body2");

        CommentDto updatedComment = commentService.updateComment(1L, 1L, dtoUpdate);
        assertNotNull(updatedComment);
        assertEquals(dtoUpdate.getId(), updatedComment.getId());
        assertEquals(dtoUpdate.getName(), updatedComment.getName());
        assertEquals(dtoUpdate.getEmail(), updatedComment.getEmail());
        assertEquals(dtoUpdate.getBody(), updatedComment.getBody());
    }

    @Test
    void testUpdateComment_id_not_equals() {
        Post post1 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.of(post1));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));

        assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, any()));
    }

    @Test
    void testUpdateComment_postRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "Id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, any()));
    }

    @Test
    void testUpdateComment_commentRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Comment", "Id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, any()));
    }

    @Test
    void testDeleteComment() {
        Mockito.doNothing().when(commentRepository).delete(any(Comment.class));
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));

        commentService.deleteComment(1L, 1L);
        Mockito.verify(commentRepository, Mockito.times(1)).delete(any(Comment.class));
    }

    @Test
    void testDeleteComment_postRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "Id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_commentRepository_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Comment", "Id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_id_not_equals() {
        Post post1 = new Post(2L, "xiao ruishi", "wanqu", "wanqu xiao ruishi", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.of(post1));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));
        assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));
    }


}
