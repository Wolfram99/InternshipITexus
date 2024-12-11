package org.example.autheticationusers.security;

import org.example.autheticationusers.repository.UserAccountRepository;
import org.example.autheticationusers.security.jwt.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

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
