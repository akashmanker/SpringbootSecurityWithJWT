package com.akashcodez.config;

import com.akashcodez.entity.User;
import com.akashcodez.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsLoader implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsLoader.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userByUserEmail = userRepository.findByUserEmail(username);

        if (userByUserEmail == null) {
            logger.warn("User not found with email: {}", username);
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        logger.info("Loaded user: {}, with role: {}", userByUserEmail.getUserEmail(), userByUserEmail.getRole());

        return userByUserEmail;
    }
}