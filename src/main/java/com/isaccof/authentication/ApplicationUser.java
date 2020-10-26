package com.isaccof.authentication;

import com.isaccof.repository.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class ApplicationUser implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    UserEntity userEntity;
  /*  public ApplicationUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
*/

    public static ApplicationUser fromUserEntityToApplicationUser(UserEntity userEntity) {
        ApplicationUser c = new ApplicationUser();
        c.username = userEntity.getUserName();
        c.password = userEntity.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRoleEntity().getName()));
        return c;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userEntity.getRole());

        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

