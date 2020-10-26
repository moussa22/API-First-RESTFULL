package com.isaccof.authentication;

import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class ApplicationUserService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Could not fund user");
        }

        return ApplicationUser.fromUserEntityToApplicationUser(userEntity);

    }
}

