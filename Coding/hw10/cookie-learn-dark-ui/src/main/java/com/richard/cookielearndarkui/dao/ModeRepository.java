package com.richard.cookielearndarkui.dao;

import com.richard.cookielearndarkui.entity.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {

    Optional<Mode> findModeBySessionId(String session);
}
