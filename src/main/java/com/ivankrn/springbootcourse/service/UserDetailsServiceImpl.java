package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.database.UserRepository;
import com.ivankrn.springbootcourse.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        UserDetails userDetails = User.withUsername(myUser.getUsername())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
        return userDetails;
    }

}
