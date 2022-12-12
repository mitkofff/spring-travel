package com.tu.travel.service.Impl;

import com.tu.travel.model.services.SecurityUserModel;
import com.tu.travel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService  implements UserDetailsService {
    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("qwqwqwqwqwqwqwq");
        SecurityUserModel user = userRepository
                .findByEmail(email)
                .map(SecurityUserModel::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found:" + email));
        System.out.println("qwewqeqweqweqweqwewqewqeqwe");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return user;
    }
}