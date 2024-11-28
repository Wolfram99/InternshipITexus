package org.example.Service.ServiceImpl;

import org.example.Entity.security.UserAccount;
import org.example.Service.UserAccountService;
import org.example.dto.JwtAuthenticationDto;
import org.example.dto.UserAccountCredentialsDto;
import org.example.repositories.UserAccountRepository;
import org.example.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider provider;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repository, PasswordEncoder passwordEncoder, JwtTokenProvider provider) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.provider = provider;
    }





    public JwtAuthenticationDto singIn(UserAccountCredentialsDto userAccountCredentialsDto) {
        UserAccount user = null;
        try {
            user = findByCredentials(userAccountCredentialsDto);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
        return provider.generatedAuthToken(user.getUsername());
    }





    public UserAccount findByUsername(String username){
        return repository.findByUsername(username).get();
    }

    @Override
    @Transactional
    public void insert(UserAccount user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }



    private UserAccount findByCredentials(UserAccountCredentialsDto userCredentialsDto) throws AuthenticationException {
        Optional<UserAccount> optionalUser = repository.findByUsername(userCredentialsDto.getUsername());
        if (optionalUser.isPresent()){
            UserAccount user = optionalUser.get();
            if (passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())){
                return user;
            }
        }


        throw new AuthenticationException("Username or password is not correct");

    }




}
