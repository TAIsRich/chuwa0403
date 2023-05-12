package com.richard.cookielearndarkui.dao.security;

import com.richard.cookielearndarkui.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByAccountOrEmail(String account, String email);

    Optional<User> findByAccount(String account);

    Boolean existsByAccount(String account);

    Boolean existsByEmail(String email);

}
