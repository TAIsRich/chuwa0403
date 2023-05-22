package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void createComment_ValidPostIdAndCommentDto_ReturnsCommentDto() {
        // Arrange
        long postId = 1;
        CommentDto commentDto = new CommentDto();
        Comment comment = new Comment();
        Comment savedComment = new Comment();
        CommentDto savedCommentDto = new CommentDto();
        Post post = new Post();
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.save(comment)).thenReturn(savedComment);
        when(modelMapper.map(commentDto, Comment.class)).thenReturn(comment);  // Mock the mapping from commentDto to Comment
        when(modelMapper.map(savedComment, CommentDto.class)).thenReturn(savedCommentDto);

        // Act
        CommentDto result = commentService.createComment(postId, commentDto);

        // Assert
        assertNotNull(result);
        assertEquals(savedCommentDto, result);
        verify(commentRepository).save(comment);
        verify(modelMapper).map(commentDto, Comment.class);
        verify(modelMapper).map(savedComment, CommentDto.class);
    }


    @Test
    void createComment_InvalidPostId_ThrowsResourceNotFoundException() {
        // Arrange
        long postId = 1;
        CommentDto commentDto = new CommentDto();
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(postId, commentDto));
        verify(commentRepository, never()).save(any(Comment.class));
        verify(modelMapper, never()).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void getCommentsByPostId_ValidPostId_ReturnsListOfCommentDto() {
        // Arrange
        long postId = 1;
        List<Comment> comments = Arrays.asList(new Comment(), new Comment());
        List<CommentDto> expectedCommentDtos = Arrays.asList(new CommentDto(), new CommentDto());
        when(commentRepository.findByPostId(postId)).thenReturn(comments);
        when(modelMapper.map(any(Comment.class), eq(CommentDto.class))).thenReturn(new CommentDto());

        // Act
        List<CommentDto> result = commentService.getCommentsByPostId(postId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedCommentDtos.size(), result.size());
        assertEquals(expectedCommentDtos.get(0).getClass(), result.get(0).getClass());
        verify(commentRepository).findByPostId(postId);
        verify(modelMapper, times(comments.size())).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void getCommentById_InvalidPostId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(postId, commentId));
        verify(commentRepository, never()).findById(anyLong());
        verify(modelMapper, never()).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void getCommentById_InvalidCommentId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(postId);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(postId, commentId));
        //verify(commentRepository, never()).findById(anyLong());
        verify(modelMapper, never()).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void updateComment_ValidPostIdCommentIdAndCommentDto_ReturnsUpdatedCommentDto() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        CommentDto commentDto = new CommentDto();
        Comment comment = new Comment();
        Comment updatedComment = new Comment();
        CommentDto updatedCommentDto = new CommentDto();
        Post post = new Post();
        post.setId(postId);
        comment.setId(commentId);
        comment.setPost(post);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));
        when(commentRepository.save(comment)).thenReturn(updatedComment);
        when(modelMapper.map(updatedComment, CommentDto.class)).thenReturn(updatedCommentDto);

        // Act
        CommentDto result = commentService.updateComment(postId, commentId, commentDto);

        // Assert
        assertNotNull(result);
        assertEquals(updatedCommentDto, result);
        verify(postRepository).findById(postId);
        verify(commentRepository).findById(commentId);
        verify(commentRepository).save(comment);
        verify(modelMapper).map(updatedComment, CommentDto.class);
    }

    @Test
    void updateComment_InvalidPostId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        CommentDto commentDto = new CommentDto();
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(postId, commentId, commentDto));
        verify(commentRepository, never()).findById(anyLong());
        verify(commentRepository, never()).save(any(Comment.class));
        verify(modelMapper, never()).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void updateComment_InvalidCommentId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        CommentDto commentDto = new CommentDto();
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(postId);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(postId, commentId, commentDto));
        //verify(commentRepository, never()).findById(anyLong());
        verify(commentRepository, never()).save(any(Comment.class));
        verify(modelMapper, never()).map(any(Comment.class), eq(CommentDto.class));
    }

    @Test
    void deleteComment_ValidPostIdAndCommentId_DeletesComment() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(postId);
        comment.setId(commentId);
        comment.setPost(post);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        // Act
        commentService.deleteComment(postId, commentId);

        // Assert
        verify(postRepository).findById(postId);
        verify(commentRepository).findById(commentId);
        verify(commentRepository).delete(comment);
    }

    @Test
    void deleteComment_InvalidPostId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(postId, commentId));
        verify(commentRepository, never()).findById(anyLong());
        verify(commentRepository, never()).delete(any(Comment.class));
    }

    @Test
    void deleteComment_InvalidCommentId_ThrowsResourceNotFoundException() {
        // Arrange
        Long postId = 1L;
        Long commentId = 1L;
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(postId);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(postId, commentId));
        //verify(commentRepository, never()).findById(anyLong());
        verify(commentRepository, never()).delete(any(Comment.class));
    }

}
