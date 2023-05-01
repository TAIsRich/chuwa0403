package com.chuwa.jdbcTemplate.dao.impl;

import com.chuwa.jdbcTemplate.dao.PostDao;
import com.chuwa.jdbcTemplate.entity.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private JdbcTemplate jdbcTemplate;

    public PostDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(sql, new Object[]{id}, new PostMapper());
        return post;
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());
        return posts;
    }

    @Override
    public void save(Post post) {
        String sql = "INSERT INTO posts (title, description, content) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getContent());
    }

    @Override
    public void update(Post post) {
        String sql = "UPDATE posts SET title = ?, description = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getContent(), post.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    // PostMapper is a custom RowMapper implementation to map rows to Post objects
    private class PostMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("title"));
            post.setDescription(rs.getString("description"));
            post.setContent(rs.getString("content"));
            return post;
        }
    }
}

