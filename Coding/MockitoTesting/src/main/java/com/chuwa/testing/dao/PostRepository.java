package com.chuwa.testing.dao;

import com.chuwa.testing.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select * from posts where create_date_time between :startTime and :endTime", nativeQuery = true)
    List<Post> getAllPostIdsByCreateDateBetweenStartTimeAndEndTime(LocalDateTime startTime, LocalDateTime endTime);
}
