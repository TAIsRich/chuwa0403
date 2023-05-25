package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.*;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Post post;
    private Comment comment;
    private CommentDto commentDto;



    @BeforeAll
    static void beforeAll(){
        logger.info("START CommentService Test");
    }


    @BeforeEach
    void setUp() {

        logger.info("This is setup phase for each test");

        this.post = new Post(1L, "postTitle", "postDescription", "postContent", LocalDateTime.now(), LocalDateTime.now());
        this.comment = new Comment(1L,"commentName","comment@comment.com","commentBody");

        this.modelMapper = new ModelMapper();
        this.commentDto = modelMapper.map(comment, CommentDto.class);
    }

    @Test
    void testCreateComment() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.of(post));
        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto commentResp= commentService.createComment(1L, commentDto);

        assertNotNull(commentResp);
        assertEquals(commentDto.getId(), commentResp.getId());
        assertEquals(commentDto.getName(), commentResp.getName());
        assertEquals(commentDto.getEmail(), commentResp.getEmail());
    }

    @Test
    void createComment_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        Mockito.when(commentRepository.findByPostId(anyLong())).thenReturn(comments);

        List<CommentDto> resList = commentService.getCommentsByPostId(1L);
        assertNotNull(resList);
        assertEquals(1, resList.size());
        assertEquals(comments.get(0).getId(), resList.get(0).getId());
        assertEquals(comments.get(0).getName(), resList.get(0).getName());
        assertEquals(comments.get(0).getEmail(), resList.get(0).getEmail());
    }

    @Test
    void testGetCommentById() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));

        CommentDto commentResp = commentService.getCommentById(1L, 1L);
        assertNotNull(commentResp);
        assertEquals(commentDto.getId(), commentResp.getId());
        assertEquals(commentDto.getName(), commentResp.getName());
        assertEquals(commentDto.getEmail(), commentResp.getEmail());
    }

    @Test
    void testGetCommentsByPostId_post_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testGetCommentsByPostId_comment_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testUpdateComment() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));
        Mockito.when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto commentResp = commentService.updateComment(1L, 1L, commentDto);

        assertNotNull(commentResp);
        assertEquals(commentDto.getId(), commentResp.getId());
        assertEquals(commentDto.getName(), commentResp.getName());
        assertEquals(commentDto.getEmail(), commentResp.getEmail());
    }

    @Test
    void testUpdateComment_post_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testUpdateComment_comment_ResourceNotFoundException() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    public void testGetCommentById_BlogAPIException() {
        Post anotherPost = new Post(2L, "anotherPostTitle", "anotherPostDescription", "anotherPostContent", LocalDateTime.now(), LocalDateTime.now());
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(anotherPost));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(comment));

        assertThrows(BlogAPIException.class, () -> commentService.getCommentById(2L, 1L));
    }

    @Test
    void testDeleteComment() {
        Mockito.when(postRepository.findById(anyLong())).thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(anyLong())).thenReturn(Optional.ofNullable(comment));
        Mockito.doNothing().when(commentRepository).delete(any(Comment.class));
        commentService.deleteComment(1L, 1L);
        Mockito.verify(commentRepository, Mockito.times(1)).delete(any(Comment.class));
    }
}

