package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
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
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepositoryMock;


    @Spy
    private ModelMapper modelMapper;


    @InjectMocks
    private PostServiceImpl postService;

    private PostDTO postDTO;
    private Post post;

    @BeforeAll
    static void beforeAll() {
        logger.info("Start test");
    }

    @BeforeEach
    void setup() {
        logger.info("set up Post for each test");
        this.post = new Post(1L, "xiao ruishi", "wanqu", "wanqu xiao ruishi", LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.postDTO = modelMapper.map(this.post, PostDTO.class);
    }

    @Test
    public void testCreatePost() {
        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(post);
        PostDTO savedPost = postService.createPost(postDTO);
        Assertions.assertNotNull(savedPost);
        Assertions.assertEquals(postDTO.getTitle(), savedPost.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), savedPost.getDescription());
        Assertions.assertEquals(postDTO.getContent(), savedPost.getContent());
    }

    @Test
    public void testGetPostById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        PostDTO postResponse = postService.getPostById(1L);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDTO.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetAllPost() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Mockito.when(postRepositoryMock.findAll()).thenReturn(posts);

        List<PostDTO> postDTOS = postService.getAllPost();
        Assertions.assertNotNull(postDTOS);
        Assertions.assertEquals(1, postDTOS.size());
        Assertions.assertEquals(postDTOS.get(0).getTitle(), postDTO.getTitle());
        Assertions.assertEquals(postDTOS.get(0).getContent(), postDTO.getContent());
        Assertions.assertEquals(postDTOS.get(0).getDescription(), postDTO.getDescription());
    }

    @Test
    public void testGetPostById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1L));
    }

    @Test
    public void testUpdatePost() {
        String desctiption = "Updated";
        postDTO.setDescription(desctiption);

        Post updatedPost = new Post(post.getId(), post.getTitle(), postDTO.getDescription(), post.getContent(), post.getCreateDateTime(), post.getUpdateDateTime());

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(updatedPost);

        PostDTO updatedPostResponse = postService.updatePost(postDTO, 1L);

        Assertions.assertNotNull(updatedPostResponse);
        Assertions.assertEquals(postDTO.getTitle(), updatedPostResponse.getTitle());
        Assertions.assertEquals(postDTO.getDescription(), updatedPostResponse.getDescription());
        Assertions.assertEquals(postDTO.getContent(), updatedPostResponse.getContent());
    }

    @Test
    public void testUpdatedPost_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.updatePost(postDTO, 1L));
    }

    @Test
    public void testDeletePostById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.doNothing().when(postRepositoryMock).delete(ArgumentMatchers.any(Post.class));
        postService.deletePostById(1L);

        Mockito.verify(postRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Post.class));
    }

    @Test
    public void testDeletePostById_ResourceNotFoundException() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.deletePostById(1L));
    }

    @Test
    public void testGetAllPost_Pageable() {
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.ASC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements / pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepositoryMock.findAll(ArgumentMatchers.any(Pageable.class)))
                .thenReturn(pagePosts);

        PostResponse response = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(pageNo, response.getPageNo());
        Assertions.assertEquals(pageSize, response.getPageSize());
        Assertions.assertEquals(totalElements, response.getTotalElements());
        Assertions.assertEquals(totalPages, response.getTotalPages());
        Assertions.assertEquals(isLast, response.isLast());

        List<PostDTO> content = response.getContent();

        Assertions.assertNotNull(content);
        Assertions.assertEquals(content.size(), posts.size());
        Assertions.assertNotNull(content.get(0));
        Assertions.assertEquals(content.get(0).getContent(), postDTO.getContent());
        Assertions.assertEquals(content.get(0).getDescription(), postDTO.getDescription());
        Assertions.assertEquals(content.get(0).getTitle(), postDTO.getTitle());
        Assertions.assertEquals(content.get(0).getId(), postDTO.getId());
    }

    @Test
    public void testGetAllPost_Pageable_SortDirDescending() {
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.DESC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements / pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepositoryMock.findAll(ArgumentMatchers.any(Pageable.class)))
                .thenReturn(pagePosts);

        PostResponse response = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(pageNo, response.getPageNo());
        Assertions.assertEquals(pageSize, response.getPageSize());
        Assertions.assertEquals(totalElements, response.getTotalElements());
        Assertions.assertEquals(totalPages, response.getTotalPages());
        Assertions.assertEquals(isLast, response.isLast());

        List<PostDTO> content = response.getContent();
        Assertions.assertNotNull(content);
        Assertions.assertEquals(content.size(), posts.size());
        Assertions.assertNotNull(content.get(0));
        Assertions.assertEquals(content.get(0).getContent(), postDTO.getContent());
        Assertions.assertEquals(content.get(0).getDescription(), postDTO.getDescription());
        Assertions.assertEquals(content.get(0).getTitle(), postDTO.getTitle());
        Assertions.assertEquals(content.get(0).getId(), postDTO.getId());
    }
}
