package com.chuwa.testing.batch;

import com.chuwa.testing.config.CronConfig;
import com.chuwa.testing.dao.CommentRepository;
import com.chuwa.testing.dao.PostRepository;
import com.chuwa.testing.entity.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ReportHandler {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public void getLast24HoursReport(){
        log.info("Scheduling Last24HoursReport report, delay 3 s");
        CronConfig.getScheduledExecutor().schedule(()->{
            try{
                reportGenerator();
            }catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }
        }, 3, TimeUnit.SECONDS);
    }

    private void reportGenerator() throws JsonProcessingException{
        log.info("report generating ...");
        LocalDateTime now = LocalDateTime.now();
        log.info(now.toString());
        LocalDateTime previousDay = now.minusDays(300);
        log.info(previousDay.toString());
        List<Post> postIds = postRepository.getAllPostIdsByCreateDateBetweenStartTimeAndEndTime(previousDay, now);
        log.info("total new posts: " + postIds.size());
        HashMap<Long, Long> hm = new HashMap<>(16);
        postIds.forEach((post) -> {
            log.info("generate post: " + post);
            Long count = commentRepository.countCommentsByPostIs(post);
            hm.put(post.getId(), count);
        });
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(hm);
        log.info(s);
    }
}
