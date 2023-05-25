package com.chuwa.testing.dao.security;

import com.chuwa.testing.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByAccountOrEmail(String account, String email);
    Optional<User> findByAccount(String username);
    Boolean existsByAccount(String user);
    Boolean existsByEmail(String email);
}
