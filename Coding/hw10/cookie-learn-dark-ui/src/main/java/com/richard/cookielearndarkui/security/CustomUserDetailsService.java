package com.richard.cookielearndarkui.security;

import com.richard.cookielearndarkui.dao.security.UserRepository;
import com.richard.cookielearndarkui.entity.security.Role;
import com.richard.cookielearndarkui.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String accountOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByAccountOrEmail(accountOrEmail, accountOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with account or email" + accountOrEmail));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }
}
