package com.isaccof.securityconfig;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.isaccof.securityconfig.ApplicationUserPersmission.*;


public enum ApplicationUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USERS_READ,USERS_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(USERS_READ));

    private final Set<ApplicationUserPersmission> permissions;

    ApplicationUserRole(Set<ApplicationUserPersmission> permissions) {
        this.permissions = permissions;
    }
    public Set<ApplicationUserPersmission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities(){

        Set<SimpleGrantedAuthority> permissions=getPermissions().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissions;
    }
}

