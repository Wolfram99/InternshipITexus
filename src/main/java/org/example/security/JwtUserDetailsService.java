package org.example.security;

import jakarta.persistence.Column;
import org.example.repositories.UserAccountRepository;
import org.example.security.jwt.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final UserAccountRepository repository;

    @Autowired
    public JwtUserDetailsService(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).map(JwtUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username) );
    }
}
