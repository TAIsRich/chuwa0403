package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;

import java.sql.*;

public class JdbcTemplate {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/redbook";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    public Post getAllPlayers(int id) throws Exception {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1, load Driver
            Class.forName(DRIVER);
            // 2， connect to Database;
            conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            // 3， define sql statement
            String sql = "SELECT * FROM POSTS";
            // 4, create a statement object
            stmt = conn.createStatement();
            // 5, use stmt object to execute sql statement;
            rs = stmt.executeQuery(sql); // the result is return to ResultSet
            while(rs.next()) {
            // 6, get ResultSet's data to java object(employee)
                post.setId((long) rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
                post.setContent(rs.getString("content"));
            }
            return post;
        } catch (SQLException e) {
        } finally { // 7, close conections and other resource.
            rs.close();
            stmt.close();
            conn.close();
        }
        return null;
    }
}
