package com.perfectsqaure.SpringSecurity.security;

import static com.perfectsqaure.SpringSecurity.security.ApplicationUserPermission.USER_READ;
import static com.perfectsqaure.SpringSecurity.security.ApplicationUserPermission.USER_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(USER_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE));

    private final Set<ApplicationUserPermission> permissionSet;

    ApplicationUserRole(Set<ApplicationUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationUserPermission> getPermission(){
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermission().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
