package com.sih.michael.civilized_reporting_api.security;

import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException("User with that name was not found! :"+username));
        return new AppUserDetails(user);
    }
}

