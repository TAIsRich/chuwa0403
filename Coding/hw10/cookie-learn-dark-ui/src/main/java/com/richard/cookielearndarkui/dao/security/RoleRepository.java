package com.richard.cookielearndarkui.dao.security;

import com.richard.cookielearndarkui.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
