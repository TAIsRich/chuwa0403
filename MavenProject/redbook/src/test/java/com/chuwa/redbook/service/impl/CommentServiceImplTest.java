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

import java.time.LocalDateTime;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);
    @Mock
    private PostRepository postRepositoryMock;
    @Mock
    private CommentRepository commentRepositoryMock;

    @InjectMocks
    private PostServiceImpl postService;
    @InjectMocks
    private CommentServiceImpl commentService;

    @Spy
    private ModelMapper modelMapper;

    private PostDto postDto;
    private Post post;
    private CommentDto commentDto;
    private Comment comment;
    private Comment comment2;
    private Set<Comment> comments;
    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("Set up post and comment for each test");
        this.post = new Post(1L, "Joe", "Test Post", "Test TEST Test",
                LocalDateTime.now(), LocalDateTime.now());

        this.comment = new Comment(1, "Joe", "Joe@gmail.com", "Good Post!");
        this.comment2 = new Comment(2, "Alice", "alice@example.com", "Nice article!");

        this.comments = new HashSet<>();
        this.comments.add(comment);
        this.comments.add(comment2);
        this.post.setComments(comments);

        comment.setPost(post);
        comment2.setPost(post);

//        this.postDto = modelMapper.map(this.post, PostDto.class);
        this.commentDto = modelMapper.map(comments, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        // Mock the postRepository to return a post object
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(post));


        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(comment.getId(), commentResponse.getId());
        Assertions.assertEquals(comment.getName(), commentResponse.getName());
        Assertions.assertEquals(comment.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(comment.getBody(), commentResponse.getBody());
    }

    @Test
    void testGetCommentsByPostId() {
        long postId = 1L;
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);
        Mockito.when(commentRepositoryMock.findByPostId(postId)).thenReturn(commentList);

//        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
//                .thenReturn(Optional.of(post));

        List<CommentDto> commentResponseList = commentService.getCommentsByPostId(postId);

        // Assertions
        Assertions.assertNotNull(commentResponseList);
        Assertions.assertEquals(commentList.size(), commentResponseList.size());
    }

    @Test
    void testGetCommentById() {
        long postId = 1L;
        long commentId = 1;

        Mockito.when(postRepositoryMock.findById(postId))
                .thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(commentId))
                .thenReturn(Optional.of(comment));

        CommentDto commentResponse = commentService.getCommentById(postId, commentId);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(comment.getId(), commentResponse.getId());
        Assertions.assertEquals(comment.getName(), commentResponse.getName());
        Assertions.assertEquals(comment.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(comment.getBody(), commentResponse.getBody());


    }

    @Test
    public void testGetCommentById_ResourceNotFoundException() {
        long postId = 1L;
        long commentId = 1L;
        Mockito.when(postRepositoryMock.findById(postId)).thenReturn(Optional.of(post));

        Mockito.when(commentRepositoryMock.findById(commentId)).thenThrow(new ResourceNotFoundException("Comment", "id", commentId));

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> commentService.getCommentById(postId, commentId));
    }

    @Test
    public void testGetCommentById_BlogAPIException() {
        long postId = 1L;
        long commentId = 1;

        // Mock the post repository to return a post with a different ID than the specified postId
        Mockito.when(postRepositoryMock.findById(postId))
                .thenReturn(Optional.of(new Post(2L, "Alice", "Another Post", "Another Test", LocalDateTime.now(), LocalDateTime.now())));

        // Mock the comment repository to return the comment
        Mockito.when(commentRepositoryMock.findById(commentId))
                .thenReturn(Optional.of(comment));

        // Assert that a BlogAPIException is thrown
        Assertions.assertThrows(BlogAPIException.class, () -> {
            commentService.getCommentById(postId, commentId);
        });
    }
    @Test
    void testUpdateComment() {
        long postId = 1L;
        long commentId = 1;
        CommentDto updatedCommentDto = new CommentDto(commentId, "Updated Name", "updated@example.com", "Updated Body");
        Comment updatedComment = new Comment(commentId, "Updated Name", "updated@example.com", "Updated Body");


        Mockito.when(postRepositoryMock.findById(postId)).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(commentId)).thenReturn(Optional.of(comment));
        Mockito.when(commentRepositoryMock.save(Mockito.any(Comment.class))).thenReturn(updatedComment);

        // Mock modelMapper to map the updated comment
        Mockito.when(modelMapper.map(updatedComment, CommentDto.class)).thenReturn(updatedCommentDto);

        // Call the method under test
        CommentDto result = commentService.updateComment(postId, commentId, updatedCommentDto);

        // Verify the interactions and assertions
        Mockito.verify(commentRepositoryMock).findById(commentId);
        Mockito.verify(commentRepositoryMock).save(comment);
        Mockito.verify(modelMapper).map(updatedComment, CommentDto.class);
        Assertions.assertEquals(updatedCommentDto, result);
    }

    @Test
    public void testUpdateComment_ResourceNotFoundException() {
        long postId = 1L;
        long commentId = 1L;
        CommentDto updatedCommentDto = new CommentDto(commentId, "Updated Name", "updated@example.com", "Updated Body");

        // Mock post repository to throw ResourceNotFoundException
        Mockito.when(postRepositoryMock.findById(postId)).thenReturn(Optional.empty());

        // Call the method under test and assert that it throws ResourceNotFoundException
        Assertions.assertThrows(ResourceNotFoundException.class, () ->
                commentService.updateComment(postId, commentId, updatedCommentDto));
    }

    @Test
    void testUpdateComment_BlogAPIException() {
        long postId = 1L;
        long commentId = 1;

        // Mock the post repository to return a post with a different ID than the specified postId
        Mockito.when(postRepositoryMock.findById(postId))
                .thenReturn(Optional.of(new Post(2L, "Alice", "Another Post", "Another Test", LocalDateTime.now(), LocalDateTime.now())));

        // Mock the comment repository to return the comment
        Mockito.when(commentRepositoryMock.findById(commentId))
                .thenReturn(Optional.of(comment));

        // Create a CommentDto with updated data
        CommentDto updatedCommentDto = new CommentDto();
        updatedCommentDto.setName("Updated Name");
        updatedCommentDto.setEmail("updated@example.com");
        updatedCommentDto.setBody("Updated Body");

        // Assert that a BlogAPIException is thrown
        Assertions.assertThrows(BlogAPIException.class, () -> {
            commentService.updateComment(postId, commentId, updatedCommentDto);
        });
    }


    @Test
    void testDeleteComment() {
        long postId = 1L;
        long commentId = 1L;
        Mockito.when(postRepositoryMock.findById(postId)).thenReturn(Optional.of(post));
        Mockito.when(commentRepositoryMock.findById(commentId)).thenReturn(Optional.of(comment));

        // Call the method under test
        commentService.deleteComment(postId, commentId);

        // Verify that the post and comment repositories were called
        Mockito.verify(postRepositoryMock).findById(postId);
        Mockito.verify(commentRepositoryMock).findById(commentId);
        Mockito.verify(commentRepositoryMock).delete(comment);
    }

    @Test
    public void testDeleteComment_ResourceNotFoundException() {
        // Mock post and comment data
        long postId = 1L;
        long commentId = 1L;

        // Mock post repository to return empty optional, simulating a ResourceNotFoundException
        Mockito.when(postRepositoryMock.findById(postId)).thenReturn(Optional.empty());

        // Call the method under test and assert that it throws ResourceNotFoundException
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            commentService.deleteComment(postId, commentId);
        });
    }

    @Test
    void testDeleteComment_BlogAPIException() {
        long postId = 1L;
        long commentId = 1;

        // Mock the post repository to return a post with a different ID than the specified postId
        Mockito.when(postRepositoryMock.findById(postId))
                .thenReturn(Optional.of(new Post(2L, "Alice", "Another Post", "Another Test", LocalDateTime.now(), LocalDateTime.now())));

        // Mock the comment repository to return the comment
        Mockito.when(commentRepositoryMock.findById(commentId))
                .thenReturn(Optional.of(comment));

        // Assert that a BlogAPIException is thrown
        Assertions.assertThrows(BlogAPIException.class, () -> {
            commentService.deleteComment(postId, commentId);
        });
    }

}